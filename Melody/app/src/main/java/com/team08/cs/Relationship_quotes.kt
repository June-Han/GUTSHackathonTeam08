package com.team08.cs

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView

class Relationship_quotes : AppCompatActivity() {
    private val rsQuotesBottomNav = BottomNavigationView.OnNavigationItemSelectedListener{ item ->
        when(item.itemId) {
            R.id.Page1 -> {
                val intent = Intent(this@Relationship_quotes, Quotes::class.java)
                startActivity(intent)
                return@OnNavigationItemSelectedListener true
            }
            R.id.Page2 -> {
                val intent = Intent(this@Relationship_quotes, ChatActivity::class.java)
                startActivity(intent)
                return@OnNavigationItemSelectedListener true
            }
            R.id.Page3 -> {
                val intent = Intent(this@Relationship_quotes, Music::class.java)
                startActivity(intent)
                return@OnNavigationItemSelectedListener true
            }
            R.id.Page4 -> {
                val intent = Intent(this@Relationship_quotes, HelplineActivity::class.java)
                startActivity(intent)
                return@OnNavigationItemSelectedListener true
            }
            else -> return@OnNavigationItemSelectedListener  false
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Utils.onActivityCreateSetTheme(this)
        setContentView(R.layout.activity_relationship_quotes)

        val themeNo = savedInstanceState?.getInt("ThemeNo", 0)
        if (themeNo != null) {
            Utils.changeToTheme(this, themeNo)
        }

        this.title = getString(R.string.title_activity_Rquotes)

        val rsBottomNav = findViewById<BottomNavigationView>(R.id.relationship_bottom_navigation)
        rsBottomNav.menu.findItem(R.id.Page1).isChecked = true
        rsBottomNav.setOnNavigationItemSelectedListener(rsQuotesBottomNav)
    }


}