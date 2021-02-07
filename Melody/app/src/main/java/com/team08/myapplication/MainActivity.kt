package com.team08.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Utils.onActivityCreateSetTheme(this)
        setContentView(R.layout.activity_main)

        /*val quotesbtn: Button = findViewById(R.id.quotes_btn)
        quotesbtn.setOnClickListener() {
            val intent = Intent(this, Quotes::class.java)
            startActivity(intent)
        }*/

        val button = findViewById<Button>(R.id.TestButton)
        button.setOnClickListener {
            val intent = Intent(this, Name::class.java)
            startActivity(intent)
        }
    }

}
