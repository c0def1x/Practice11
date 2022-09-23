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
    private var weather:MutableList<Day> = mutableListOf()
    private lateinit var saveButton: Button
    private lateinit var date:EditText
    private lateinit var dayTemperature:EditText
    private lateinit var nightTemperature :EditText

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_input_data)
        getWeathers()

        saveButton = findViewById(R.id.SaveButton)
        date = findViewById(R.id.editTextTextPersonName7)
        dayTemperature = findViewById(R.id.editTextTextPersonName9)
        nightTemperature = findViewById(R.id.editTextTextPersonName10)

        fun addingDay()
        {
            addDay(date.text.toString(), dayTemperature.text.toString(), nightTemperature.text.toString())
            Log.d("day", weather.toString())
        }


        saveButton.setOnClickListener{
            if(date.text.toString() != ""
                && dayTemperature.text.toString() != ""
                && nightTemperature.text.toString() != "")
            {
                addingDay()
            }
            else
            {
                Toast.makeText(applicationContext,"Заполните все поля!", Toast.LENGTH_SHORT).show()
            }

            if(dayTemperature.text.toString()[0] == '+' || dayTemperature.text.toString()[0] == '-'
                || nightTemperature.text.toString()[0] == '+' || nightTemperature.text.toString()[0] == '-')
            {
                addingDay()
            }
            else
            {
                Toast.makeText(applicationContext,"Неккоректно введена температура!", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun getWeathers()
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
        }
        val tempList = Gson().fromJson<List<Day>>(json, object: TypeToken<List<Day>>(){}.type)
        weather.addAll(tempList)
    }

    private fun addDay(date: String, dayTemperature: String, nightTemperature: String)
    {
        val day = Day(date, dayTemperature, nightTemperature)
        weather.add(day)
        val preferences = getSharedPreferences("pref", MODE_PRIVATE)
    }
}