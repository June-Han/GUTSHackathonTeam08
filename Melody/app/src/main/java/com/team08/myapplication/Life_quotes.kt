package com.team08.myapplication

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView

class Life_quotes: AppCompatActivity() {

    private val LifeQuotesBottomNav = BottomNavigationView.OnNavigationItemSelectedListener{ item ->
        when(item.itemId) {
            R.id.Page1 -> {
                val intent = Intent(this@Life_quotes, Quotes::class.java)
                startActivity(intent)
                return@OnNavigationItemSelectedListener true
            }
            R.id.Page2 -> {
                val intent = Intent(this@Life_quotes, ChatActivity::class.java)
                startActivity(intent)
                return@OnNavigationItemSelectedListener true
            }
            R.id.Page3 -> {
                val intent = Intent(this@Life_quotes, Music::class.java)
                startActivity(intent)
                return@OnNavigationItemSelectedListener true
            }
            R.id.Page4 -> {
                val intent = Intent(this@Life_quotes, HelplineActivity::class.java)
                startActivity(intent)
                return@OnNavigationItemSelectedListener true
            }
            else -> return@OnNavigationItemSelectedListener false
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Utils.onActivityCreateSetTheme(this)
        setContentView(R.layout.activity_life_quotes)

        val themeNo = savedInstanceState?.getInt("ThemeNo", 0)
        if (themeNo != null) {
            Utils.changeToTheme(this, themeNo)
        }

        this.title = getString(com.team08.myapplication.R.string.title_activity_Lquotes)

        val lifebottomnavi = findViewById<BottomNavigationView>(R.id.life_bottom_navigation)
        lifebottomnavi.menu.findItem(R.id.Page1).isChecked = true
        lifebottomnavi.setOnNavigationItemSelectedListener(LifeQuotesBottomNav)
    }
}