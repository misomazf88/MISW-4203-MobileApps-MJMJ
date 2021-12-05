package com.miso.vinilos.features.album.ui.viewModels

import android.annotation.SuppressLint
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.miso.vinilos.core.injection.Injector
import com.miso.vinilos.features.album.data.repository.AlbumRepository
import com.miso.vinilos.features.artist.data.repository.ArtistRepository
import kotlinx.coroutines.DelicateCoroutinesApi

/****
 * Project: vinilos
 * From: com.miso.vinilos.features.album.ui.viewModels
 * Created by Miguel Zapata on 5/12/2021 at 6:48 p. m.
 * All rights reserved 2021.
 ****/

@SuppressLint("CustomSplashScreen")
@DelicateCoroutinesApi
@Suppress("UNCHECKED_CAST")
class AlbumCreateViewModelFactory (
    private val albumRepository: AlbumRepository,
    private val artistRepository: ArtistRepository
) : ViewModelProvider.NewInstanceFactory() {
    companion object {
        @Volatile
        private var instance: AlbumCreateViewModelFactory? = null
        fun getInstance(): AlbumCreateViewModelFactory = instance ?: synchronized(this) {
            instance ?: AlbumCreateViewModelFactory(Injector.providerAlbumRepository(), Injector.providerArtistRepository())
        }
    }

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return AlbumCreateViewModel(albumRepository,artistRepository) as T
    }
}