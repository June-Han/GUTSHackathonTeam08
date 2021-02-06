package com.team08.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class ThemeChange : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_theme_change)
        val button = findViewById<Button>(R.id.ProceedButton)
        button.setOnClickListener{
            val intent = Intent(this, Name::class.java)
            startActivity(intent)
        }
    }
}