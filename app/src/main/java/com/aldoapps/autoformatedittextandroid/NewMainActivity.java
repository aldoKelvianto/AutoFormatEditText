package com.aldoapps.autoformatedittextandroid;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.EditText;

import com.aldoapps.autoformatedittext.AutoFormatTextWatcher;
import com.aldoapps.autoformatedittext.NewAutoFormatEditText;

public class NewMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_activity_main);

        NewAutoFormatEditText editText = (NewAutoFormatEditText) findViewById(R.id.et_test_1);

        /*editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                Log.d("asdf", "before" + s.toString() + " s " + start + " c: " + count + " after: " + after);
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Log.d("asdf", "on text change " + s.toString() + " s " + start + " b: " + before + " c: " + count);
            }

            @Override
            public void afterTextChanged(Editable s) {
                Log.d("asdf", "after change " + s.toString());
                Log.d("asdf", "\n");
            }
        });
        */
        AutoFormatTextWatcher watcher = new AutoFormatTextWatcher(editText);
        editText.addTextChangedListener(watcher);
    }
}
