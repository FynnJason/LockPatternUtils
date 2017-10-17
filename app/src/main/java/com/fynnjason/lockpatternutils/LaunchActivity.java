package com.fynnjason.lockpatternutils;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.fynnjason.library.utils.PreferencesUtils;

public class LaunchActivity extends AppCompatActivity {
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch);
        String password = PreferencesUtils.getGesturePassword(this);

        if (password.equals("")) {
            intent = new Intent(LaunchActivity.this, SetLockActivity.class);
        } else {
            intent = new Intent(LaunchActivity.this, UnLockActivity.class);
        }
        startActivity(intent);
        finish();
    }
}
