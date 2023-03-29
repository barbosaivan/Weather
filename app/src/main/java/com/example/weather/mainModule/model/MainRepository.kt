package com.example.weather.mainModule.model

import com.example.weather.common.entities.WeatherForecastEntity

/* 
* Project: Weather
* From: com.example.weather.mainModule.model
* Create by Ivan Barbosa on 25/03/2023 at 7:42 p. m.
* Linkedin: https://www.linkedin.com/in/ivanbarbosaortega/
*/

class MainRepository {
    private val remoteDatabase = RemoteDatabase()

    suspend fun getWeatherAndForecast(lat: Double, lon: Double,
                                      appid: String, exclude: String, units: String,
                                      lang: String) : WeatherForecastEntity =
        remoteDatabase.getWeatherForecastByCoordinates(lat, lon, appid, exclude, units, lang)
}