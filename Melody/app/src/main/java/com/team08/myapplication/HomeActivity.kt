package com.team08.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.widget.Button

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        supportActionBar?.hide()

        val buttonContinue = findViewById<Button>(R.id.buttonContinue)

        val clickListener = View.OnClickListener { view ->
            when (view.getId()) {
                R.id.buttonContinue -> startActivity(Intent(this@HomeActivity, MainActivity::class.java))

            }
        }

        buttonContinue.setOnClickListener(clickListener)
    }
}