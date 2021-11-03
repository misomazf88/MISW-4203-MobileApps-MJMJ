package com.miso.vinilos.core.utils

import android.content.Context
import android.content.SharedPreferences

/****
 * Project: vinilos
 * From: com.miso.vinilos.core.utils
 * Created by Jhonnatan E. Zamudio P. on 3/11/2021 at 11:42 a. m.
 * All rights reserved 2021.
 ****/

class SharedPreferences {

    val namePreferences = "USER"

    fun getData(context: Context, key: String): String? {
        val sharedPreferences: SharedPreferences =
            context.getSharedPreferences(namePreferences, Context.MODE_PRIVATE)
        return sharedPreferences.getString(key, "0")
    }

    fun setData(context: Context, key: String, value: String) {
        val sharedPreferences: SharedPreferences =
            context.getSharedPreferences(namePreferences, Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.putString(key, value)
        editor.apply()
    }
}