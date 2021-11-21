package com.miso.vinilos.features.artist.ui.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.gson.Gson
import com.miso.vinilos.R
import com.miso.vinilos.features.artist.domain.entities.Artist

class ArtistDetailActivity : AppCompatActivity() {

    val gson = Gson()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val artist = gson.fromJson(intent.getStringExtra("artist"), Artist::class.java)
        println("Los datos son: " + artist)
        setContentView(R.layout.activity_artist_detail)
    }

}