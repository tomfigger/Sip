package com.feige.init.base;


import android.view.View;

import com.feige.init.di.ApiService;
import com.hhbb.amt.di.retrofit.RetrofitHelp;
import com.jakewharton.rxbinding2.view.RxView;

import java.util.concurrent.TimeUnit;

import androidx.lifecycle.ViewModel;
import cn.feige.apilibrary.base.BaseDataBean;
import cn.feige.apilibrary.base.Constants;
import cn.feige.apilibrary.base.NetWorkUtils;
import cn.feige.apilibrary.base.okhttp.OkHttpHelper;
import io.reactivex.Flowable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import retrofit2.Response;

/**
 * MrLiu253@163.com
 */
public class BaseViewModel extends ViewModel {
    private CompositeDisposable mCompositeDisposable;


    public void onDelayClick(View view, Consumer<Object> consumer) {
        addSubscribe(RxView.clicks(view).throttleFirst(Constants.DELAY_CLICK, TimeUnit.MILLISECONDS).subscribe(consumer));
    }

    public ApiService getApiService() {
        OkHttpClient okHttpClient = OkHttpHelper.getOkHttpClientBuilder().build();
        return RetrofitHelp.Companion.getInstance(okHttpClient).getService(ApiService.class);
    }

    public RequestBody handlerRequestData(Object map) {
        return RetrofitHelp.Companion.handlerRequestData(map);
    }

    /**
     * @param view
     * @param consumer
     */
    public void onDelayClick(View view, Consumer<Object> consumer, long delay) {
        addSubscribe(RxView.clicks(view).throttleFirst(delay, TimeUnit.MILLISECONDS).subscribe(consumer));
    }

    public void addSubscribe(Disposable paramDisposable) {
        if (this.mCompositeDisposable == null) {
            this.mCompositeDisposable = new CompositeDisposable();
        }
        this.mCompositeDisposable.add(paramDisposable);
    }

    public void unSubscribe() {
        if (this.mCompositeDisposable != null) {
            this.mCompositeDisposable.dispose();
        }
        onDestroy();
    }

    protected boolean remove(Disposable paramDisposable) {
        return (this.mCompositeDisposable != null) && (this.mCompositeDisposable.remove(paramDisposable));
    }

    @Override
    protected void onCleared() {
        super.onCleared();
    }

    public void onDestroy() {

    }


    public <T> Flowable<T> unWrapReponseFlowable(Flowable<Response<BaseDataBean<T>>> responseFlowable) {
        return NetWorkUtils.unWrapReponseFlowable(responseFlowable);
    }

    public <T> Flowable<BaseDataBean<T>> reponseFlowable(Flowable<Response<BaseDataBean<T>>> responseFlowable) {
        return NetWorkUtils.reponseFlowable(responseFlowable);
    }

}
