package com.example.weather.common.utils

import com.example.weather.common.entities.Weather
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.List

/* 
* Project: Weather
* From: com.example.weather.common.utils
* Create by Ivan Barbosa on 26/03/2023 at 3:55 p. m.
* Linkedin: https://www.linkedin.com/in/ivanbarbosaortega/
*/

object CommonUtils {
    fun getHour(epoch: Long): String = getFormattedTime(epoch, "HH:mm")

    fun getFullDate(epoch: Long): String = getFormattedTime(epoch, "dd/MM/yy HH:mm")

    private fun getFormattedTime(epoch: Long, pattern: String): String {
        return SimpleDateFormat(pattern, Locale.getDefault()).format(epoch*1_000)
    }

    fun getWeatherMain(weather: List<Weather>?): String{
        return if (weather != null && weather.isNotEmpty()) weather[0].main else "-"
    }

    fun getWeatherDescription(weather: List<Weather>?): String{
        return if (weather != null && weather.isNotEmpty()) weather[0].description else "-"
    }

}
