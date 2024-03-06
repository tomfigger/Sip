package com.example.linphonesample.ui;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;

import androidx.annotation.Nullable;

import com.blankj.utilcode.util.PermissionUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.example.linphonesample.R;
import com.example.linphonesample.databinding.ActivityInitBinding;
import com.example.linphonesample.event.CallConnectedEvent;
import com.example.linphonesample.event.CallStateEvent;
import com.feige.init.base.BaseActivity;
import com.feige.init.base.BaseViewModel;
import com.feige.linphonesdk.manager.FeigeSipManager;
import com.feige.linphonesdk.utils.SipListener;

import org.greenrobot.eventbus.EventBus;

public class InitActivity extends BaseActivity<BaseViewModel, ActivityInitBinding> {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    protected BaseViewModel bindModel() {
        return getViewModel(BaseViewModel.class);
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.activity_init;
    }

    @Override
    protected void initData() {
        FeigeSipManager.getInstance().addSipListener(new SipListener() {

            @Override
            public void onCallConnected() {
                EventBus.getDefault().post(new CallConnectedEvent());

            }

            @Override
            public void loginFail(Throwable throwable) {
                mBinding.tvStatus.setText(throwable.getMessage());
            }

            @Override
            public void onLogout() {
                mBinding.tvStatus.setText("退出登录");
            }

            @Override
            public void onIncomingCall(String realPhone) {
                startActivity(new Intent(InitActivity.this, CallActivity.class));
            }

            @Override
            public void onOutgoingCall(String number) {
                startActivity(new Intent(InitActivity.this, CallActivity.class));
            }

            @Override
            public void onCallState(int stateCode, String message) {
                EventBus.getDefault().post(new CallStateEvent(stateCode, message));
            }

            @Override
            public void loginSuccess() {
                mBinding.tvStatus.setText("登录成功");
            }

            @Override
            public void loginProgress() {
                mBinding.tvStatus.setText("正在登录...");
            }
        });
        FeigeSipManager.getInstance().init(this);
    }

    @Override
    protected void initClick() {
        mViewModel.onDelayClick(mBinding.btnLogin, o -> {
            if (TextUtils.isEmpty(mBinding.ediApiKey.getText())) {
                ToastUtils.showShort("请输入ApiKey");
                return;
            }
            if (TextUtils.isEmpty(mBinding.ediApiSecret.getText())) {
                ToastUtils.showShort("请输入ApiSecret");
                return;
            }
            if (TextUtils.isEmpty(mBinding.ediName.getText())) {
                ToastUtils.showShort("请输入用户名");
                return;
            }
            FeigeSipManager.getInstance().login(this, mBinding.ediApiKey.getText().toString(), mBinding.ediApiSecret.getText().toString(), mBinding.ediName.getText().toString());
        });
        mViewModel.onDelayClick(mBinding.btnLoginOut,o->{
            if (!FeigeSipManager.getInstance().isLogin()) {
                ToastUtils.showShort("暂未登录");
                return;
            }
            FeigeSipManager.getInstance().logout();
            mBinding.tvStatus.setText("未登录");
        });
        mViewModel.onDelayClick(mBinding.btnCall, o -> {
            if (TextUtils.isEmpty(mBinding.ediPhone.getText())) {
                ToastUtils.showShort("请输入电话号码");
                return;
            }
            Log.i("ranwei",String.valueOf(FeigeSipManager.getInstance().getLoginState()));
            if (!FeigeSipManager.getInstance().isLogin()) {
                ToastUtils.showShort("请登录");
                return;
            }
            String[] strings = {Manifest.permission.RECORD_AUDIO};
            if (!PermissionUtils.isGranted(strings)) {
                PermissionUtils
                        .permission(strings)
                        .callback(new PermissionUtils.SimpleCallback() {
                            @Override
                            public void onGranted() {
                                FeigeSipManager.getInstance().call("", mBinding.ediPhone.getText().toString(), "", "");
                            }

                            @Override
                            public void onDenied() {
                                ToastUtils.showShort("请授予权限，才能使用电话功能");
                            }
                        }).request();
            } else {
                FeigeSipManager.getInstance().call("", mBinding.ediPhone.getText().toString(), "", "");
            }
        });
    }

    @Override
    protected void initMonitor() {

    }
}
