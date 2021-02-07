package com.team08.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Utils.onActivityCreateSetTheme(this)
        setContentView(R.layout.activity_main)

        /*super.onRestart()
        savedInstanceState?.putInt("ThemeNo", 0)
        val themeNo = savedInstanceState?.getInt("ThemeNo", 0)
        if (themeNo != null) {
            Utils.changeToTheme(this, themeNo)
        }*/

        val button = findViewById<Button>(R.id.TestButton)
        button.setOnClickListener{
            val intent = Intent(this, Name::class.java)
            startActivity(intent)
        }
    }
}