package com.feige.linphonesdk.utils;

public interface SipCallListener {
    void onCallSuccess();

    void onError(Throwable t);
}
