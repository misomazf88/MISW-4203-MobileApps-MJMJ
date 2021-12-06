package com.miso.vinilos.features.album.ui.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.miso.vinilos.R
import com.miso.vinilos.core.models.enumerations.TypeSnackBar
import com.miso.vinilos.core.utils.CustomSnackBar
import com.miso.vinilos.databinding.ActivityCreateAlbumBinding
import com.miso.vinilos.features.album.ui.viewModels.AlbumCreateViewModel
import com.miso.vinilos.features.album.ui.viewModels.AlbumCreateViewModelFactory
import kotlinx.coroutines.DelicateCoroutinesApi

@DelicateCoroutinesApi
class CreateAlbumActivity : AppCompatActivity() {

    private lateinit var viewModel: AlbumCreateViewModel
    private lateinit var binding: ActivityCreateAlbumBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewModelFactory = AlbumCreateViewModelFactory.getInstance()
        viewModel = ViewModelProvider(this, viewModelFactory)[AlbumCreateViewModel::class.java]
        binding = DataBindingUtil.setContentView(this, R.layout.activity_create_album)
        binding.lifecycleOwner = this
        binding.vModel = viewModel
        viewModel.messageSnackBar.observe(this, {
            CustomSnackBar().showSnackBar(
                it,
                binding.layoutContain,
                TypeSnackBar.ERROR.code,
                this
            )
        })
    }
}