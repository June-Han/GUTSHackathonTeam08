package com.team08.cs

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class Relationship_quotes : AppCompatActivity() {
    val TAG: String = "RelatioshipQuotes"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Utils.onActivityCreateSetTheme(this)
        setContentView(R.layout.activity_relationship_quotes)

        val themeNo = savedInstanceState?.getInt("ThemeNo", 0)
        if (themeNo != null) {
            Utils.changeToTheme(this, themeNo)
        }

        this.title = getString(R.string.title_activity_Rquotes)
    }


}