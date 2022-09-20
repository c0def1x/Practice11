package com.bignerdranch.android.practice11

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class OutputData : AppCompatActivity()
{
    private val weather:MutableList<String> = mutableListOf()
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_output_data)
        getWeather()
        weather.forEach{
            Log.d("data", it.toString())
        }
    }

    private fun getWeather()
    {
        val preferences = getSharedPreferences("pref", MODE_PRIVATE)
        var json:String = ""
        if(!preferences.contains("json"))
        {
            return
        }
        else
        {
            json = preferences.getString("json", "NOT_JSON").toString()
            val tempList = Gson().fromJson<List<Day>>(json, object: TypeToken<List<Day>>(){}.type)
        }

    }

}