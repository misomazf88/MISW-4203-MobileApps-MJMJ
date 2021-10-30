package com.miso.vinilos.features.home.ui.viewModels

import android.Manifest
import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.miso.vinilos.features.home.domain.models.entities.Permission
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
    private val _validatePermissions = MutableLiveData<Boolean>()
    val validatePermissions:LiveData<Boolean> = _validatePermissions
    private val _permission = MutableLiveData<Permission>()
    val permission: LiveData<Permission> = _permission

    init {
        setLoading(true)
        GlobalScope.launch {
            withContext(Dispatchers.IO) {
                getAppVersion()
            }
        }
        setValidatePermissions(true)
    }

    fun hasPermission(context: Context, permission: String) {
        setPermission(permission)
        /*when (EasyPermissions.hasPermissions(context, permission)) {
            true -> when (codPermission.value) {
                CodePermissions.CAMERA.code -> checkOnline(context)
                CodePermissions.WRITE_STORAGE.code -> hasPermission(
                    context,
                    Manifest.permission.CAMERA
                )
            }
            false -> requestPermission.postValue(true)
        }*/
    }

    private fun setPermission(permission: String) {
        _permission.value = Permission(
            permission,
            splashScreenUseCase.getCodePermission(permission),
            splashScreenUseCase.getMessagePermission(permission)
        )
    }

    private fun setValidatePermissions(status: Boolean) {
        _validatePermissions.value = status
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