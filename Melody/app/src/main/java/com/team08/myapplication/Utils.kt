package com.team08.myapplication

import android.app.Activity
import android.content.Intent

object Utils {
    private var sTheme = 0
    const val themeSea = 0
    const val themeSakura = 1
    const val themeForest = 2
    const val themeAqua = 3

    /**
     * Set the theme of the Activity, and restart it by creating a new Activity of the same type.
     */
    fun changeToTheme(activity: Activity, theme: Int) {
        sTheme = theme
        activity.finish()
        activity.startActivity(Intent(activity, ThemeChange::class.java))
    }

    /** Set the theme of the activity, according to the configuration.  */
    fun onActivityCreateSetTheme(activity: Activity) {
        when (sTheme) {
            themeSea -> activity.setTheme(R.style.Theme_MelodySea)
            themeSakura -> activity.setTheme(R.style.Theme_MelodySakura)
            themeForest -> activity.setTheme(R.style.Theme_MelodyForest)
            else -> activity.setTheme(R.style.Theme_MelodyAqua)
        }
    }
}
