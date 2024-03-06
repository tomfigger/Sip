package com.feige.init.base;

import cn.feige.apilibrary.base.BaseBean;

/**
 *
 */
public class BaseResultBean<T> extends BaseBean {

    private T result;

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }
}
