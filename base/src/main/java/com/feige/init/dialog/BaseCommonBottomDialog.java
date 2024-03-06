package com.feige.init.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Window;
import android.view.WindowManager;

import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

import com.blankj.utilcode.util.ScreenUtils;
import com.feige.init.R;


public abstract class BaseCommonBottomDialog<T extends ViewDataBinding> extends Dialog {
    public T getBinding() {
        return binding;
    }

    protected T binding;

    public BaseCommonBottomDialog(Context context) {
        super(context, R.style.BottomDialog);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.inflate(LayoutInflater.from(getContext()), getLayoutId(), null, false);
        setContentView(binding.getRoot());
        setWidth();
        this.getWindow().setGravity(getGravity());
        this.getWindow().setWindowAnimations(getAnimations());
        initView();
    }

    public void setWidth() {
        Window o = getWindow();
        WindowManager.LayoutParams lp = o.getAttributes();
        // x/y坐标
        // lp.x = 100;
        // lp.y = 100;
        lp.width = ScreenUtils.getScreenWidth();
        o.setAttributes(lp);
    }

    protected int getAnimations() {
        return 0;
    }//R.style.BottomDialog_Animation

    protected int getGravity() {
        return Gravity.BOTTOM;
    }

    protected abstract void initView();


    protected abstract int getLayoutId();


}
