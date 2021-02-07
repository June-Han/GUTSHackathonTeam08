package com.team08.myapplication

import android.nfc.Tag
import android.os.Bundle
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity

class Relationship_quotes : AppCompatActivity() {
    val TAG: String = "RelatioshipQuotes"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_relationship_quotes)
        this.title = getString(R.string.title_activity_Rquotes)
    }


    }