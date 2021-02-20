package com.team08.cs

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_chat.*
import kotlinx.android.synthetic.main.activity_friendship_quotes.*

class Friendship_quotes : AppCompatActivity(){

    private val friendshipQuotesBottomNav = BottomNavigationView.OnNavigationItemSelectedListener{ item ->
        when(item.itemId) {
            R.id.Page1 -> {
                val intent = Intent(this@Friendship_quotes, Quotes::class.java)
                startActivity(intent)
                return@OnNavigationItemSelectedListener true
            }
            R.id.Page2 -> {
                val intent = Intent(this@Friendship_quotes, ChatActivity::class.java)
                startActivity(intent)
                return@OnNavigationItemSelectedListener true
            }
            R.id.Page3 -> {
                val intent = Intent(this@Friendship_quotes, Music::class.java)
                startActivity(intent)
                return@OnNavigationItemSelectedListener true
            }
            R.id.Page4 -> {
                val intent = Intent(this@Friendship_quotes, HelplineActivity::class.java)
                startActivity(intent)
                return@OnNavigationItemSelectedListener true
            }
            else -> return@OnNavigationItemSelectedListener false
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Utils.onActivityCreateSetTheme(this)
        setContentView(R.layout.activity_friendship_quotes)

        val themeNo = savedInstanceState?.getInt("ThemeNo", 0)
        if (themeNo != null) {
            Utils.changeToTheme(this, themeNo)
        }

        val friendQuotesBottomNav = findViewById<BottomNavigationView>(R.id.friendship_bottom_navigation)
        friendQuotesBottomNav.menu.findItem(R.id.Page1).isChecked = true
        friendQuotesBottomNav.setOnNavigationItemSelectedListener(friendshipQuotesBottomNav)
        this.title = getString(com.team08.cs.R.string.title_activity_Fquotes)
    }
}