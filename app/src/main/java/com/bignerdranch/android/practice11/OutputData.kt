package com.bignerdranch.android.practice11

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class OutputData : AppCompatActivity()
{
    private val weathers:MutableList<Day> = mutableListOf()
    private lateinit var rv: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_output_data)
        //weathers.addAll()
        getWeathers()
        weathers.forEach{
            Log.d("data", it.toString())
        }
        val adapter = WeatherRVAdapter(this, weathers)
        rv = findViewById(R.id.recyclerView)
        rv.adapter = adapter
        rv.layoutManager = LinearLayoutManager(this)
    }

    private fun getWeathers()
    {
        val preferences = getSharedPreferences("pref", MODE_PRIVATE)
        var json = ""
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