package com.example.weather.common.entities

/*
* Project: Weather
* From: com.example.weather.common
* Create by Ivan Barbosa on 25/03/2023 at 7:13 p. m.
* Linkedin: https://www.linkedin.com/in/ivanbarbosaortega/
*/

data class ForeCast(val dt: Long,
                    val humidity: Int,
                    val temp: Double,
                    val weather: List<Weather>,
                    val pop: Double
                    ): WeatherBase(dt, humidity, temp, weather)
