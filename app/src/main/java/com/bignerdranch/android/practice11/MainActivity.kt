package com.bignerdranch.android.practice11

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity()
{
    private lateinit var inputDataButton: Button
    private lateinit var outputDataButton: Button
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        inputDataButton = findViewById(R.id.InputDataButton)
        outputDataButton = findViewById(R.id.OutputDataButton)
        inputDataButton.setOnClickListener{
            val intent = Intent(this@MainActivity, InputData::class.java)
            startActivity(intent)
        }
        outputDataButton.setOnClickListener{
            val intent = Intent(this@MainActivity, OutputData::class.java)
            startActivity(intent)
        }
    }
}