package com.team08.cs

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.view.WindowManager


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Utils.onActivityCreateSetTheme(this)
        setContentView(R.layout.activity_main)
        PlayDefaultSound()

        val themeNo = savedInstanceState?.getInt("ThemeNo", 0)
        if (themeNo != null) {
            Utils.changeToTheme(this, themeNo)
        }

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        supportActionBar?.hide()

        val buttonContinue = findViewById<Button>(R.id.buttonContinue)

        buttonContinue.setOnClickListener() {
            val intent = Intent(this, ThemeChange::class.java)
            startActivity(intent)
        }
    }


    fun PlayDefaultSound() {
        val intent = Intent(this, BackgroundSoundService::class.java)
        startService(intent)
    }

    @Override
    override fun onBackPressed() {
        super.onBackPressed()
        val intent = Intent(this, BackgroundSoundService::class.java)
        stopService(intent)
    }

}