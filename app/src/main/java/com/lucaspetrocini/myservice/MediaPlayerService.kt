package com.lucaspetrocini.myservice

import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.os.IBinder
import android.provider.Settings

class MediaPlayerService: Service() {

    private lateinit var player: MediaPlayer

    override fun onBind(intent: Intent?): IBinder? {
        return null
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        player = MediaPlayer.create(this, Settings.System.DEFAULT_RINGTONE_URI)

        // Creating a media player which
        // Will play the audio of Default
        // Ringtone in android device
        player.isLooping = true

        // Starting the process
        player.start()

        // returns the status
        // of the program
        return START_STICKY
    }

    override fun onDestroy() {
        super.onDestroy()

        // Stopping the process
        player.stop()
    }

}