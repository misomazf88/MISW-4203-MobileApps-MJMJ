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
 * Created by Milena Castillo on 21/11/2021 at 9:33 p. m.
 * All rights reserved 2021.
 */

@DelicateCoroutinesApi
@LargeTest
@RunWith(androidx.test.runner.AndroidJUnit4::class)
class CollectorFragmentTest {

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
    fun goToVisitor() {
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
    }

    @Test
    fun clickToCollector() {
        goToVisitor()
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
        Espresso.pressBack()
    }

    @Test
    fun clickToBack() {
        goToVisitor()
        val buttonBack = Espresso.onView(
            Matchers.allOf(
                ViewMatchers.withId(R.id.btnBack),
                ViewMatchers.isDisplayed()
            )
        )
        buttonBack.perform(ViewActions.click())
    }

    @Test
    fun goToCollectors() {
        val buttonVisitor = Espresso.onView(
            Matchers.allOf(
                ViewMatchers.withId(R.id.buttonCollector),
                ViewMatchers.withText("Coleccionista"),
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
    }

    @Test
    fun clickToCreateAlbum() {
        goToCollectors()
        val buttonCreateAlbum = Espresso.onView(
            Matchers.allOf(
                ViewMatchers.withId(R.id.btnCreate),
                ViewMatchers.withText("Crear álbum"),
                ViewMatchers.isDisplayed()
            )
        )
        buttonCreateAlbum.perform(ViewActions.click())
        runBlocking {
            delay(1000)
        }
        Espresso.pressBack()
    }

}