package com.fynnjason.lockpatternutils;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.fynnjason.library.utils.PreferencesUtils;
import com.fynnjason.library.view.LockPatternView;

public class UnLockActivity extends AppCompatActivity implements LockPatternView.OnLockListener {
    private LockPatternView mLpView;
    private String mPassword;
    private String mLockPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_un_lock);
        mLpView = (LockPatternView) findViewById(R.id.lp_view);
        mLockPassword = PreferencesUtils.getGesturePassword(this);

        mLpView.setLockListener(this);
    }

    @Override
    public void getStringPassword(String password) {
        mPassword = password;
    }

    @Override
    public boolean isPassword() {
        if (mLockPassword.equals(mPassword)) {
            Toast.makeText(UnLockActivity.this, "密码正确", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(UnLockActivity.this, MainActivity.class));
            finish();
        } else {
            Toast.makeText(UnLockActivity.this, "密码不正确", Toast.LENGTH_SHORT).show();
        }
        return false;
    }
}
