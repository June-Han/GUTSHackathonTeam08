package com.team08.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.team08.myapplication.Utils

class ThemeChange : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Utils.onActivityCreateSetTheme(this)
        setContentView(R.layout.activity_theme_change)

        //set Buttons to listeners
        val seaButton = findViewById<Button>(R.id.ThemeBlue)
        val sakuraButton = findViewById<Button>(R.id.ThemePink)
        val forestButton = findViewById<Button>(R.id.ThemeGreen)
        val aquaButton = findViewById<Button>(R.id.ThemeTurquoise)
        val toChatButton = findViewById<Button>(R.id.ProceedToChat)

        seaButton.setOnClickListener {
            Utils.changeToTheme(this, Utils.themeSea)
            savedInstanceState?.putInt("ThemeNo", 0)
            //themeNum = 0
        }
        sakuraButton.setOnClickListener {
            Utils.changeToTheme(this, Utils.themeSakura)
            savedInstanceState?.putInt("ThemeNo", 1)
            //themeNum = 1
        }
        forestButton.setOnClickListener {
            Utils.changeToTheme(this, Utils.themeForest)
            savedInstanceState?.putInt("ThemeNo", 2)
            //themeNum = 2
        }
        aquaButton.setOnClickListener {
            Utils.changeToTheme(this, Utils.themeAqua)
            savedInstanceState?.putInt("ThemeNo", 3)
            //themeNum = 3
        }
        toChatButton.setOnClickListener{
            val intent = Intent(this, Name::class.java)
            startActivity(intent)
        }
    }
}