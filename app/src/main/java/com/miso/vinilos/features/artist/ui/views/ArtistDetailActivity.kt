package com.miso.vinilos.features.artist.ui.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.google.gson.Gson
import com.miso.vinilos.R
import com.miso.vinilos.features.artist.domain.entities.Artist
import com.miso.vinilos.features.artist.ui.viewModels.ArtistDetailViewModel
import com.miso.vinilos.features.artist.ui.viewModels.ArtistDetailViewModelFactory
import kotlinx.coroutines.DelicateCoroutinesApi

@DelicateCoroutinesApi
class ArtistDetailActivity : AppCompatActivity() {

    val gson = Gson()
    private lateinit var viewModel: ArtistDetailViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val artist = gson.fromJson(intent.getStringExtra("artist"), Artist::class.java)
        val viewModelFactory = ArtistDetailViewModelFactory.getInstance()
        viewModel = ViewModelProvider(this, viewModelFactory)[ArtistDetailViewModel::class.java]
        setContentView(R.layout.activity_artist_detail)
    }

}