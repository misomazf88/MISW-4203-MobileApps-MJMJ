package com.miso.vinilos.features.collector.ui.views

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import androidx.test.rule.GrantPermissionRule
import com.miso.vinilos.R
import com.miso.vinilos.core.ClickScreen
import com.miso.vinilos.features.home.ui.views.SplashScreenActivity
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import org.hamcrest.Matchers
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

/****
 * Project: vinilos
 * From: com.miso.vinilos.features.collector.ui.views
 * Created by Jhonnatan E. Zamudio P. on 4/12/2021 at 10:36 p. m.
 * All rights reserved 2021.
 */

@DelicateCoroutinesApi
@LargeTest
@RunWith(androidx.test.runner.AndroidJUnit4::class)
class CollectorDetailActivityTest {

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
    fun goToDetailCollectorWithAllData() {
        val buttonVisitor = Espresso.onView(
            Matchers.allOf(
                ViewMatchers.withId(R.id.buttonVisitor),
                ViewMatchers.withText("Visitante"),
                ViewMatchers.isDisplayed()
            )
        )
        buttonVisitor.perform(ViewActions.click())
        val viewCollector = Espresso.onView(
            Matchers.allOf(
                ViewMatchers.withId(R.id.bottom_nav),
                ViewMatchers.isDisplayed()
            )
        )
        for(x in 0..10)
            viewCollector.perform(ClickScreen().XY(0.8f +(0.01f*x),0.5f))
        Espresso.onView(ViewMatchers.withId(R.id.rvCollectors))
            .perform(
                RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                    0,
                    ViewActions.click()
                )
            )
        runBlocking {
            delay(1000)
        }
        Espresso.onView(ViewMatchers.withId(R.id.rvArtistFavorites))
            .perform(
                RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                    0,
                    ViewActions.click()
                )
            )
        runBlocking {
            delay(500)
        }
        Espresso.pressBack()
        Espresso.onView(ViewMatchers.withId(R.id.rvAlbumsCreate))
            .perform(
                RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                    0,
                    ViewActions.click()
                )
            )
        runBlocking {
            delay(500)
        }
        Espresso.pressBack()
        runBlocking {
            delay(300)
        }
        Espresso.pressBack()
    }

}