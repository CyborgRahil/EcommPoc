package com.rahil.ecommpoc.appUi.homePage

import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4
import com.rahil.ecommpocUi.R
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@Suppress("DEPRECATION")
@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @Rule @JvmField
    val activity = ActivityTestRule<MainActivity>(MainActivity::class.java, false, false)

    @Test
    fun activityLaunches() {
        activity.launchActivity(null)
        Espresso.onView(ViewMatchers.withId(R.id.tv_featured_label))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }

    @Test
    fun changeFragmentAfterClickOnBottomNavigation() {
        activity.launchActivity(null)
        Espresso.onView(ViewMatchers.withId(R.id.tv_featured_label))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(ViewMatchers.withId(R.id.nav_my_jobs))
            .perform(click())
        Espresso.onView(ViewMatchers.withId(R.id.tv_home))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }
}