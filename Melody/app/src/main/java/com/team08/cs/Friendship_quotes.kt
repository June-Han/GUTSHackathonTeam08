package com.team08.cs

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class Friendship_quotes : AppCompatActivity(){

    val TAG: String = "FriendshipQuotes"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Utils.onActivityCreateSetTheme(this)
        setContentView(R.layout.activity_friendship_quotes)

        val themeNo = savedInstanceState?.getInt("ThemeNo", 0)
        if (themeNo != null) {
            Utils.changeToTheme(this, themeNo)
        }
        this.title = getString(com.team08.cs.R.string.title_activity_Fquotes)
    }
}