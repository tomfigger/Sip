package com.feige.init.bean;

import com.google.gson.annotations.SerializedName;

public class TagBean {

    @SerializedName("id")
    private Integer id;
    @SerializedName("tagColor")
    private String tagColor;
    @SerializedName("tagName")
    private String tagName;
    @SerializedName("fontColor")
    private String fontColor;
    @SerializedName("useCount")
    private Integer useCount;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTagColor() {
        return tagColor;
    }

    public void setTagColor(String tagColor) {
        this.tagColor = tagColor;
    }

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    public String getFontColor() {
        return fontColor;
    }

    public void setFontColor(String fontColor) {
        this.fontColor = fontColor;
    }

    public Integer getUseCount() {
        return useCount;
    }

    public void setUseCount(Integer useCount) {
        this.useCount = useCount;
    }
}
