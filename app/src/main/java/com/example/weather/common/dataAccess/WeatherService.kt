package com.example.weather.common.dataAccess

import com.example.weather.common.entities.WeatherForecastEntity
import com.example.weather.common.utils.Constants
import retrofit2.http.GET
import retrofit2.http.Query

/* 
* Project: Weather
* From: com.example.weather.common.dataAccess
* Create by Ivan Barbosa on 25/03/2023 at 7:20 p. m.
* Linkedin: https://www.linkedin.com/in/ivanbarbosaortega/
*/

interface WeatherService {
    @GET(Constants.ONE_CALL_PATH)
    suspend fun getWeatherForecastByCoordinate(
        @Query(Constants.LATITUDE_PARAM) lat: Double,
        @Query(Constants.LONGITUDE_PARAM) lon: Double,
        @Query(Constants.APP_ID_PARAM) appid: String,
        @Query(Constants.EXCLUDE_PARAM) exclude: String,
        @Query(Constants.UNITS_PARAM) units:String,
        @Query(Constants.LANGUAGE_PARAM) lang: String
    ): WeatherForecastEntity
}