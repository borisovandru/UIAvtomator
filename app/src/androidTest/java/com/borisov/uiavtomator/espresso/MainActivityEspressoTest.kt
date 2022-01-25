package com.borisov.uiavtomator.espresso

import android.view.View
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso
import androidx.test.espresso.UiController
import androidx.test.espresso.ViewAction
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.hamcrest.Matcher
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import com.borisov.uiavtomator.BuildConfig
import com.borisov.uiavtomator.R
import com.borisov.uiavtomator.view.search.MainActivity

@RunWith(AndroidJUnit4::class)
class MainActivityEspressoTest {

    private lateinit var scenario: ActivityScenario<MainActivity>

    @Before
    fun setup() {
        scenario = ActivityScenario.launch(MainActivity::class.java)
    }

    @Test
    fun activitySearch_IsWorking() {
        Espresso.onView(withId(R.id.searchEditText)).perform(ViewActions.click())
        Espresso.onView(withId(R.id.searchEditText))
            .perform(ViewActions.replaceText("algol"), ViewActions.closeSoftKeyboard())
        Espresso.onView(withId(R.id.searchEditText)).perform(ViewActions.pressImeActionButton())

        if (BuildConfig.TYPE == MainActivity.FAKE) {
            Espresso.onView(withId(R.id.totalCountTextView))
                .check(ViewAssertions.matches(ViewMatchers.withText("Number of results: 42")))
        } else {
            Espresso.onView(ViewMatchers.isRoot()).perform(delay())
            Espresso.onView(withId(R.id.totalCountTextView))
                .check(ViewAssertions.matches(ViewMatchers.withText("Number of results: 2812")))
        }
    }

    private fun delay(): ViewAction? {
        return object : ViewAction {
            override fun getConstraints(): Matcher<View> = ViewMatchers.isRoot()
            override fun getDescription(): String = "wait for $4 seconds"
            override fun perform(uiController: UiController, v: View?) {
                uiController.loopMainThreadForAtLeast(4000)
            }
        }
    }

    @After
    fun close() {
        scenario.close()
    }
}