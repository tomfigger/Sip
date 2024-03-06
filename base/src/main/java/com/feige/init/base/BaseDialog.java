package com.feige.init.base;

import android.content.Context;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Window;
import android.view.WindowManager;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;

import com.feige.init.R;


public abstract class BaseDialog extends AlertDialog {
    public Context context;

    public BaseDialog(@NonNull Context context) {
        super(context, R.style.Dialog);
        this.context = context;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        setWidth();
        initView();

    }
    protected void setWidth() {
        Window o = getWindow();
        WindowManager.LayoutParams lp = o.getAttributes();
        WindowManager wm = (WindowManager) context
                .getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics outMetrics = new DisplayMetrics();
        wm.getDefaultDisplay().getMetrics(outMetrics);
        lp.width = outMetrics.widthPixels;
        lp.height = outMetrics.heightPixels;
        o.setAttributes(lp);
    }

    protected abstract void initView();


    protected abstract int getLayoutId();
}
