package com.team08.cs
import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.os.IBinder

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

        if (intent.getAction().equals("november")) {
            player.stop()
            player = MediaPlayer.create(this, R.raw.november)
            player.isLooping = true // Set looping
            player.setVolume(100f, 100f)
            player.start()
        } else if (intent.getAction().equals("slowmotion")) {
            player.stop()
            player = MediaPlayer.create(this, R.raw.slowmotion)
            player.isLooping = true // Set looping
            player.setVolume(100f, 100f)
            player.start()
        } else if (intent.getAction().equals("adventure")) {
            player.stop()
            player = MediaPlayer.create(this, R.raw.adventure)
            player.isLooping = true // Set looping
            player.setVolume(100f, 100f)
            player.start()
        } else {
            player = MediaPlayer.create(this, R.raw.slowmotion)
            player.isLooping = true // Set looping
            player.setVolume(100f, 100f)
            player.start()
        }
        return START_STICKY
    }

    override fun onStart(intent: Intent, startId: Int) {
        // TO DO
        player.start()
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