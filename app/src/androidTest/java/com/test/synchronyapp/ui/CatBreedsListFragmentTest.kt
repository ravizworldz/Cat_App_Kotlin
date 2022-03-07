package com.test.synchronyapp.ui

import androidx.fragment.app.testing.FragmentScenario
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.lifecycle.Lifecycle
import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.test.synchronyapp.R
import com.test.synchronyapp.ui.fragment.CatBreedsListFragment
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class CatBreedsListFragmentTest {
    private lateinit var scenario: FragmentScenario<CatBreedsListFragment>

    @Before
    fun setUp() {
        scenario = launchFragmentInContainer(themeResId = com.test.synchronyapp.R.style.Theme_SynchronyApp)
        scenario.moveToState(Lifecycle.State.RESUMED)
    }

    @Test
    fun scrollRecyclerView() {
        try {
            Thread.sleep(2000)
        } catch (e: InterruptedException) {
            e.printStackTrace()
        }
       Espresso.onView(ViewMatchers.withId(R.id.recyclerViewCatBreeds)).perform(
            ScrollToBottomAction()
        )
    }

    @Test
    fun ClickRecyclerView() {
        try {
            Thread.sleep(2000)
        } catch (e: InterruptedException) {
            e.printStackTrace()
        }
        Espresso.onView(ViewMatchers.withId(R.id.recyclerViewCatBreeds)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
    }
}