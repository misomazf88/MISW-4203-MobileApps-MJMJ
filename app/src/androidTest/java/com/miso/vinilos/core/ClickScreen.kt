package com.miso.vinilos.core

import android.view.InputDevice
import android.view.MotionEvent
import androidx.test.espresso.ViewAction
import androidx.test.espresso.action.*

/****
 * Project: vinilos
 * From: com.miso.vinilos.core
 * Created by Jhonnatan E. Zamudio P. on 7/11/2021 at 7:05 p. m.
 * All rights reserved 2021.
 ****/

class ClickScreen {
    fun XY(pctX: Float, pctY: Float): ViewAction? {
        println(GeneralLocation.CENTER)
        return ViewActions.actionWithAssertions(
            GeneralClickAction(
                Tap.SINGLE,
                { view ->
                    val screenPos = IntArray(2)
                    view.getLocationOnScreen(screenPos)
                    val w = view.width
                    val h = view.height
                    val x = (w * pctX)
                    val y = (h * pctY)
                    val screenX = screenPos[0] + x
                    val screenY = screenPos[1] + y
                    floatArrayOf(screenX, screenY)
                },
                Press.FINGER,
                InputDevice.SOURCE_UNKNOWN,
                MotionEvent.BUTTON_PRIMARY
            )
        )
    }
}