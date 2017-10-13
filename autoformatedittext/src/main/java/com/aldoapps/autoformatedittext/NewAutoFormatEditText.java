package com.aldoapps.autoformatedittext;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.InputFilter;
import android.text.method.DigitsKeyListener;
import android.util.AttributeSet;
import android.widget.EditText;

import java.util.StringTokenizer;

/**
 * Created by aldo on 21/08/16.
 */
public class NewAutoFormatEditText extends EditText {

    private static final int MAX_LENGTH = 19;

    private static final int ACTION_DELETE = 0;

    private static final int ACTION_INSERT = 1;

    private int prevCommaAmount;

    private boolean isFormatting;

    private boolean isDecimal;

    private boolean useComma;

    public NewAutoFormatEditText(Context context) {
        super(context);
        initialize();
    }

    public NewAutoFormatEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        initialize(attrs);
    }

    public NewAutoFormatEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initialize(attrs);
    }

    private void initialize() {
        initialize(null);
    }

    private void initialize(AttributeSet attrs) {
        setMaxLengthFilter(attrs);
        obtainAttributes(attrs);
        setSoftInputKeyboard();
    }

    private void setMaxLengthFilter(AttributeSet attrs) {
        int maxLength = MAX_LENGTH;
        if (attrs != null) {
            int[] maxLengthAttrs = {android.R.attr.maxLength};
            TypedArray typedArrays = getContext()
                .obtainStyledAttributes(attrs, maxLengthAttrs);
            try {
                maxLength = typedArrays.getInteger(0, MAX_LENGTH);
            } finally {
                typedArrays.recycle();
            }
        }

        // limit maximum length for input number
        InputFilter[] inputFilterArray = new InputFilter[1];
        inputFilterArray[0] = new InputFilter.LengthFilter(maxLength);
        setFilters(inputFilterArray);
    }

    private void obtainAttributes(AttributeSet attrs) {
        if (attrs != null) {
            TypedArray typedArrays = getContext()
                .obtainStyledAttributes(attrs, R.styleable.AutoFormatEditText);

            try {
                isDecimal = typedArrays.getBoolean(R.styleable.AutoFormatEditText_isDecimal, false);
                useComma = typedArrays.getBoolean(R.styleable.AutoFormatEditText_isDecimal, false);
            } finally {
                typedArrays.recycle();
            }
        }
    }

    private String getDecimalSeparator() {
        return useComma ? "," : ".";
    }

    private void setSoftInputKeyboard() {
        setKeyListener(new DigitsKeyListener(false, isDecimal));
    }

    public void updateSoftInputKeyboard(boolean isDecimal) {
        this.isDecimal = isDecimal;
        setSoftInputKeyboard();
        invalidate();
        requestLayout();
    }

    @Override
    protected void onTextChanged(CharSequence s, int start, int lengthBefore, int lengthAfter) {
        if (isFormatting) {
            return;
        }

        isFormatting = true;
        String input = s.toString();

        int textLength = s.length();
        if (textLength >= 0 && textLength < 3) {

            // if user press . turn it into 0.
            if (input.startsWith(getDecimalSeparator()) && textLength == 1) {
                String result = "0" + getDecimalSeparator();
                setText(result);
                return;
            }

        }

        if (s.length() > 2) {
        }


        isFormatting = false;
    }
}
