package com.borisov.uiavtomator.espresso

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import com.borisov.uiavtomator.BuildConfig
import com.borisov.uiavtomator.R
import com.borisov.uiavtomator.TestConstants
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
            .perform(
                ViewActions.replaceText(TestConstants.QUERY_THIRD),
                ViewActions.closeSoftKeyboard()
            )
        Espresso.onView(withId(R.id.searchEditText)).perform(ViewActions.pressImeActionButton())

        if (BuildConfig.TYPE == MainActivity.FAKE) {
            Espresso.onView(withId(R.id.totalCountTextView))
                .check(
                    ViewAssertions
                        .matches(
                            ViewMatchers
                                .withText(TestConstants.RESULT_FORTY_TWO)
                        )
                )
        } else {
            Espresso.onView(ViewMatchers.isRoot()).perform((TestConstants.delay()))
            Espresso.onView(withId(R.id.totalCountTextView))
                .check(
                    ViewAssertions
                        .matches(
                            ViewMatchers
                                .withText(
                                    TestConstants
                                        .RESULT_TWO_THOUSAND_SIX_HUNDRED_SIXTY_EIGHT
                                )
                        )
                )
        }
    }

    @After
    fun close() {
        scenario.close()
    }
}