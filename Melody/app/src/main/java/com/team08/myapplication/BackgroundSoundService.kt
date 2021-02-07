package com.team08.myapplication
import android.app.Service
import android.content.Intent
import android.content.Intent.getIntent
import android.media.MediaPlayer
import android.os.Bundle
import android.os.IBinder
import android.widget.Toast

class BackgroundSoundService : Service() {
    internal lateinit var player: MediaPlayer
    internal lateinit var result: String
    override fun onBind(arg0: Intent): IBinder? {

        return null
    }

    override fun onCreate() {
//        val afd = applicationContext.assets.openFd("slowmotion.mp3") as AssetFileDescriptor
//        val player = MediaPlayer()
//        player.setDataSource(afd.fileDescriptor)
        player = MediaPlayer.create(this, R.raw.slowmotion)
        player.isLooping = true // Set looping
        player.setVolume(100f, 100f)
    }

    override fun onStartCommand(intent: Intent, flags: Int, startId: Int): Int {

//        Toast.makeText(getApplicationContext(), "Playing Music in the Background",    Toast.LENGTH_SHORT).show();
//        val result = intent.getStringExtra("EXTRA_SONG")
//        Toast.makeText(getApplicationContext(), "Got int_condition",    Toast.LENGTH_SHORT).show();
        if (intent.getAction().equals("november")) {
            player.stop()
            player = MediaPlayer.create(this, R.raw.november)
            player.isLooping = true // Set looping
            player.setVolume(100f, 100f)
            player.start()
            Toast.makeText(getApplicationContext(), "november result",    Toast.LENGTH_SHORT).show();
        } else if (intent.getAction().equals("slowmotion")) {
            player.stop()
            player = MediaPlayer.create(this, R.raw.november)
            player.isLooping = true // Set looping
            player.setVolume(100f, 100f)
            player.start()
            Toast.makeText(getApplicationContext(), "slowmotion result",    Toast.LENGTH_SHORT).show();
        } else if (intent.getAction().equals("adventure")) {
            player.stop()
            player = MediaPlayer.create(this, R.raw.adventure)
            player.isLooping = true // Set looping
            player.setVolume(100f, 100f)
            player.start()
            Toast.makeText(getApplicationContext(), "adventure result",    Toast.LENGTH_SHORT).show();
        } else {
            player = MediaPlayer.create(this, R.raw.slowmotion)
            player.isLooping = true // Set looping
            player.setVolume(100f, 100f)
            player.start()
            Toast.makeText(getApplicationContext(), "default result",    Toast.LENGTH_SHORT).show();
        }
        return START_STICKY
    }

    override fun onStart(intent: Intent, startId: Int) {
        // TO DO
    }

    fun onUnBind(arg0: Intent): IBinder? {
        // TO DO Auto-generated method
        return null
    }

    fun onStop() {

    }

    fun onPause() {

    }

    override fun onDestroy() {
        player.stop()
        player.release()
    }

    override fun onLowMemory() {

    }

    fun onNewIntent() {
    }

    companion object {
        private val TAG: String? = null
    }
}