package com.feige.init.base;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.graphics.Paint;
import android.os.Bundle;
import android.text.TextPaint;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.blankj.utilcode.util.LogUtils;
import com.feige.init.R;
import com.feige.init.dialog.LoadingDialog;

import cn.feige.apilibrary.base.MyResourceSubscriber;
import cn.feige.apilibrary.base.exception.RxException;
import cn.feige.apilibrary.base.exception.TokenValidException;
import com.feige.init.utils.BaseToast;
import com.gyf.immersionbar.ImmersionBar;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.ViewModelProvider;
import io.reactivex.Flowable;
import io.reactivex.subscribers.ResourceSubscriber;

/**
 * MrLiu253@163.com
 *
 * @time
 */
public abstract class BaseActivity<D extends BaseViewModel, T extends ViewDataBinding> extends AppCompatActivity {
    protected T mBinding;
    protected D mViewModel;
    protected RelativeLayout mActionBarRl;
    protected TextView mTitleTv;
    protected TextView mRightTv;
    protected ImageView mLeftIv;
    protected ImageView mRightIv;
    protected LoadingDialog loadingDialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, getLayoutRes());
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);//强制竖屏11

        mBinding.setLifecycleOwner(this);

        mViewModel = bindModel();

        initActionBar();
        initImmersionBar();
        initData();
        initClick();
        initMonitor();
    }

    private void initActionBar() {
        mActionBarRl = findViewById(R.id.rel_action_bar);
        mTitleTv = findViewById(R.id.action_bar_title_tv);
        mLeftIv = findViewById(R.id.action_bar_back);
        mRightTv = findViewById(R.id.action_bar_right_tv);
        mRightIv = findViewById(R.id.action_bar_right_iv);
        if (mViewModel != null && mLeftIv != null) {
            mViewModel.onDelayClick(mLeftIv, o -> {
                if (initLeftClick()) {
                    finish();
                } else {
                    onLeftClick();
                }
            });
        }
        View backLayout = findViewById(R.id.layout_back);

        if (backLayout != null) {
            backLayout.setOnClickListener(view -> {
                finish();
            });
        }
    }

    protected boolean initLeftClick() {
        return true;
    }

    private void onLeftClick() {
    }

    protected abstract D bindModel();

    protected abstract int getLayoutRes();

    protected abstract void initData();

    protected abstract void initClick();

    protected abstract void initMonitor();

    protected void initImmersionBar() {
        ImmersionBar.setTitleBarMarginTop(this, mActionBarRl);
        ImmersionBar.with(this).statusBarDarkFont(true).init();

//        StatusBarUtil.setDarkMode(this);
    }


    protected void setActionBarBg(int colorId) {
        if (mActionBarRl != null) {
            mActionBarRl.setBackgroundResource(colorId);
            mActionBarRl.setVisibility(View.VISIBLE);
        }
    }

    public void addSubscribe(Flowable sendCode) {
        if (sendCode == null) return;
        addSubscribe(sendCode, true);
    }

    public void addSubscribe(Flowable sendCode, boolean showLoading) {
        if (sendCode == null) return;
        addSubscribe(sendCode, showLoading, new MyResourceSubscriber() {

            @Override
            public void onNext(Object o) {

            }

            @Override
            public void onError(Throwable t) {
                t.printStackTrace();
                if (t instanceof TokenValidException) {
                    BaseToast.showShort("令牌失效，请重新登录");
//                    EventBus.getDefault().post(new LogOutEvent());
                }
                if (showLoading) {
                    if (t instanceof RxException) {
                        BaseToast.showShort(t.getMessage());
                    } else {
                        BaseToast.showShort("操作失败");
                    }
                }
            }

            @Override
            public void onComplete() {

            }
        });
    }

    public void addSubscribe(Flowable sendCode, boolean showLoading, ResourceSubscriber subscriber) {
        if (mViewModel == null) {
            LogUtils.e("viewmodel =null");
            return;
        }
        if (showLoading) showLoadingDialog();
        sendCode.doOnTerminate(() -> dismissDialog()).subscribe(subscriber);
        mViewModel.addSubscribe(subscriber);
    }


    protected void setBarLeftIv(int resId) {
        if (mLeftIv != null) {
            mLeftIv.setVisibility(View.VISIBLE);
            mLeftIv.setImageResource(resId);
        }
    }

    protected void setBarTitle(String titleTv) {
        if (mTitleTv != null) {
            mTitleTv.setText(titleTv);
            mTitleTv.setVisibility(View.VISIBLE);
        }
    }

    protected void setBarTitle(String titleTv, int colorId) {
        if (mTitleTv != null) {
            mTitleTv.setText(titleTv);
            mTitleTv.setTextColor(ContextCompat.getColor(this, colorId));
            mTitleTv.setVisibility(View.VISIBLE);
        }
    }

    protected void setRightTv(String rightTv) {
        if (mRightTv != null) {
            mRightTv.setText(rightTv);
            mRightTv.setVisibility(View.VISIBLE);
        }
    }

    protected void setRightTv(String rightTv, int colorId) {
        if (mRightTv != null) {
            mRightTv.setText(rightTv);
            mRightTv.setTextColor(ContextCompat.getColor(this, colorId));
            mRightTv.setVisibility(View.VISIBLE);
        }
    }

    protected void setRightIv(int colorId) {
        if (mRightIv != null) {
            mRightIv.setImageResource(colorId);
            mRightIv.setVisibility(View.VISIBLE);
        }
    }


    protected void setPaint(TextPaint paint) {
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        paint.setStrokeWidth(0.4f);
    }

    public Context getContext() {
        return this;
    }

    public <T extends BaseViewModel> T getViewModel(AppCompatActivity activity, Class<T> cls) {
        return new ViewModelProvider(activity).get(cls);
    }

    public <T extends BaseViewModel> T getViewModel(Class<T> cls) {
        return new ViewModelProvider(this).get(cls);
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
    }

    public void showLoadingDialog(boolean isCancel) {
        if (loadingDialog != null && loadingDialog.isShowing()) {
            return;
        }
        if (loadingDialog == null) {
            loadingDialog = new LoadingDialog(this);
        }
        loadingDialog.setCancelable(isCancel);
        loadingDialog.setCanceledOnTouchOutside(isCancel);
        loadingDialog.show();
    }

    public void showLoadingDialog() {
        showLoadingDialog(false);
    }

//    public void changeFailureDialog(String msg) {
//        if (loadingDialog != null) {
//            loadingDialog.failure(msg);
//        }
//    }
//
//    public void changeSuccessfulDialog(String msg) {
//        if (loadingDialog != null) {
//            loadingDialog.stop(msg);
//        }
//    }

    public void dismissDialog() {
        if (loadingDialog != null && loadingDialog.isShowing()) {
            loadingDialog.dismiss();
            loadingDialog = null;
        }
    }

    @Override
    protected void onDestroy() {
        if (loadingDialog != null) {
            loadingDialog.dismiss();
            loadingDialog = null;
        }
        if (mBinding != null) {
            mBinding.unbind();
            mBinding = null;
        }
        if (mViewModel != null) {
            mViewModel.unSubscribe();
            mViewModel = null;
        }
        super.onDestroy();
    }

}
