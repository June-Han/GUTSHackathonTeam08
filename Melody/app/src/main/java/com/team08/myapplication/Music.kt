package com.team08.myapplication

import android.app.ActivityManager
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView


class Music : AppCompatActivity() {

    private val musicBotNav = BottomNavigationView.OnNavigationItemSelectedListener {item ->
    when(item.itemId){
        R.id.Page1 -> {
            intent = Intent(this@Music, Quotes::class.java)
            startActivity(intent)
            return@OnNavigationItemSelectedListener true
        }
        R.id.Page2 -> {
            intent = Intent (this@Music, ChatActivity::class.java)
            startActivity(intent)
            return@OnNavigationItemSelectedListener true
        }
        R.id.Page3 -> {
            intent = Intent(this@Music, ChatActivity::class.java)
            startActivity(intent)
            return@OnNavigationItemSelectedListener true
        }
        R.id.Page4 -> {
            intent = Intent(this@Music, HelplineActivity::class.java)
            startActivity(intent)
            return@OnNavigationItemSelectedListener true
        }
        else -> return@OnNavigationItemSelectedListener false
    }

    }

//    var mMediaPlayer : MediaPlayer? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Utils.onActivityCreateSetTheme(this)
        setContentView(R.layout.activity_music)

       val themeNo = savedInstanceState?.getInt("ThemeNo", 0)
        if (themeNo != null) {
            Utils.changeToTheme(this, themeNo)
        }
        this.title = "Music"
        val getMusicBotNav = findViewById<BottomNavigationView>(R.id.music_bottom_navigation)
        getMusicBotNav.menu.findItem(R.id.Page3).isChecked = true //Bottom Nav Show Selected
        getMusicBotNav.setOnNavigationItemSelectedListener(musicBotNav)
//    val musicCardText1: TextView = findViewById(R.id.musicCardText1) as TextView
//    val song1: String = musicCardText1.text.toString()
    }


    fun PlayBackgroundSound1(view: View) {
        val intent = Intent(this, BackgroundSoundService::class.java)
        intent.setAction("slowmotion")
        startService(intent)
    }

    fun PlayBackgroundSound2(view: View) {
        val intent = Intent(this, BackgroundSoundService::class.java)
        intent.setAction("november")
        startService(intent)
    }

    fun PlayBackgroundSound3(view: View) {
        val intent = Intent(this, BackgroundSoundService::class.java)
        intent.setAction("adventure")
        startService(intent)
    }
}

/*
//Comment out the bottom nav replacement buttons
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

//    fun PlayBackgroundSound(view: View?) {
//        if (mMediaPlayer == null) {
//            mMediaPlayer = MediaPlayer.create(this, R.raw.slowmotion)
//            mMediaPlayer!!.isLooping = true
//            mMediaPlayer!!.start()
//        } else mMediaPlayer!!.start()
//    }
//    override fun onStop() {
//        super.onStop()
//        if (mMediaPlayer != null) {
//            mMediaPlayer!!.release()
//            mMediaPlayer = null
//        }
//    }