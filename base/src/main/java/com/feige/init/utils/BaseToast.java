package com.feige.init.utils;

import android.graphics.Color;

/**
 * MrLiu253@163.com
 */
public class BaseToast {

    public static void showShort(String s) {
        if (s == null)
            return;
        com.blankj.utilcode.util.ToastUtils
                .make()
//                .setGravity(Gravity.CENTER, 0, 0)
                .setBgColor(Color.BLACK)
                .setTextColor(Color.WHITE)
                .show(s);
    }


}