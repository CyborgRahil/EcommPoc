package com.rahil.ecommpoc.appUi.homePage.fragment

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.IdlingResource
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4
import com.nhaarman.mockito_kotlin.mock
import com.rahil.ecommpoc.appUi.homePage.MainActivity
import com.rahil.ecommpoc.presentation.homePage.HomePageContract
import com.rahil.ecommpocUi.R
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@Suppress("DEPRECATION")
@RunWith(AndroidJUnit4::class)
class HomeFragmentTest {

    val mockHomePagePresenter:HomePageContract.HomePagePresenter = mock()

    @get:Rule
    val activityTestRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun testNavigationToHomeScreen() {
        activityTestRule.launchActivity(null)
        onView(ViewMatchers.withId(R.id.tv_featured_label)).check(matches(isDisplayed()))
    }
}