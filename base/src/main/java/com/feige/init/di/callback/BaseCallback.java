package com.feige.init.di.callback;

import android.text.TextUtils;

import com.feige.init.R;
import com.feige.init.utils.BaseToast;
import com.google.gson.reflect.TypeToken;

import org.greenrobot.eventbus.EventBus;
import org.json.JSONObject;

import java.net.SocketTimeoutException;

import cn.feige.apilibrary.base.BaseDataBean;
import cn.feige.apilibrary.base.LogOutEvent;
import io.reactivex.subscribers.ResourceSubscriber;
import retrofit2.HttpException;
import retrofit2.Response;

import static com.blankj.utilcode.util.StringUtils.getString;


public abstract class BaseCallback<T> extends ResourceSubscriber<Response<BaseDataBean<T>>> {
    private TypeToken<T> dataType;

    public BaseCallback(Class<T> tClass) {
        dataType = TypeToken.get(tClass);
    }

    public BaseCallback(TypeToken<T> typeToken) {
        dataType = typeToken;
    }

    public BaseCallback() {
    }

    @Override
    public void onNext(Response<BaseDataBean<T>> t) {
        if (t.code() == 200) {
            //200 成功
            if (t.body().getCode() == 0 && t.body().isStatus()) {
                onSuccess(t.body().getData(), "1");
            } else {
                onError(t.body().getMessage(), "-1");
            }
        } else {
            try {
                String st = t.errorBody().string();
                JSONObject jsonObject = new JSONObject(st);
                String msg = jsonObject.optString("message");
                String code = jsonObject.optString("code");
                if (!TextUtils.isEmpty(code) && (TextUtils.equals(code, "402") || TextUtils.equals(code, "401"))) {
                    EventBus.getDefault().post(new LogOutEvent());
                    BaseToast.showShort(TextUtils.isEmpty(msg) ? "令牌失效，请重新登录" : msg);
                } else if (!TextUtils.isEmpty(msg)) {
                    onError(msg, code);
                } else {
                    onError(TextUtils.isEmpty(msg) ? getString(R.string.the_program_network_is_getting_worse) : msg, "-22");
                }
            } catch (Exception e) {
                onError(getString(R.string.the_program_network_is_getting_worse), "-2");
            }
        }
    }

    @Override
    public void onError(Throwable paramThrowable) {
        paramThrowable.printStackTrace();
        if ((paramThrowable instanceof ApiException)) {
            onError(paramThrowable.toString(), "-3");
        } else if ((paramThrowable instanceof SocketTimeoutException)) {
            onError(getString(R.string.server_response_timed_out), "-4");
        } else if ((paramThrowable instanceof HttpException)) {
            onError(getString(R.string.data_loading_failed), "-5");
        } else {
            onError(getString(R.string.the_program_network_is_getting_worse), "-6");
        }
    }


    @Override
    public void onComplete() {
    }

    public abstract void onSuccess(T data, String code);

    public void onError(String message, String code) {
        BaseToast.showShort(message);
    }
}
