package com.example.weather.mainModule.view.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.weather.BR
import com.example.weather.R
import com.example.weather.common.entities.ForeCast
import com.example.weather.databinding.ItemWeatherBinding

/* 
* Project: Weather
* From: com.example.weather.mainModule.view.adapters
* Create by Ivan Barbosa on 26/03/2023 at 8:41 p. m.
* Linkedin: https://www.linkedin.com/in/ivanbarbosaortega/
*/

class ForecastAdapter(private val listener: OnclickListener): ListAdapter<ForeCast, RecyclerView.ViewHolder>(ForecastDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_weather, parent, false))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val forecast = getItem(position)
        with(holder as ViewHolder){
            holder.binding?.setVariable(BR.forecast, forecast)
            holder.binding?.executePendingBindings()
            setListener(forecast)
        }
    }

    inner class ViewHolder(view: View): RecyclerView.ViewHolder(view){
        val binding = DataBindingUtil.bind<ItemWeatherBinding>(view)

        fun setListener(forecast: ForeCast){
            binding?.root?.setOnClickListener{
                listener.onClick(forecast)
            }
        }
    }

    class ForecastDiffCallback : DiffUtil.ItemCallback<ForeCast>(){

        override fun areItemsTheSame(oldItem: ForeCast, newItem: ForeCast): Boolean = oldItem.dt == newItem.dt

        override fun areContentsTheSame(oldItem: ForeCast, newItem: ForeCast): Boolean = oldItem == newItem
    }
}