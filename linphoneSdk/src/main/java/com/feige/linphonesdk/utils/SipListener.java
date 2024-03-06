package com.feige.linphonesdk.utils;

public interface SipListener {
    void onCallConnected();

    void loginFail(Throwable throwable);

    void onLogout();

    void onIncomingCall(String realPhone);

    void onOutgoingCall(String number);

    void onCallState(int stateCode,String message);

    void loginSuccess();

    void loginProgress();
}
