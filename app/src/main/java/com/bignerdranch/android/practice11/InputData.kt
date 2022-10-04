package com.bignerdranch.android.practice11

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class InputData : AppCompatActivity()
{
    private var weathers:MutableList<Day> = mutableListOf()
    private lateinit var saveButton: Button
    private lateinit var date:EditText
    private lateinit var dayTemperature:EditText
    private lateinit var nightTemperature :EditText

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_input_data)
        getWeathers()

        saveButton = findViewById(R.id.saveButton)
        date = findViewById(R.id.dateInput)
        dayTemperature = findViewById(R.id.dayTemperatureInput)
        nightTemperature = findViewById(R.id.nightTemperatureInput)

        fun addingDay()
        {
            addWeather(date.text.toString(), dayTemperature.text.toString(), nightTemperature.text.toString())
            Log.d("day", weathers.toString())
        }

        saveButton.setOnClickListener{
            if(date.text.isNotEmpty() && dayTemperature.text.isNotEmpty() && nightTemperature.text.isNotEmpty())
            {
                addingDay()
            }
            else
            {
                Toast.makeText(applicationContext,"Заполните все поля!", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun getWeathers()
    {
        val preferences = getSharedPreferences("pref", MODE_PRIVATE)
        var json = ""
        if(!preferences.contains("json"))
            return
        else
            json = preferences.getString("json", "NOT_JSON").toString()
        val tempList = Gson().fromJson<List<Day>>(json, object: TypeToken<List<Day>>(){}.type)
        weathers.addAll(tempList)
    }

    private fun addWeather(date: String, dayTemperature: String, nightTemperature: String)
    {
        val day = Day(date, dayTemperature, nightTemperature)
        weathers.add(day)
    }
}