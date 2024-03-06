package com.feige.init.bean;

import com.google.gson.annotations.SerializedName;

public class WelcomeBeanItem {

    @SerializedName("id")
    private Integer id;
    @SerializedName("websiteId")
    private Integer websiteId;
    @SerializedName("websiteName")
    private String websiteName;
    @SerializedName("welcomes")
    private String welcomes;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getWebsiteId() {
        return websiteId;
    }

    public void setWebsiteId(Integer websiteId) {
        this.websiteId = websiteId;
    }

    public String getWebsiteName() {
        return websiteName;
    }

    public void setWebsiteName(String websiteName) {
        this.websiteName = websiteName;
    }

    public String getWelcomes() {
        return welcomes;
    }

    public void setWelcomes(String welcomes) {
        this.welcomes = welcomes;
    }

    @Override
    public String toString() {
        return websiteName;
    }
}
