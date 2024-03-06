package com.feige.init.bean;

import com.alibaba.fastjson.annotation.JSONField;

public class AppVersionDto {

    @JSONField(name = "id")
    private Integer id;
    @JSONField(name = "createTime")
    private String createTime;
    @JSONField(name = "deviceType")
    private Integer deviceType;
    @JSONField(name = "documentUrl")
    private String documentUrl;
    @JSONField(name = "downloadUrl")
    private String downloadUrl;
    @JSONField(name = "isForcedUpgrade")
    private Boolean isForcedUpgrade;
    @JSONField(name = "releaseNotes")
    private String releaseNotes;
    @JSONField(name = "updateTime")
    private String updateTime;
    @JSONField(name = "versionNumber")
    private String versionNumber;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public Integer getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(Integer deviceType) {
        this.deviceType = deviceType;
    }

    public String getDocumentUrl() {
        return documentUrl;
    }

    public void setDocumentUrl(String documentUrl) {
        this.documentUrl = documentUrl;
    }

    public String getDownloadUrl() {
        return downloadUrl;
    }

    public void setDownloadUrl(String downloadUrl) {
        this.downloadUrl = downloadUrl;
    }

    public Boolean getIsForcedUpgrade() {
        return isForcedUpgrade;
    }

    public void setIsForcedUpgrade(Boolean isForcedUpgrade) {
        this.isForcedUpgrade = isForcedUpgrade;
    }

    public String getReleaseNotes() {
        return releaseNotes;
    }

    public void setReleaseNotes(String releaseNotes) {
        this.releaseNotes = releaseNotes;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public String getVersionNumber() {
        return versionNumber;
    }

    public void setVersionNumber(String versionNumber) {
        this.versionNumber = versionNumber;
    }
}
