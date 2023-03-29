package com.example.weather.mainModule.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weather.R
import com.example.weather.common.entities.WeatherForecastEntity
import com.example.weather.mainModule.model.MainRepository
import kotlinx.coroutines.launch

/* 
* Project: Weather
* From: com.example.weather.mainModule.ViewModel
* Create by Ivan Barbosa on 25/03/2023 at 7:45 p. m.
* Linkedin: https://www.linkedin.com/in/ivanbarbosaortega/
*/

class MainViewModel: ViewModel() {
    private val repository = MainRepository()
    private val result = MutableLiveData<WeatherForecastEntity>()
    private val snackbarMsg = MutableLiveData<Int>()
    private val loaded = MutableLiveData<Boolean>()


    fun getResult(): LiveData<WeatherForecastEntity> = result

    fun getSnackbarMsg() = snackbarMsg

    fun isLoaded() = loaded

    suspend fun getWeatherAndForecast(lat: Double, lon: Double, appid: String, exclude: String, units: String, lang: String){
        viewModelScope.launch {
            try {
                loaded.value = false
                val resultServer = repository.getWeatherAndForecast(lat, lon, appid, exclude, units, lang)
                result.value = resultServer
                if (resultServer.hourly == null || resultServer.hourly.isEmpty()){
                    snackbarMsg.value = R.string.main_error_empty_forecast
                }
            } catch (e: Exception) {
                snackbarMsg.value = R.string.error_server
            }finally {
                loaded.value = true
            }
        }
    }

}
