package com.miso.vinilos.features.home.domain.useCases

import android.Manifest
import android.content.Context
import com.miso.vinilos.BuildConfig
import com.miso.vinilos.core.utils.Network
import com.miso.vinilos.features.home.domain.models.enumerations.CodePermissions
import com.miso.vinilos.features.home.domain.models.enumerations.MessagePermissions

/****
 * Project: vinilos
 * From: com.miso.vinilos.features.home.domain.useCases
 * Created by Jhonnatan E. Zamudio P. on 29/10/2021 at 8:07 p. m.
 * All rights reserved 2021.
 ****/

class SplashScreenUseCase {

    fun getAppVersion(): String {
        val versionName = BuildConfig.VERSION_NAME
        return "Versión $versionName"
    }

    fun getCodePermission(permission: String): Int {
        return when (permission) {
            Manifest.permission.WRITE_EXTERNAL_STORAGE -> CodePermissions.WRITE_STORAGE.code
            Manifest.permission.CAMERA -> CodePermissions.CAMERA.code
            else -> CodePermissions.DEFAULT.code
        }
    }

    fun getMessagePermission(permission: String): String {
        return when (permission) {
            Manifest.permission.WRITE_EXTERNAL_STORAGE -> MessagePermissions.WRITE_STORAGE.value
            Manifest.permission.CAMERA -> MessagePermissions.CAMERA.value
            else -> MessagePermissions.DEFAULT.value
        }
    }

}