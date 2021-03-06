package com.miso.vinilos.features.artist.ui.views

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
 * From: com.miso.vinilos.features.artist.ui.views
 * Created by Miguel Zapata on 21/11/2021 at 4:10 p. m.
 * All rights reserved 2021.
 */

@DelicateCoroutinesApi
@LargeTest
@RunWith(androidx.test.runner.AndroidJUnit4::class)
class ArtistDetailActivityTest {

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
    fun clickToArtistWithAlbums() {
        val buttonVisitor = Espresso.onView(
            Matchers.allOf(
                ViewMatchers.withId(R.id.buttonCollector),
                ViewMatchers.withText("Coleccionista"),
                ViewMatchers.isDisplayed()
            )
        )
        buttonVisitor.perform(ViewActions.click())
        val viewArtist = Espresso.onView(
            Matchers.allOf(
                ViewMatchers.withId(R.id.bottom_nav),
                ViewMatchers.isDisplayed()
            )
        )
        viewArtist.perform(ClickScreen().XY(0.5f,0.5f))
        Espresso.onView(ViewMatchers.withId(R.id.rvArtistas))
            .perform(
                RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                    0,
                    ViewActions.click()
                )
            )
        runBlocking {
            delay(3000)
        }
        Espresso.pressBack()
    }

}