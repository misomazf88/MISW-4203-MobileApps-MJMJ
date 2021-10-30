package com.miso.vinilos.features.home.ui.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.miso.vinilos.features.home.domain.useCases.SplashScreenUseCase
import kotlinx.coroutines.*

/****
 * Project: vinilos
 * From: com.miso.vinilos.features.home.ui.viewModels
 * Created by Jhonnatan E. Zamudio P. on 26/10/2021 at 10:50 p. m.
 * All rights reserved 2021.
 ****/

@DelicateCoroutinesApi
class SplashScreenViewModel: ViewModel() {

    private val splashScreenUseCase = SplashScreenUseCase()
    private val _loading = MutableLiveData<Boolean>()
    val loading: LiveData<Boolean> = _loading
    private val _version = MutableLiveData<String>()
    val version: LiveData<String> = _version

    init {
        setLoading(true)
        GlobalScope.launch {
            withContext(Dispatchers.IO) {
                getAppVersion()
            }
        }
    }

    private fun getAppVersion() {
        viewModelScope.launch {
            setVersion(splashScreenUseCase.getAppVersion())
        }
    }

    private fun setVersion(version: String) {
        _version.value = version
    }

    private fun setLoading(status: Boolean) {
        _loading.value = status
    }

}