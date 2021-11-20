package com.miso.vinilos.features.album.ui.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.gson.Gson
import com.miso.vinilos.R
import com.miso.vinilos.features.album.domain.entities.Album

class AlbumDetailActivity : AppCompatActivity() {

    val gson = Gson()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_album_detail)
        val album = gson.fromJson(intent.getStringExtra("album"), Album::class.java)
        println("El album seleccionado es: " + album)
    }
}