package com.miso.vinilos.features.home.ui.viewModels

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import kotlinx.coroutines.DelicateCoroutinesApi

/****
 * Project: vinilos
 * From: com.miso.vinilos.features.home.ui.viewModels
 * Created by Jhonnatan E. Zamudio P. on 26/10/2021 at 10:57 p. m.
 * All rights reserved 2021.
 ****/

@DelicateCoroutinesApi
@Suppress("UNCHECKED_CAST")
class SplashScreenViewModelFactory: ViewModelProvider.NewInstanceFactory() {

    companion object {
        @Volatile
        private var instance: SplashScreenViewModelFactory? = null
        fun getInstance(): SplashScreenViewModelFactory = instance ?: synchronized(this) {
            instance ?: SplashScreenViewModelFactory()
        }
    }

    override fun <T: ViewModel?> create(modelClass: Class<T>): T {
        return SplashScreenViewModel() as T
    }
}