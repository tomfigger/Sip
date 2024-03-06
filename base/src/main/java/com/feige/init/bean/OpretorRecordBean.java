package com.feige.init.bean;

import com.google.gson.annotations.SerializedName;

public class OpretorRecordBean {

    @SerializedName("id")
    private Integer id;
    @SerializedName("content")
    private String content;
    @SerializedName("creator")
    private String creator;
    @SerializedName("createTime")
    private String createTime;
    @SerializedName("headImg")
    private String headImg;
    private String title;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getHeadImg() {
        return headImg;
    }

    public void setHeadImg(String headImg) {
        this.headImg = headImg;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
