package com.bignerdranch.android.practice11

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class WeatherRVAdapter(context: Context?, val data: MutableList<Day>):
    RecyclerView.Adapter<WeatherViewHolder?>()
{
    private val layoutInflater: LayoutInflater = LayoutInflater.from(context)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeatherViewHolder
    {
        val view: View = layoutInflater.inflate(R.layout.activity_output_data, parent, false)
        return WeatherViewHolder(view)
    }

    override fun onBindViewHolder(holder: WeatherViewHolder, position: Int)
    {
        val item = data[position]
        holder.dateTextView.text = item.date
        holder.dayTemperature.text = item.dayTemperature
        holder.nightTemperature.text = item.nightTemperature
    }

    override fun getItemCount(): Int = data.size
}