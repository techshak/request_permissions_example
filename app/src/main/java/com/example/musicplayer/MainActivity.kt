package com.example.musicplayer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.media.MediaPlayer

class MainActivity : AppCompatActivity() {

    private lateinit var song:MediaPlayer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        song = MediaPlayer.create(applicationContext,R.raw.song)
        findViewById<Button>(R.id.play).setOnClickListener {
            song.start()
        }

    }
}