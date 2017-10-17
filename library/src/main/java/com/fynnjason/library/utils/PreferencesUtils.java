package com.fynnjason.library.utils;

import android.content.Context;
import android.content.SharedPreferences;

public class PreferencesUtils {

    private static SharedPreferences sp;

    /**
     * 获取手势密码
     */
    public static String getGesturePassword(Context context) {
        sp = context.getSharedPreferences("gesturePassword", Context.MODE_PRIVATE);
        return sp.getString("password", "");
    }

    /**
     * 储存手势密码
     */
    public static void setGesturePassword(Context context, String gesturePassword) {
        sp = context.getSharedPreferences("gesturePassword", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString("password", gesturePassword);
        editor.apply();
    }
}
