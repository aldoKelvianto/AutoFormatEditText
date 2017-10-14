package com.aldoapps.autoformatedittext;

import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.EditText;

/**
 * Created by aldo on 13/10/17.
 */

public class AutoFormatTextWatcher implements TextWatcher {

    private static final int FIRST_INPUT = 1;
    private static final int SECOND_INPUT = 2;
    private static final int DELETE = 0;
    private static final int INSERT = 1;
    private boolean useDecimal;

    private boolean useCommaGroupSeparator = true;

    private EditText editText;
    private String previousText;
    private boolean isEditing;

    private StringBuilder resultBuilder;

    public AutoFormatTextWatcher(EditText editText) {
        this.editText = editText;
        resultBuilder = new StringBuilder();
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        previousText = s.toString();
    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int action) {
        Log.d("asdf", "s: " + start + " b: " + before);

        if (isEditing) return;

        isEditing = true;
        clearResultBuilder();

        String text = s.toString();
        String normalizedText = text.replace(getGroupSeparator(), "");
        if (normalizedText.contains(getDecimalSeparator())) {
            String[] wholeText = normalizedText.split(getDecimalSeparatorRegex());
            if (wholeText.length == 0) return;

            String nonDecimal = wholeText[0];
            if (nonDecimal.isEmpty()) return;

            String formattedNonDecimal = NewAutoFormatUtil.formatWithoutDecimal(nonDecimal);
            resultBuilder.append(formattedNonDecimal).append(getDecimalSeparator());

            if (wholeText.length > 1) {
                resultBuilder.append(wholeText[1]);
            }
        } else {
            resultBuilder.append(NewAutoFormatUtil.formatWithoutDecimal(normalizedText));
        }

        editText.setText(resultBuilder.toString());

        isEditing = false;
    }

    private void clearResultBuilder() {
        resultBuilder.setLength(0);
    }

    private String getDecimalSeparator() {
        return useCommaGroupSeparator ? "." : ",";
    }

    private String getDecimalSeparatorRegex() {
        return useCommaGroupSeparator ? "\\." : "\\,";
    }

    private String getGroupSeparator() {
        return useCommaGroupSeparator ? "," : ".";
    }

    @Override
    public void afterTextChanged(Editable s) {

    }
}
