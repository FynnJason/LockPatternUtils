package com.fynnjason.lockpatternutils;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.fynnjason.library.utils.PreferencesUtils;
import com.fynnjason.library.view.LockPatternView;

public class SetLockActivity extends AppCompatActivity implements LockPatternView.OnLockListener, View.OnClickListener {
    private TextView mTvTitle;
    private Button mBtnClearPassword;
    private LockPatternView mLpView;
    private boolean isFirst = true; //判断是否第一次输入密码，第一次进来为true
    private String mPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_lock);
        initView();
        mLpView.setLockListener(this);
    }

    private void initView() {
        mTvTitle = (TextView) findViewById(R.id.tv_title);
        mBtnClearPassword = (Button) findViewById(R.id.btn_password_clear);
        mLpView = (LockPatternView) findViewById(R.id.lp_view);
        mBtnClearPassword.setOnClickListener(this);
    }

    @Override
    public void getStringPassword(String password) {
        if (isFirst) {
            mPassword = password;
            mTvTitle.setText("再次输入密码");
            mBtnClearPassword.setVisibility(View.VISIBLE);
            isFirst = false;
        } else {
            if (mPassword.equals(password)) {
                setPasswordToPreference(mPassword);
                startActivity(new Intent(SetLockActivity.this, MainActivity.class));
                finish();
            } else {
                Toast.makeText(this, "两次密码不一致，重新输入", Toast.LENGTH_SHORT).show();
                reset();
            }
        }
    }

    @Override
    public boolean isPassword() {
        return false;
    }

    @Override
    public void onClick(View view) {
        reset();
    }

    private void setPasswordToPreference(String password) {
        PreferencesUtils.setGesturePassword(SetLockActivity.this, password);
    }

    private void reset() {
        isFirst = true;
        mTvTitle.setText("设置密码");
        mBtnClearPassword.setVisibility(View.GONE);
    }
}
