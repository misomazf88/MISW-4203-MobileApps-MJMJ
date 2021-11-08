package com.miso.vinilos.features.album.ui.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.miso.vinilos.core.injection.Injector
import com.miso.vinilos.features.album.data.repository.AlbumRepository
import kotlinx.coroutines.DelicateCoroutinesApi

/****
 * Project: vinilos
 * From: com.miso.vinilos.features.album.ui.viewModels
 * Created by Milena Castillo on 5/11/2021 at 8:13 p. m.
 * All rights reserved 2021.
 ****/

@DelicateCoroutinesApi
@Suppress("UNCHECKED_CAST")
class AlbumViewModelFactory(private val albumRepository: AlbumRepository) :
    ViewModelProvider.NewInstanceFactory() {
    companion object {
        @Volatile
        private var instance: AlbumViewModelFactory? = null
        fun getInstance() : AlbumViewModelFactory = instance ?: synchronized(this) {
            instance ?: AlbumViewModelFactory(Injector.providerAlbumRepository())
        }
    }

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return AlbumViewModel(albumRepository) as T
    }
}