package com.team08.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Name : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_name)
        val proceedButton = findViewById<Button>(R.id.ProceedButton)
        proceedButton.setOnClickListener(){
            val intent = Intent(this, ThemeChange::class.java)
            startActivity(intent)
        }
    }
}