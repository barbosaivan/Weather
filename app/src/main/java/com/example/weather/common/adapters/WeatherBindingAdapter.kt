package com.example.weather.common.adapters

import android.view.View
import androidx.databinding.BindingAdapter

/* 
* Project: Weather
* From: com.example.weather.common.adapters
* Create by Ivan Barbosa on 26/03/2023 at 4:23 p. m.
* Linkedin: https://www.linkedin.com/in/ivanbarbosaortega/
*/

@BindingAdapter("isGone")
fun bindIsGone(view: View, isGone: Boolean){
    view.visibility = if (isGone) View.GONE else View.VISIBLE
}