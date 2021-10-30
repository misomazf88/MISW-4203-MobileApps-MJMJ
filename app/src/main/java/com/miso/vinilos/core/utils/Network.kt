package com.miso.vinilos.core.utils

import android.app.Activity
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build


/****
 * Project: vinilos
 * From: com.miso.vinilos.features.home.ui.viewModels
 * Created by Jhonnatan E. Zamudio P. on 26/10/2021 at 10:50 p. m.
 * All rights reserved 2021.
 ****/

class Network {

    fun isOnline(context: Context):Boolean{
        var result = false
        val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager?
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            cm?.run {
                cm.getNetworkCapabilities(cm.activeNetwork)?.run {
                    result = when {
                        hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true
                        hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true
                        hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> true
                        else -> false
                    }
                }
            }
        } else {
            cm?.run {
                @Suppress("DEPRECATION")
                cm.activeNetworkInfo?.run {
                    if (type == ConnectivityManager.TYPE_WIFI)
                        result = true
                    else if (type == ConnectivityManager.TYPE_MOBILE)
                        result = true
                }
            }
        }
        return result
    }

}