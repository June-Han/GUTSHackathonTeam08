package com.team08.myapplication

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView


class Quotes : AppCompatActivity() {

    private val QuotePrivateBotNav = BottomNavigationView.OnNavigationItemSelectedListener{ item ->
        when(item.itemId) {
            R.id.Page1 -> {
                val intent = Intent(this@Quotes, Quotes::class.java)
                startActivity(intent)
                return@OnNavigationItemSelectedListener true
            }
            R.id.Page2 -> {
                val intent = Intent(this@Quotes, ChatActivity::class.java)
                startActivity(intent)
                return@OnNavigationItemSelectedListener true
            }
            R.id.Page3 -> {
                val intent = Intent(this@Quotes, Music::class.java)
                startActivity(intent)
                return@OnNavigationItemSelectedListener true
            }
            R.id.Page4 -> {
                val intent = Intent(this@Quotes, HelplineActivity::class.java)
                startActivity(intent)
                return@OnNavigationItemSelectedListener true
            }
            else -> return@OnNavigationItemSelectedListener false
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Utils.onActivityCreateSetTheme(this)
        setContentView(R.layout.activity_quotes)

        val themeNo = savedInstanceState?.getInt("ThemeNo", 0)
        if (themeNo != null) {
            Utils.changeToTheme(this, themeNo)
        }

        val myRBtn: ImageButton = findViewById(R.id.relationship_btn)
        val myFBtn: ImageButton = findViewById(R.id.Friendship_btn2)
        val myLBtn: ImageButton = findViewById(R.id.life_btn3)
        this.title = getString(R.string.title_activity_quotes)


        myRBtn.setOnClickListener(){
          val intent = Intent(this, Relationship_quotes::class.java)
          startActivity(intent)
        }
        myFBtn.setOnClickListener(){
            val intent = Intent(this, Friendship_quotes::class.java)
            startActivity(intent)
        }
        myLBtn.setOnClickListener(){
            val intent = Intent(this, Life_quotes::class.java)
            startActivity(intent)
        }

        val QuotesBotNav = findViewById<BottomNavigationView>(R.id.quotes_bottom_navigation)
        QuotesBotNav.menu.findItem(R.id.Page1).isChecked = true
        QuotesBotNav.setOnNavigationItemSelectedListener(QuotePrivateBotNav)
    }
}

/*
//Comment out all the button code
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
*/


