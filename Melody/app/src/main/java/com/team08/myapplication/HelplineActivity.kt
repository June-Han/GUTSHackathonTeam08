package com.team08.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_quotes.*

class HelplineActivity : AppCompatActivity() {

    private val helplineBotNavi = BottomNavigationView.OnNavigationItemSelectedListener{ item ->
        when(item.itemId) {
            R.id.Page1 -> {
                val intent = Intent(this@HelplineActivity, Quotes::class.java)
                startActivity(intent)
                return@OnNavigationItemSelectedListener true
            }
            R.id.Page2 -> {
                val intent = Intent(this@HelplineActivity, ChatActivity::class.java)
                startActivity(intent)
                return@OnNavigationItemSelectedListener true
            }
            R.id.Page3 -> {
                val intent = Intent(this@HelplineActivity, Music::class.java)
                startActivity(intent)
                return@OnNavigationItemSelectedListener true
            }
            R.id.Page4 -> {
                val intent = Intent(this@HelplineActivity, HelplineActivity::class.java)
                startActivity(intent)
                return@OnNavigationItemSelectedListener true
            }
            else -> return@OnNavigationItemSelectedListener false
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Utils.onActivityCreateSetTheme(this)
        setContentView(R.layout.activity_helpline)

        val themeNo = savedInstanceState?.getInt("ThemeNo", 0)
        if (themeNo != null) {
            Utils.changeToTheme(this, themeNo)
        }

        //supportActionBar?.hide()
        this.title = "Contacts"

        val helplineBotNav = findViewById<BottomNavigationView>(R.id.helpline_bottom_navigation)
        helplineBotNav.menu.findItem(R.id.Page4).isChecked = true
        helplineBotNav.setOnNavigationItemSelectedListener(helplineBotNavi)
    }


}

/*fun chatBttnFn(view: View) {
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
    }*/