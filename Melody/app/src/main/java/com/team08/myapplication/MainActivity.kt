package com.team08.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import androidx.core.content.ContextCompat
import androidx.core.content.ContextCompat.startActivity


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

        /*val quotesbtn: Button = findViewById(R.id.quotes_btn)
    quotesbtn.setOnClickListener() {
        val intent = Intent(this, Quotes::class.java)
        startActivity(intent)
    }*/

        val button = findViewById<Button>(R.id.TestButton)
        button.setOnClickListener {
            val intent = Intent(this, ChatActivity::class.java)
            startActivity(intent)
        }

        // Helpline
        val buttonHelpline = findViewById<Button>(R.id.button)
        val clickListener = View.OnClickListener { view ->
            when (view.getId()) {
                R.id.button -> startActivity(Intent(this@MainActivity, HelplineActivity::class.java))
            }
        }

        buttonHelpline.setOnClickListener(clickListener)

    }


    fun chatBttnFn(view: View) {
        val intent1 = Intent(this, ChatActivity::class.java)
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