package com.example.weather.mainModule.view

import android.Manifest
import android.content.pm.PackageManager
import android.location.Location
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.constraintlayout.motion.widget.Debug.getLocation
import androidx.core.app.ActivityCompat
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.weather.BR
import com.example.weather.R
import com.example.weather.common.entities.ForeCast
import com.example.weather.common.utils.CommonUtils
import com.example.weather.databinding.ActivityMainBinding
import com.example.weather.mainModule.view.adapters.ForecastAdapter
import com.example.weather.mainModule.view.adapters.OnclickListener
import com.example.weather.mainModule.viewModel.MainViewModel
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity(), OnclickListener {
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: ForecastAdapter
    private lateinit var fusedLocationClient: FusedLocationProviderClient
    private val MY_PERMISSIONS_REQUEST_LOCATION = 99


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        setUpViewModel()
        setUpObservers()
        setUpAdapter()
        setUpRecyclerView()
    }

    override fun onStart() {
        super.onStart()
        loadWeather()
    }

    private fun loadWeather(){
        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this)
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
            != PackageManager.PERMISSION_GRANTED
            && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION)
            != PackageManager.PERMISSION_GRANTED) {
            // Permission is not granted. Request the permission
            ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION), MY_PERMISSIONS_REQUEST_LOCATION)
        } else {
            fusedLocationClient.lastLocation.addOnSuccessListener { location: Location? ->
                location?.let {
                    lifecycleScope.launch{
                        binding.viewModel?.getWeatherAndForecast(it.latitude, it.longitude,
                            "6a5c325c9265883997730d09be2328e8", "","metric", "en")
                    }

                }
            }
        }
    }

    private fun setUpViewModel(){
        val vm: MainViewModel by viewModels()
        binding.lifecycleOwner = this
        binding.setVariable(BR.viewModel, vm)
    }

    private fun setUpObservers(){
        binding.viewModel.let {
            it?.getSnackbarMsg()?.observe(this){resMsg ->
                Snackbar.make(binding.root, resMsg, Snackbar.LENGTH_LONG).show()
            }
            it?.getResult()?.observe(this){result ->
                adapter.submitList(result.hourly)
            }
        }
    }

    private fun setUpAdapter() {
        adapter = ForecastAdapter(this)
    }

    private fun setUpRecyclerView() {
        binding.recyclerView.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = this@MainActivity.adapter
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when (requestCode) {
            MY_PERMISSIONS_REQUEST_LOCATION -> {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    // Permission was granted
                    getLocation()
                    loadWeather()
                } else {
                    // Permission denied, handle the error
                    Toast.makeText(this, "Location permission denied", Toast.LENGTH_SHORT).show()
                }
                return
            }
        }
    }

    /**
     * OnclickListener
     */
    override fun onClick(foreCast: ForeCast) {
        Snackbar.make(binding.root, CommonUtils.getFullDate(foreCast.dt), Snackbar.LENGTH_LONG).show()
    }
}