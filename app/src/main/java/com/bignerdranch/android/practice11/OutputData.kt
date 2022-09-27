package com.bignerdranch.android.practice11

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class OutputData : AppCompatActivity()
{
    private val weathers:MutableList<Day> = mutableListOf()
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_output_data)
        getWeathers()
        weathers.forEach{
            Log.d("data", it.toString())
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
        weathers.addAll(tempList)
    }
}