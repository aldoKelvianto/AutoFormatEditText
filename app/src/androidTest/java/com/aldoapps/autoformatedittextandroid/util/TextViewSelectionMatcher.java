package com.aldoapps.autoformatedittextandroid.util;

import android.support.test.espresso.matcher.BoundedMatcher;
import android.view.View;
import android.widget.EditText;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;

/**
 * Created by aldo on 13/10/17.
 */

public class TextViewSelectionMatcher {

    public static Matcher<View> withSelection(int selection) {
        return withSelection(Matchers.is(selection));
    }

    private static Matcher<View> withSelection(final Matcher<Integer> integerMatcher) {
        return new BoundedMatcher<View, EditText>(EditText.class) {
            @Override
            public void describeTo(Description description) {
                description.appendText("With selection text: ");
                integerMatcher.describeTo(description);
            }

            @Override
            protected boolean matchesSafely(EditText editText) {
                return integerMatcher.matches(editText.getSelectionEnd());
            }
        };
    }
}
