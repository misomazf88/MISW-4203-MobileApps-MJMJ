package com.miso.vinilos.features.home.ui.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import kotlinx.coroutines.DelicateCoroutinesApi

/****
 * Project: vinilos
 * From: com.miso.vinilos.features.home.ui.viewModels
 * Created by Jhonnatan E. Zamudio P. on 3/11/2021 at 11:52 a. m.
 * All rights reserved 2021.
 ****/

@DelicateCoroutinesApi
@Suppress("UNCHECKED_CAST")
class InitialSetupViewModelFactory: ViewModelProvider.NewInstanceFactory() {
    companion object {
        @Volatile
        private var instance: InitialSetupViewModelFactory? = null
        fun getInstance(): InitialSetupViewModelFactory = instance ?: synchronized(this) {
            instance ?: InitialSetupViewModelFactory()
        }
    }

    override fun <T: ViewModel?> create(modelClass: Class<T>): T {
        return InitialSetupViewModel() as T
    }
}