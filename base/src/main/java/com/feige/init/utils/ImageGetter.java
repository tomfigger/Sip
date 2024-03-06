package com.feige.init.utils;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.Html;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;

import com.feige.init.R;

/**
 * MrLiu253@163.com
 *
 * @time 3/2/22
 * 描述:
 */
public class ImageGetter implements Html.ImageGetter{
    private Context context;

    public ImageGetter(@NonNull Context context) {
        this.context = context;
    }
    @Override
    public Drawable getDrawable(String source) {
        return ContextCompat.getDrawable(context, R.drawable.fg_back);
    }
}
