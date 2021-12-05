package com.miso.vinilos.features.artist.ui.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.google.gson.Gson
import com.miso.vinilos.R
import com.miso.vinilos.core.utils.MyItemDecoration
import com.miso.vinilos.databinding.ActivityArtistDetailBinding
import com.miso.vinilos.features.artist.domain.entities.Artist
import com.miso.vinilos.features.artist.ui.adapters.AlbumsAdapter
import com.miso.vinilos.features.artist.ui.viewModels.ArtistDetailViewModel
import com.miso.vinilos.features.artist.ui.viewModels.ArtistDetailViewModelFactory
import kotlinx.coroutines.DelicateCoroutinesApi

@DelicateCoroutinesApi
class ArtistDetailActivity : AppCompatActivity() {

    val gson = Gson()
    private lateinit var viewModel: ArtistDetailViewModel
    private lateinit var binding: ActivityArtistDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val artist = gson.fromJson(intent.getStringExtra("artist"), Artist::class.java)
        val viewModelFactory = ArtistDetailViewModelFactory.getInstance()
        viewModel = ViewModelProvider(this, viewModelFactory)[ArtistDetailViewModel::class.java]
        binding = DataBindingUtil.setContentView(this, R.layout.activity_artist_detail)
        binding.lifecycleOwner = this
        binding.vModel = viewModel
        binding.rvAlbumArtist.layoutManager = LinearLayoutManager(this)
        binding.rvAlbumArtist.addItemDecoration(MyItemDecoration(2))
        viewModel.setArtist(artist)
        viewModel.artist.observe(this,{
            Glide.with(this)
                .load(it.image)
                .skipMemoryCache(true)
                .into(binding.imageArtist)
            binding.txtNameArtist.text = it.name
            binding.descriptionArtist.text = it.description
            binding.txtBirthDate.text = it.birthDate!!.substring(0,10)
            binding.rvAlbumArtist.adapter = AlbumsAdapter(it.albums)
            if (it.albums.isEmpty())
                binding.layoutTitle.visibility = View.GONE
            else
                binding.textNotAlbums.visibility = View.GONE
        })
        binding.btnArrowBack.setOnClickListener {
            onBackPressed()
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }

}