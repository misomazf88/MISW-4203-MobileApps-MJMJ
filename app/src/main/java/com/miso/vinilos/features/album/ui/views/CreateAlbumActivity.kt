package com.miso.vinilos.features.album.ui.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.miso.vinilos.R
import com.miso.vinilos.features.album.ui.viewModels.AlbumCreateViewModel
import com.miso.vinilos.features.album.ui.viewModels.AlbumCreateViewModelFactory
import kotlinx.coroutines.DelicateCoroutinesApi

@DelicateCoroutinesApi
class CreateAlbumActivity : AppCompatActivity() {

    private lateinit var viewModel: AlbumCreateViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewModelFactory = AlbumCreateViewModelFactory.getInstance()
        viewModel = ViewModelProvider(this, viewModelFactory)[AlbumCreateViewModel::class.java]
        setContentView(R.layout.activity_create_album)
    }
}