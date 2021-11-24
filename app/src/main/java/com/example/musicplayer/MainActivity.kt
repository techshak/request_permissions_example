package com.example.musicplayer

import android.Manifest
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.media.MediaPlayer
import android.widget.Toast
import androidx.core.app.ActivityCompat

class MainActivity : AppCompatActivity() {

    companion object {
        const val PERMISSION_CALL_PHONE = 100

    }
    private lateinit var song:MediaPlayer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        song = MediaPlayer.create(applicationContext,R.raw.song)
        findViewById<Button>(R.id.play).setOnClickListener {
            song.start()

            // Check if read contacts permission is not granted if it isn't request it
            if(ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_CONTACTS)!= PackageManager.PERMISSION_GRANTED){
                ActivityCompat.requestPermissions(this,Array(1){ Manifest.permission.READ_CONTACTS},111)
            }else{ // if permission is granted, do something

            }
        }



    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        if (requestCode == PERMISSION_CALL_PHONE) {
            // Request for camera permission.
            if (grantResults.size == 1 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // permission granted do something
                Toast.makeText(this,"Permission Granted",Toast.LENGTH_LONG).show()
            } else {
                // Permission request was denied.
                Toast.makeText(this,"Please Grant permission",Toast.LENGTH_LONG).show()
            }
        }
    }
//done
}