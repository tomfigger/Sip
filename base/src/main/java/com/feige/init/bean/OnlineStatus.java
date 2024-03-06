package com.feige.init.bean;

import java.io.Serializable;

public class OnlineStatus implements Serializable {
    public OnlineStatus(int type, int mode) {
        this.type = type;
        this.mode = mode;
    }

    public int type;
    public int mode;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getMode() {
        return mode;
    }

    public void setMode(int mode) {
        this.mode = mode;
    }
}
