package com.sample.sampleapp.ui.views.adapter

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.RootMatchers
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.rule.ActivityTestRule
import com.sample.sampleapp.R
import com.sample.sampleapp.ui.views.MainActivity
import org.hamcrest.Matchers
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import java.util.Objects

class CharacterAdapterTest {

    @get: Rule
    var activityRule = ActivityTestRule(MainActivity::class.java)

    @Before
    fun setUp() {
    }

    @Test
    fun VisibilityOfRecyclerview() {
        Espresso.onView(ViewMatchers.withId(R.id.rvCharacterNames))
            .inRoot(
                RootMatchers.withDecorView(
                    Matchers.`is`(
                        activityRule.activity.window.decorView
                    )
                )
            )
    }

    @Test
    fun ScrollingOfRecyclerView() {
        val recyclerView = activityRule.activity.findViewById<RecyclerView>(R.id.rvCharacterNames)
        val itemCount = Objects.requireNonNull(recyclerView.adapter!!).itemCount
        Espresso.onView(ViewMatchers.withId(R.id.rvCharacterNames))
            .inRoot(
                RootMatchers.withDecorView(
                    Matchers.`is`(
                        activityRule.activity.window.decorView
                    )
                )
            )
            .perform(RecyclerViewActions.scrollToPosition<CharacterAdapter.CharacterViewHolder>(itemCount -1))
    }

    @Test
    fun TestItemClick() {
        Espresso.onView(ViewMatchers.withId(R.id.rvCharacterNames))
            .inRoot(
                RootMatchers.withDecorView(
                    Matchers.`is`(
                        activityRule.activity.window.decorView
                    )
                )
            )
            .perform(
                RecyclerViewActions.actionOnItemAtPosition<CharacterAdapter.CharacterViewHolder>(
                    0,
                    ViewActions.click()
                )
            )
    }

}