package com.team08.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class HelplineActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_helpline)

        supportActionBar?.hide()
    }
}