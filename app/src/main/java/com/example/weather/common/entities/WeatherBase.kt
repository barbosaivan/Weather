package com.example.weather.common.entities

import com.example.weather.common.entities.Weather

/* 
* Project: Weather
* From: com.example.weather.common
* Create by Ivan Barbosa on 25/03/2023 at 7:06 p. m.
* Linkedin: https://www.linkedin.com/in/ivanbarbosaortega/
*/

open class WeatherBase(dt: Long,
                      humidity: Int,
                      temp: Double,
                      weather: List<Weather>
                      )