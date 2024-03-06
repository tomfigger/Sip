package com.feige.init.di;

import com.blankj.utilcode.util.GsonUtils;

import org.reactivestreams.Publisher;

import java.util.Map;

import io.reactivex.Flowable;
import io.reactivex.FlowableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.schedulers.Schedulers;
import okhttp3.MediaType;
import okhttp3.RequestBody;

/**
 * MrLiu253@163.com
 *
 */
public class RxUtils {

    public static FlowableTransformer threadCutover() {
        return new FlowableTransformer() {
            @NonNull
            @Override
            public Publisher apply(@NonNull Flowable upstream) {
                return upstream.subscribeOn(Schedulers.io())
                        //使用observerOn()指定订阅者运行的线程
                        .observeOn(AndroidSchedulers.mainThread());
            }
        };
    }

    public static RequestBody handlerRequestData(Map<String, Object> map) {
        try {
            RequestBody requestBody = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), GsonUtils.toJson(map));
            return requestBody;
        } catch (Exception e) {
            e.printStackTrace();
            return RequestBody.create(MediaType.parse("application/json; charset=utf-8"), "");
        }
    }


}
