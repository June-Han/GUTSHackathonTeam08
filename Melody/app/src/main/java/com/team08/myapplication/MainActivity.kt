package com.team08.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button = findViewById<Button>(R.id.TestButton)
        button.setOnClickListener{
            val intent = Intent(this, Name::class.java)
            startActivity(intent)
        }

        val buttonTwo = findViewById<Button>(R.id.TestButtonTwo)
        buttonTwo.setOnClickListener{
            val intent = Intent(this, ChatActivity::class.java)
            startActivity(intent)
        }
    }
}