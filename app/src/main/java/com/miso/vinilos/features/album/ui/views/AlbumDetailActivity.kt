package com.miso.vinilos.features.album.ui.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.google.gson.Gson
import com.miso.vinilos.R
import com.miso.vinilos.databinding.ActivityAlbumDetailBinding
import com.miso.vinilos.features.album.domain.entities.Album
import com.miso.vinilos.features.album.ui.viewModels.AlbumDetailViewModel
import com.miso.vinilos.features.album.ui.viewModels.AlbumDetailViewModelFactory
import kotlinx.coroutines.DelicateCoroutinesApi

@DelicateCoroutinesApi
class AlbumDetailActivity : AppCompatActivity() {

    val gson = Gson()
    private lateinit var viewModel: AlbumDetailViewModel
    private lateinit var binding: ActivityAlbumDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val album = gson.fromJson(intent.getStringExtra("album"), Album::class.java)
        val viewModelFactory = AlbumDetailViewModelFactory.getInstance()
        viewModel = ViewModelProvider(this, viewModelFactory)[AlbumDetailViewModel::class.java]
        setContentView(R.layout.activity_album_detail)
        println("El album seleccionado es: " + album)
    }
}