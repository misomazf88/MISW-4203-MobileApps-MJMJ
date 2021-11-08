package com.miso.vinilos.features.home.ui.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class InitialSetupViewModel: ViewModel() {

    private val _typeUser = MutableLiveData<String>()
    val typeUser: LiveData<String> = _typeUser

    fun setTypeUser(type: String) {
        _typeUser.value = type
    }
}