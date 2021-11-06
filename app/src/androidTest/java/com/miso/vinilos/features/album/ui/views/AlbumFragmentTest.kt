package com.miso.vinilos.features.album.ui.views

import android.view.InputDevice
import android.view.MotionEvent
import android.view.View
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import com.miso.vinilos.features.home.ui.views.SplashScreenActivity
import kotlinx.coroutines.DelicateCoroutinesApi
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.Rule
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.rule.GrantPermissionRule
import com.miso.vinilos.R
import org.hamcrest.Matchers.allOf

import androidx.test.espresso.ViewAction
import androidx.test.espresso.action.*


/****
 * Project: vinilos
 * From: com.miso.vinilos.features.album.ui.views
 * Created by Juan Jose Chiroque on 6/11/2021 at 8:37 a. m.
 * All rights reserved 2021.
 */

@DelicateCoroutinesApi
@LargeTest
@RunWith(androidx.test.runner.AndroidJUnit4::class)
class AlbumFragmentTest {

    @Rule
    @JvmField
    var mActivityTestRule = ActivityTestRule(SplashScreenActivity::class.java)

    @Rule
    @JvmField
    var mGrantPermissionRule =
        GrantPermissionRule.grant(
            "android.permission.CAMERA",
            "android.permission.WRITE_EXTERNAL_STORAGE"
        )

    @Test
    fun goToDashboard() {
        val buttonVisitor = onView(
            allOf(
                withId(com.miso.vinilos.R.id.buttonVisitor),
                withText("Visitante"),
                isDisplayed()
            )
        )
        buttonVisitor.perform(ViewActions.click())
    }

    @Test
    fun navigateBetweenTabs() {
        goToDashboard()
        val viewArtist = onView(allOf(
            withId(R.id.bottom_nav),
            isDisplayed()
        ))
            viewArtist.perform(clickXY(0.5f,0.5f))
        val viewCollector = onView(allOf(
            withId(R.id.bottom_nav),
            isDisplayed()
        ))
        for(x in 0..10)
            viewCollector.perform(clickXY(0.8f +(0.01f*x),0.5f))
    }

    @Test
    fun clickToBack() {
        goToDashboard()
        val buttonBack = onView(
            allOf(
                withId(com.miso.vinilos.R.id.btnBack),
                isDisplayed()
            )
        )
        buttonBack.perform(ViewActions.click())
    }

}

fun clickXY(pctX: Float, pctY: Float): ViewAction? {
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
