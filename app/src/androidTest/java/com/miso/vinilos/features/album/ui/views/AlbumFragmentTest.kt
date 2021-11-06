package com.miso.vinilos.features.album.ui.views

import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import com.miso.vinilos.features.home.ui.views.SplashScreenActivity
import kotlinx.coroutines.DelicateCoroutinesApi
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.Rule
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.rule.GrantPermissionRule
import org.hamcrest.Matchers.allOf

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
        val appCompatButton = onView(
            allOf(
                ViewMatchers.withId(com.miso.vinilos.R.id.buttonVisitor),
                ViewMatchers.withText("Visitante"),
                isDisplayed()
            )
        )
        appCompatButton.perform(ViewActions.click())
    }
}
