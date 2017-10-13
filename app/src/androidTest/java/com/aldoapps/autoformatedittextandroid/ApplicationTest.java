package com.aldoapps.autoformatedittextandroid;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import android.support.test.espresso.assertion.ViewAssertions;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import static android.support.test.espresso.Espresso.onView;

/**
 * Instrumentation test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ApplicationTest {

    @Rule
    public ActivityTestRule<MainActivity> rule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void textViewTest() throws Exception {
        onView(ViewMatchers.withId(R.id.tv_description))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()));
    }
}

