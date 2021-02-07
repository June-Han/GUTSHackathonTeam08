package com.team08.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        PlayDefaultSound()
    }

    fun chatBttnFn(view: View) {
        val intent1 = Intent(this, Chat::class.java)
        startActivity(intent1)
    }

    fun quoteBttnFn(view: View) {
//        val intent2 = Intent(this, BackgroundSoundService::class.java)
//        startActivity(intent2)
    }

    fun musicBttnFn(view: View) {
        val intent3 = Intent(this, Music::class.java)
        startActivity(intent3)
    }

    fun helplineBttnFn(view: View) {
//        val intent4 = Intent(this, helpline::class.java)
//        startActivity(intent4)
    }

    fun PlayDefaultSound() {
        val intent = Intent(this, BackgroundSoundService::class.java)
        startService(intent)
    }

}