package com.miso.vinilos.features.album.ui.views

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import com.miso.vinilos.features.home.ui.views.SplashScreenActivity
import kotlinx.coroutines.DelicateCoroutinesApi
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.Rule
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.rule.GrantPermissionRule
import com.miso.vinilos.R
import org.hamcrest.Matchers.allOf
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition
import com.miso.vinilos.core.ClickScreen

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
        buttonVisitor.perform(click())
    }

    @Test
    fun navigateBetweenTabs() {
        goToDashboard()
        val viewArtist = onView(allOf(
            withId(R.id.bottom_nav),
            isDisplayed()
        ))
            viewArtist.perform(ClickScreen().XY(0.5f,0.5f))
        val viewCollector = onView(allOf(
            withId(R.id.bottom_nav),
            isDisplayed()
        ))
        for(x in 0..10)
            viewCollector.perform(ClickScreen().XY(0.8f +(0.01f*x),0.5f))
    }

    @Test
    fun clickToBack() {
        goToDashboard()
        val buttonBack = onView(
            allOf(
                withId(R.id.btnBack),
                isDisplayed()
            )
        )
        buttonBack.perform(click())
    }

    @Test
    fun clickToAlbum() {
        goToDashboard()
        onView(withId(R.id.rvAlbumes))
            .perform(actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        Espresso.pressBack()
    }

}

