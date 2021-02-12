package com.team08.cs

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class HelplineActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Utils.onActivityCreateSetTheme(this)
        setContentView(R.layout.activity_helpline)

        val themeNo = savedInstanceState?.getInt("ThemeNo", 0)
        if (themeNo != null) {
            Utils.changeToTheme(this, themeNo)
        }

        supportActionBar?.hide()
    }
    fun chatBttnFn(view: View) {
        val intent1 = Intent(this, ChatActivity::class.java)
        startActivity(intent1)
    }

    fun quoteBttnFn(view: View) {
        val intent2 = Intent(this, Quotes::class.java)
        startActivity(intent2)
    }

    fun musicBttnFn(view: View) {
        val intent3 = Intent(this, Music::class.java)
        startActivity(intent3)
    }

    fun helplineBttnFn(view: View) {
        val intent4 = Intent(this, HelplineActivity::class.java)
        startActivity(intent4)
    }
}