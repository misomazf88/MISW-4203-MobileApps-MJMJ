package com.miso.vinilos.features.home.ui.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/****
 * Project: vinilos
 * From: com.miso.vinilos.features.home.ui.viewModels
 * Created by Jhonnatan E. Zamudio P. on 26/10/2021 at 10:50 p. m.
 * All rights reserved 2021.
 ****/

class SplashScreenViewModel: ViewModel() {

    private val _loading = MutableLiveData<Boolean>()
    val loading: LiveData<Boolean> = _loading
    private val _version = MutableLiveData<String>()
    val version: LiveData<String> = _version

    init {

    }


}