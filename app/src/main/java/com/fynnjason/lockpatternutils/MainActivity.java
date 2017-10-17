package com.fynnjason.lockpatternutils;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.fynnjason.library.utils.PreferencesUtils;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button mBtnReset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mBtnReset = (Button) findViewById(R.id.btn_reset);
        mBtnReset.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        PreferencesUtils.setGesturePassword(this, "");
        startActivity(new Intent(this, LaunchActivity.class));
        finish();
    }
}
