package com.team08.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val quotes_btn: Button = findViewById(com.team08.myapplication.R.id.quotes_btn)
        quotes_btn.setOnClickListener(){
            val intent = Intent(this, Quotes::class.java)
            startActivity(intent)
        }
    }

}