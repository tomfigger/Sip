package com.feige.init.bean;

import com.feige.init.R;
import com.google.gson.annotations.SerializedName;

public class StationMessage {


    @SerializedName("id")
    private String id;
    @SerializedName("accountId")
    private Integer accountId;
    @SerializedName("companyId")
    private Integer companyId;
    @SerializedName("content")
    private String content;
    @SerializedName("createTime")
    private String createTime;
    @SerializedName("messageType")
    private Integer messageType;
    @SerializedName("objectId")
    private Integer objectId;
    @SerializedName("title")
    private String title;
    @SerializedName("isRead")
    private Boolean isRead;

    public int getTypeImage() {
        if (messageType == 1) {
            return R.drawable.station_message_guanfang_gonggao;
        } else if (messageType == 2) {
            return R.drawable.station_message_gongsi_gonggao;
        } else if (messageType == 3) {
            return R.drawable.station_message_kehugenjin;
        } else if (messageType == 4) {
            return R.drawable.station_message_gonghai_huishou;
        } else if (messageType == 5) {
            return R.drawable.station_message_genjin_jihua;
        } else if (messageType == 6) {
            return R.drawable.station_message_gongdan_tixing;
        }

        return 0;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public Integer getMessageType() {
        return messageType;
    }

    public void setMessageType(Integer messageType) {
        this.messageType = messageType;
    }

    public Integer getObjectId() {
        return objectId;
    }

    public void setObjectId(Integer objectId) {
        this.objectId = objectId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Boolean getIsRead() {
        return isRead;
    }

    public void setIsRead(Boolean isRead) {
        this.isRead = isRead;
    }
}
