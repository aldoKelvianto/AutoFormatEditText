package com.aldoapps.autoformatedittextandroid;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.aldoapps.autoformatedittext.CurrencyLocale;
import com.aldoapps.autoformatedittextandroid.util.TextViewSelectionMatcher;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
public class NewMainActivityTest {

    @Rule
    public ActivityTestRule<NewMainActivity> rule = new ActivityTestRule<>(NewMainActivity.class);

    @Before
    public void setup() throws Exception {
        CurrencyLocale.getInstance().useLocaleWithCommaGroupSeparator();
    }

    @Test
    public void textViewTest() throws Exception {
        onView(withId(R.id.et_test_1))
                .perform(typeText("."))
                .check(matches(withText("0.")))
                .check(matches(TextViewSelectionMatcher.withSelection(2)));
    }
}

