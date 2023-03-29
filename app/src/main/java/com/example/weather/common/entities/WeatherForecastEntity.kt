package com.example.weather.common.entities

import com.example.weather.common.entities.Current
import com.example.weather.common.entities.ForeCast

/* 
* Project: Weather
* From: com.example.weather.common
* Create by Ivan Barbosa on 25/03/2023 at 7:15 p. m.
* Linkedin: https://www.linkedin.com/in/ivanbarbosaortega/
*/

data class WeatherForecastEntity(val timezone: String,
                                 val current: Current,
                                 val hourly: List<ForeCast>
                                 )
