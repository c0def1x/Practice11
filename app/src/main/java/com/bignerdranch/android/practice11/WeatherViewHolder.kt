package com.bignerdranch.android.practice11

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class WeatherViewHolder(item: View): RecyclerView.ViewHolder(item)
{
    var dateTextView: TextView = item.findViewById(R.id.dateInput)
    var dayTemperature: TextView = item.findViewById(R.id.dayTemperatureInput)
    var nightTemperature: TextView = item.findViewById(R.id.nightTemperatureInput)
}