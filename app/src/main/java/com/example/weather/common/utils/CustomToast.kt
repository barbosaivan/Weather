package com.example.weather.common.utils

import android.content.Context
import android.view.LayoutInflater
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.example.weather.R

/* 
* Project: Weather
* From: com.example.weather.common.utils
* Create by Ivan Barbosa on 22/04/2023 at 7:48 p. m.
* Linkedin: https://www.linkedin.com/in/ivanbarbosaortega/
*/

class CustomToast(private val context: Context, private val title: String, private val message: String, private val icon: Int) {

    fun show() {
        val toastLayout = LayoutInflater.from(context).inflate(R.layout.custom_toast_layout, null)
        val titleTextView = toastLayout.findViewById<TextView>(R.id.toast_title)
        val messageTextView = toastLayout.findViewById<TextView>(R.id.toast_message)
        val iconImageView = toastLayout.findViewById<ImageView>(R.id.toast_icon)

        titleTextView.text = title
        messageTextView.text = message
        iconImageView.setImageResource(icon)

        val toast = Toast(context)
        toast.duration = Toast.LENGTH_LONG
        toast.view = toastLayout
        toast.show()
    }
}