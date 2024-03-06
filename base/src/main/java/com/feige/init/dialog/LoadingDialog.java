package com.feige.init.dialog;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Handler;
import android.os.Message;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.feige.init.R;
import com.feige.init.base.BaseDialog;


public class LoadingDialog extends BaseDialog {
    TextView textView;
    ImageView imageView;
    ObjectAnimator objectAnimator;
    String content;
    public LoadingDialog(@NonNull Context context) {
        super(context);
    }

    public void setContent(String content) {
        this.content = content;
    }
    Handler handler = new Handler(){
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            dismiss();
        }
    };

    @SuppressLint("WrongConstant")
    @Override
    protected void initView() {
        textView = findViewById(R.id.content);
        imageView = findViewById(R.id.logo);
        objectAnimator = ObjectAnimator.ofFloat(imageView,"rotation",0f,360f);
        objectAnimator.setDuration(2000);
        objectAnimator.setRepeatCount(ValueAnimator.INFINITE);
        objectAnimator.setRepeatMode(ValueAnimator.INFINITE);//
        LinearInterpolator lir = new LinearInterpolator();
        objectAnimator.setInterpolator(lir);
        textView.setText(content);
        imageView.setBackgroundResource(R.drawable.loading);
        setOnDismissListener(new DialogInterface.OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialogInterface) {
                objectAnimator.cancel();
                if(handler!=null) {
                    handler.removeCallbacksAndMessages(null);
                }
            }
        });
        setOnShowListener(new DialogInterface.OnShowListener() {
            @Override
            public void onShow(DialogInterface dialogInterface) {
                if(objectAnimator!=null){
                    objectAnimator.start();
                }
                if(imageView!=null){
                    imageView.setBackgroundResource(R.drawable.loading);
                    textView.setText(content);
                }
            }
        });
    }
//    public void stop(String s){
//        objectAnimator.cancel();
//        imageView.animate().rotation(0).setDuration(60).start();
//        imageView.setBackgroundResource(R.drawable.withe_successful);
//        textView.setText(s);
//        handler.sendEmptyMessageDelayed(0,1000);
//    }
//    public void failure(String s){
//        objectAnimator.cancel();
//        imageView.animate().rotation(0).setDuration(60).start();
//        imageView.setBackgroundResource(R.drawable.withe_error);
//        textView.setText(s);
//        handler.sendEmptyMessageDelayed(0,1000);
//
//    }
    @Override
    protected int getLayoutId() {
        return R.layout.dialog_loading;
    }
}
