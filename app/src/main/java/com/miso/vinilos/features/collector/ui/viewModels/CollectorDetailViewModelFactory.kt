package com.miso.vinilos.features.collector.ui.viewModels

import android.annotation.SuppressLint
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.miso.vinilos.core.injection.Injector
import com.miso.vinilos.features.album.data.repository.AlbumRepository
import com.miso.vinilos.features.artist.data.repository.ArtistRepository
import kotlinx.coroutines.DelicateCoroutinesApi

/****
 * Project: vinilos
 * From: com.miso.vinilos.features.collector.ui.viewModels
 * Created by Milena Castillo on 4/12/2021 at 6:55 p. m.
 * All rights reserved 2021.
 ****/

@SuppressLint("CustomSplashScreen")
@DelicateCoroutinesApi
@Suppress("UNCHECKED_CAST")
class CollectorDetailViewModelFactory(
    private val albumRepository: AlbumRepository,
    private val artistRepository: ArtistRepository
) : ViewModelProvider.NewInstanceFactory() {
    companion object {
        @Volatile
        private var instance: CollectorDetailViewModelFactory? = null
        fun getInstance(): CollectorDetailViewModelFactory = instance ?: synchronized(this) {
            instance ?: CollectorDetailViewModelFactory(Injector.providerAlbumRepository(), Injector.providerArtistRepository())
        }
    }

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return CollectorDetailViewModel(albumRepository,artistRepository) as T
    }
}