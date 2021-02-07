package com.team08.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class Friendship_quotes : AppCompatActivity(){

    val TAG: String = "FriendshipQuotes"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_friendship_quotes)
        this.title = getString(com.team08.myapplication.R.string.title_activity_Fquotes)
    }
}