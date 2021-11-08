package com.miso.vinilos.features.artist.ui.views

import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import androidx.test.rule.GrantPermissionRule
import com.miso.vinilos.R
import com.miso.vinilos.core.ClickScreen
import com.miso.vinilos.features.home.ui.views.SplashScreenActivity
import kotlinx.coroutines.DelicateCoroutinesApi
import org.hamcrest.Matchers
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

/****
 * Project: vinilos
 * From: com.miso.vinilos.features.artist.ui.views
 * Created by Jhonnatan E. Zamudio P. on 7/11/2021 at 6:58 p. m.
 * All rights reserved 2021.
 */

@DelicateCoroutinesApi
@LargeTest
@RunWith(androidx.test.runner.AndroidJUnit4::class)
class ArtistFragmentTest {

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
    fun goToArtists() {
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
    }

}