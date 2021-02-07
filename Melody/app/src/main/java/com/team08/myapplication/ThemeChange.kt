package com.team08.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.team08.myapplication.Utils
class ThemeChange : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Utils.onActivityCreateSetTheme(this);
        setContentView(R.layout.activity_theme_change)

        //set Buttons to listeners
        val seaButton = findViewById<Button>(R.id.ThemeBlue)
        val sakuraButton = findViewById<Button>(R.id.ThemePink)
        val forestButton = findViewById<Button>(R.id.ThemeGreen)
        val aquaButton = findViewById<Button>(R.id.ThemeTurquoise)

        seaButton.setOnClickListener {
            Utils.changeToTheme(this, Utils.themeSea);
        }
        sakuraButton.setOnClickListener {
            Utils.changeToTheme(this, Utils.themeSakura);
        }
        forestButton.setOnClickListener {
            Utils.changeToTheme(this, Utils.themeForest);
        }
        aquaButton.setOnClickListener {
            Utils.changeToTheme(this, Utils.themeAqua);
            val button = findViewById<Button>(R.id.ProceedButton)
            button.setOnClickListener {
                val intent = Intent(this, Name::class.java)
                startActivity(intent)
            }
        }
    }
}