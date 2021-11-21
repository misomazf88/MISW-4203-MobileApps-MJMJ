package com.miso.vinilos.features.artist.ui.viewModels

import android.annotation.SuppressLint
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import kotlinx.coroutines.DelicateCoroutinesApi

/****
 * Project: vinilos
 * From: com.miso.vinilos.features.artist.ui.viewModels
 * Created by Jhonnatan E. Zamudio P. on 21/11/2021 at 3:10 p. m.
 * All rights reserved 2021.
 ****/

@SuppressLint("CustomSplashScreen")
@DelicateCoroutinesApi
@Suppress("UNCHECKED_CAST")
class ArtistDetailViewModelFactory: ViewModelProvider.NewInstanceFactory() {

    companion object {
        @Volatile
        private var instance: ArtistDetailViewModelFactory? = null
        fun getInstance(): ArtistDetailViewModelFactory = instance ?: synchronized(this) {
            instance ?: ArtistDetailViewModelFactory()
        }
    }

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ArtistDetailViewModel() as T
    }
}