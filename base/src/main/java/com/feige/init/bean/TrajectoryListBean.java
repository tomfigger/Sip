package com.feige.init.bean;

import com.blankj.utilcode.util.TimeUtils;

public class TrajectoryListBean {

    private Long time;
    private String title;
    private String url;

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTimeStr() {
        return TimeUtils.millis2String(time);
    }
}
