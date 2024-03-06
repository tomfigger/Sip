package com.feige.init.bean;

import android.text.TextUtils;

import com.feige.init.R;

public class LineUpUser {
    private int position;
    private int time;
    private GuestInfo guestBean;
    private String joinTime;

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public GuestInfo getGuestBean() {
        return guestBean;
    }

    public void setGuestBean(GuestInfo guestBean) {
        this.guestBean = guestBean;
    }

    public String getJoinTime() {
        return joinTime;
    }

    public void setJoinTime(String joinTime) {
        this.joinTime = joinTime;
    }

    public int getHeadImage() {
        if (guestBean == null) {
            return R.drawable.fg_pc;
        }
        if (TextUtils.equals(guestBean.getEquipmentType(), "mobile")) {
            return R.drawable.fg_mobile;
        } else return R.drawable.fg_pc;
    }
}
