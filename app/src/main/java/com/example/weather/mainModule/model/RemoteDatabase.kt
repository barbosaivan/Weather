package com.example.weather.mainModule.model

import com.example.weather.common.dataAccess.WeatherService
import com.example.weather.common.entities.WeatherForecastEntity
import com.example.weather.common.utils.Constants
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/* 
* Project: Weather
* From: com.example.weather.mainModule.model
* Create by Ivan Barbosa on 25/03/2023 at 7:35 p. m.
* Linkedin: https://www.linkedin.com/in/ivanbarbosaortega/
*/

class RemoteDatabase {
    private val retrofit = Retrofit.Builder()
        .baseUrl(Constants.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val service = retrofit.create(WeatherService::class.java)

    suspend fun getWeatherForecastByCoordinates(lat: Double, lon: Double, appid: String, exclude:String, units: String, lang: String): WeatherForecastEntity =
        withContext(Dispatchers.IO){
        service.getWeatherForecastByCoordinate(lat, lon, appid, exclude, units, lang)
    }
}