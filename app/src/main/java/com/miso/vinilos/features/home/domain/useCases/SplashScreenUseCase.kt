package com.miso.vinilos.features.home.domain.useCases

import com.miso.vinilos.BuildConfig

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

}