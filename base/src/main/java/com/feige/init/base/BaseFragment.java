package com.feige.init.base;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Paint;
import android.os.Bundle;
import android.text.TextPaint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.blankj.utilcode.util.LogUtils;
import com.feige.init.dialog.LoadingDialog;
import cn.feige.apilibrary.base.exception.RxException;
import cn.feige.apilibrary.base.exception.TokenValidException;
import com.feige.init.utils.BaseToast;
import com.gyf.immersionbar.ImmersionBar;
import com.gyf.immersionbar.components.ImmersionFragment;

import org.greenrobot.eventbus.EventBus;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import io.reactivex.Flowable;
import io.reactivex.subscribers.ResourceSubscriber;


/**
 * MrLiu253@163.com
 */
public abstract class BaseFragment<D extends BaseViewModel, T extends ViewDataBinding> extends ImmersionFragment {

    protected T mBinding;
    protected D mViewModel;
    protected LoadingDialog loadingDialog;
    protected Context mContext;


    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mContext = context;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }


    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

       /* if (mBinding != null && mBinding.getRoot() != null) {
            ViewGroup parent = (ViewGroup) mBinding.getRoot().getParent();
            if (parent != null) {
                parent.removeView(mBinding.getRoot());
            }
        } else {

            mBinding = DataBindingUtil.inflate(inflater, getLayoutId(), container, false);
        }*/

        if (mBinding == null) {
            mBinding = DataBindingUtil.inflate(inflater, getLayoutId(), container, false);
        }
        return mBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mBinding.setLifecycleOwner(this);
        mViewModel = bindModel();
        initDataView(view, savedInstanceState);
        initData();
        initClick();
        initMonitor();
    }


    public void registerEventBus() {
        if (!EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().register(this);
        }
    }

    public void unRegisterEventBus() {
        if (EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().unregister(this);
        }
    }

    protected void initDataView(View view, Bundle savedInstanceState) {

    }

    protected abstract D bindModel();

    protected abstract int getLayoutId();

    protected abstract void initData();

    protected abstract void initClick();

    protected abstract void initMonitor();

    //    @Override
    public void initImmersionBar() {
        ImmersionBar.with(this).keyboardEnable(true).init();
        ImmersionBar.with(this).statusBarDarkFont(true).init();

    }

    //    @Override
    public boolean immersionBarEnabled() {
        return true;
    }

    protected void setPaint(TextPaint paint) {
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        paint.setStrokeWidth(0.4f);
    }

    public void showLoadingDialog() {
        if (loadingDialog != null && loadingDialog.isShowing()) {
            return;
        }
        if (loadingDialog == null && mContext != null) {
            loadingDialog = new LoadingDialog(mContext);
        }

        loadingDialog.setCanceledOnTouchOutside(false);
        loadingDialog.show();
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
        }
    }

    public void addSubscribe(Flowable sendCode) {
        addSubscribe(sendCode, true);
    }

    public void addSubscribe(Flowable sendCode, boolean showLoading) {
        addSubscribe(sendCode, showLoading, new ResourceSubscriber() {

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
        if (sendCode == null) return;
        if (mViewModel == null) {
            LogUtils.e("viewmodel =null");
            return;
        }
        if (showLoading) showLoadingDialog();
        sendCode.doOnTerminate(() -> dismissDialog()).subscribeWith(subscriber);
        mViewModel.addSubscribe(subscriber);
    }

    @Override

    public void onResume() {
        super.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onDestroyView() {
        dismissDialog();
        super.onDestroyView();
    }

    @Override
    public void onDestroy() {
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


    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
    }

    public <T extends BaseViewModel> T getViewModel(Fragment activity, Class<T> cls) {
        return new ViewModelProvider(this).get(cls);
    }

    public <T extends BaseViewModel> T getViewModel(Class<T> cls) {
        return new ViewModelProvider(this).get(cls);
    }

}
