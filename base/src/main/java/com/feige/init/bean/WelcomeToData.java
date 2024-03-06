package com.feige.init.bean;

/**
 * MrLiu253@163.com
 *
 * @time 1/21/22
 * 描述:
 */
public class WelcomeToData {
    private String websiteId;
    private String welcomes;

    public WelcomeToData(String websiteId, String welcomes) {
        this.websiteId = websiteId;
        this.welcomes = welcomes;
    }

    public String getWebsiteId() {
        return websiteId == null ? "" : websiteId;
    }

    public void setWebsiteId(String websiteId) {
        this.websiteId = websiteId;
    }

    public String getWelcomes() {
        return welcomes == null ? "" : welcomes;
    }

    public void setWelcomes(String welcomes) {
        this.welcomes = welcomes;
    }
}
