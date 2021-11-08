package com.miso.vinilos.features.artist.ui.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.miso.vinilos.core.injection.Injector
import com.miso.vinilos.features.album.ui.viewModels.AlbumViewModel
import com.miso.vinilos.features.album.ui.viewModels.AlbumViewModelFactory
import com.miso.vinilos.features.artist.data.repository.ArtistRepository
import kotlinx.coroutines.DelicateCoroutinesApi

/****
 * Project: vinilos
 * From: com.miso.vinilos.features.artist.ui.viewModels
 * Created by Milena Castillo on 7/11/2021 at 5:27 p. m.
 * All rights reserved 2021.
 ****/

@DelicateCoroutinesApi
@Suppress("UNCHECKED_CAST")
class ArtistViewModelFactory (private val artistRepository: ArtistRepository) :
    ViewModelProvider.NewInstanceFactory() {
    companion object {
        @Volatile
        private var instance: ArtistViewModelFactory? = null
        fun getInstance() : ArtistViewModelFactory = instance ?: synchronized(this) {
            instance ?: ArtistViewModelFactory(Injector.providerArtistRepository())
        }
    }

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ArtistViewModel(artistRepository) as T
    }
}