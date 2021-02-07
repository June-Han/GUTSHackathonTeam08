package com.team08.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class Life_quotes: AppCompatActivity() {
    val TAG: String = "LifeQuotes"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Utils.onActivityCreateSetTheme(this)
        setContentView(R.layout.activity_life_quotes)

        val themeNo = savedInstanceState?.getInt("ThemeNo", 0)
        if (themeNo != null) {
            Utils.changeToTheme(this, themeNo)
        }

        this.title = getString(com.team08.myapplication.R.string.title_activity_Lquotes)
    }
}