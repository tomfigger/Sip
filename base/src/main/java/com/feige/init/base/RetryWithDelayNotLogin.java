package com.feige.init.base;

import android.util.Log;

import cn.feige.apilibrary.base.exception.TokenValidException;
import com.feige.init.utils.UserManager;

import org.reactivestreams.Publisher;

import java.util.concurrent.TimeUnit;

import io.reactivex.Flowable;
import io.reactivex.functions.Function;


public class RetryWithDelayNotLogin implements
        Function<Flowable<Throwable>, Publisher<?>> {

    private final int maxRetries;
    private final int retryDelayMillis;
    private int retryCount;

    public RetryWithDelayNotLogin(final int maxRetries, final int retryDelayMillis) {
        this.maxRetries = maxRetries;
        this.retryDelayMillis = retryDelayMillis;
        this.retryCount = 0;
    }


    @Override
    public Publisher<?> apply(Flowable<Throwable> throwableFlowable) throws Exception {
        return throwableFlowable
                .flatMap(throwable -> {
                    throwable.printStackTrace();
                    boolean isLogin = UserManager.getInstance().isLogin();
                    if (throwable instanceof TokenValidException || !isLogin) {
                        return Flowable.error(throwable);
                    }
                    if (++retryCount <= maxRetries) {
                        // When this Flowable calls onNext, the original
                        // Flowable will be retried (i.e. re-subscribed).
                        Log.d("Retry", "get error, retry again " + retryCount);
                        return Flowable.timer(retryDelayMillis,
                                TimeUnit.MILLISECONDS);
                    }

                    // Max retries hit. Just pass the error along.
                    return Flowable.error(throwable);
                });
    }
}