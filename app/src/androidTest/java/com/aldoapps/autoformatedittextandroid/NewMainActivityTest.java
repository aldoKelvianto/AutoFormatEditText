package com.aldoapps.autoformatedittextandroid;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Instrumentation test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class NewMainActivityTest {

    @Rule
    public ActivityTestRule<NewMainActivity> rule = new ActivityTestRule<>(NewMainActivity.class);

    @Test
    public void textViewTest() throws Exception {
        onView(withId(R.id.et_test_1))
                .perform(typeText("."))
                .check(matches(withText("0.")))
                .check(matches(TextViewSelectionMatcher.withSelection(2)));
    }
}

