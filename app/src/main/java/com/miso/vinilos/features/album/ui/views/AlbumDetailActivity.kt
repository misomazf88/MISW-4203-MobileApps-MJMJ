package com.miso.vinilos.features.album.ui.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.bumptech.glide.Glide
import com.google.gson.Gson
import com.miso.vinilos.R
import com.miso.vinilos.core.utils.MyItemDecoration
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
        binding = DataBindingUtil.setContentView(this, R.layout.activity_album_detail)
        binding.lifecycleOwner = this
        binding.vModel = viewModel
        binding.rvCancionesAlbum.layoutManager = GridLayoutManager(this,1,GridLayoutManager.VERTICAL,false)
        binding.rvCancionesAlbum.addItemDecoration(MyItemDecoration(2))
        viewModel.setAlbum(album)
        viewModel.album.observe(this, {
            Glide.with(this)
                .load(it.cover)
                .skipMemoryCache(true)
                .into(binding.imageAlbum)
            binding.titleAlbum.text = it.name
            binding.artistAlbum.text = it.performers.get(0).name
            binding.descriptionAlbum.text = it.description
        })
    }
}