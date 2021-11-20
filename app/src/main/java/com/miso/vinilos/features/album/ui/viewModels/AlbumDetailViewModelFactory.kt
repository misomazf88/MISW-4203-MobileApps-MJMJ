package com.miso.vinilos.features.album.ui.viewModels

import android.annotation.SuppressLint
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.miso.vinilos.features.home.ui.viewModels.SplashScreenViewModel
import com.miso.vinilos.features.home.ui.viewModels.SplashScreenViewModelFactory
import kotlinx.coroutines.DelicateCoroutinesApi

/****
 * Project: vinilos
 * From: com.miso.vinilos.features.album.ui.viewModels
 * Created by Milena Castillo on 19/11/2021 at 8:38 p. m.
 * All rights reserved 2021.
 ****/

@SuppressLint("CustomSplashScreen")
@DelicateCoroutinesApi
@Suppress("UNCHECKED_CAST")
class AlbumDetailViewModelFactory: ViewModelProvider.NewInstanceFactory() {

    companion object {
        @Volatile
        private var instance: AlbumDetailViewModelFactory? = null
        fun getInstance(): AlbumDetailViewModelFactory = instance ?: synchronized(this) {
            instance ?: AlbumDetailViewModelFactory()
        }
    }

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return AlbumDetailViewModel() as T
    }
}