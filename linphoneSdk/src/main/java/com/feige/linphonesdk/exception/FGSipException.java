package com.feige.linphonesdk.exception;

import cn.feige.apilibrary.base.exception.RxException;

public class FGSipException extends RxException {
    public FGSipException(int i, String s) {
        super(s, i);
    }
}
