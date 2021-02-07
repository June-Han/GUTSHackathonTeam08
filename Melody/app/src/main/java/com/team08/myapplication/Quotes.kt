package com.team08.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity


class Quotes : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Utils.onActivityCreateSetTheme(this)
        setContentView(com.team08.myapplication.R.layout.activity_quotes)

        val themeNo = savedInstanceState?.getInt("ThemeNo", 0)
        if (themeNo != null) {
            Utils.changeToTheme(this, themeNo)
        }

        val myRBtn: ImageButton = findViewById(com.team08.myapplication.R.id.relationship_btn)
        val myFBtn: ImageButton = findViewById(com.team08.myapplication.R.id.Friendship_btn2)
        val myLBtn: ImageButton = findViewById(com.team08.myapplication.R.id.life_btn3)
        this.title = getString(com.team08.myapplication.R.string.title_activity_quotes)


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


    }


}


