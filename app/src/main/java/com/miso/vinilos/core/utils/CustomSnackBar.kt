package com.miso.vinilos.core.utils

import android.content.Context
import android.graphics.Color
import android.os.Build
import androidx.constraintlayout.widget.ConstraintLayout
import com.google.android.material.snackbar.BaseTransientBottomBar
import com.google.android.material.snackbar.Snackbar
import com.miso.vinilos.R
import com.miso.vinilos.core.models.enumerations.TypeSnackBar
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlin.system.exitProcess

/****
 * Project: vinilos
 * From: com.miso.vinilos.features.home.ui.viewModels
 * Created by Jhonnatan E. Zamudio P. on 26/10/2021 at 10:50 p. m.
 * All rights reserved 2021.
 ****/


class CustomSnackBar {
    @DelicateCoroutinesApi
    fun showSnackBar(message: String, layoutContain: ConstraintLayout, type: Int, context: Context) {
        when(type){
            TypeSnackBar.CLOSE_APP.code -> {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M)
                    buildSnackBar(layoutContain, message, context.getString(R.string.close), true,
                        context.getColor(R.color.error))
                else
                    Color.RED
            }
            TypeSnackBar.ERROR.code -> {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M)
                    buildSnackBar(layoutContain, message, context.getString(R.string.close), false,
                        context.getColor(R.color.error))
                else
                    Color.RED
            }
            TypeSnackBar.INFO.code -> {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M)
                    buildSnackBar(layoutContain, message, context.getString(R.string.close), false,
                        context.getColor(R.color.information))
                else
                    Color.RED
            }
            TypeSnackBar.WARNING.code -> {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M)
                    buildSnackBar(layoutContain, message, context.getString(R.string.close), false,
                        context.getColor(R.color.warning))
                else
                    Color.RED
            }
            TypeSnackBar.SUCCESS.code -> {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M)
                    buildSnackBar(layoutContain, message, context.getString(R.string.close), false,
                        context.getColor(R.color.successful))
                else
                    Color.RED
            }
        }
    }

    @DelicateCoroutinesApi
    private fun buildSnackBar(layoutContain: ConstraintLayout, message: String, messageAction: String,
                              exit: Boolean, rgb: Int) {
        val mySnackbar = Snackbar.make(layoutContain, message, Snackbar.LENGTH_INDEFINITE)
        mySnackbar.setAction(messageAction) {
            if (exit)
                exitProcess(0)
        }
            .addCallback(object : BaseTransientBottomBar.BaseCallback<Snackbar>() {
                override fun onShown(transientBottomBar: Snackbar?) {
                    super.onShown(transientBottomBar)
                }

                override fun onDismissed(transientBottomBar: Snackbar?, event: Int) {
                    super.onDismissed(transientBottomBar, event)
                }
            })
        mySnackbar.setBackgroundTint(rgb)
        mySnackbar.show()


    }

}