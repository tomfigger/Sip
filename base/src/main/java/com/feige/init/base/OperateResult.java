/*
 * Copyright (c) 2020 WildFireChat. All rights reserved.
 */

package com.feige.init.base;

public class OperateResult<T> {
    T result;
    int code;
    Exception exception;
    String msg;

    public OperateResult(T result) {
        this.result = result;
        this.code = 0;
    }

    public OperateResult(String msg) {
        this.msg = msg;
        this.code = -1;
    }

    public OperateResult(Exception e) {
        new OperateResult(e, "出现错误");
    }

    public OperateResult(Exception e, String msg) {
        this.exception = e;
        code = -1;
        this.msg = msg;
    }


    public static OperateResult error(Exception e) {
        return new OperateResult(e);
    }

    public static OperateResult error(String msg) {
        return new OperateResult(msg);
    }

    public static <T> OperateResult success(T t) {
        return new OperateResult(t);
    }

    public boolean isSuccess() {
        return code == 0;
    }

    public T getResult() {
        return result;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

}
