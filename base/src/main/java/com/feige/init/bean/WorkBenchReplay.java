package com.feige.init.bean;

import com.alibaba.fastjson.annotation.JSONField;

public class WorkBenchReplay {

    @JSONField(name = "id")
    private Integer id;
    @JSONField(name = "attachment")
    private String attachment;
    @JSONField(name = "companyId")
    private Integer companyId;
    @JSONField(name = "content")
    private String content;
    @JSONField(name = "createTime")
    private String createTime;
    @JSONField(name = "creatorId")
    private Integer creatorId;
    @JSONField(name = "creatorName")
    private String creatorName;
    @JSONField(name = "creatorNickName")
    private String creatorNickName;
    @JSONField(name = "creatorType")
    private Integer creatorType;
    @JSONField(name = "creatorTypeName")
    private String creatorTypeName;
    @JSONField(name = "isSend")
    private Boolean isSend;
    @JSONField(name = "ticketId")
    private String ticketId;
    @JSONField(name = "ticketNo")
    private String ticketNo;
    @JSONField(name = "updateTime")
    private String updateTime;
    @JSONField(name = "headImage")
    private String headImage;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAttachment() {
        return attachment;
    }

    public void setAttachment(String attachment) {
        this.attachment = attachment;
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

    public Integer getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(Integer creatorId) {
        this.creatorId = creatorId;
    }

    public String getCreatorName() {
        return creatorName;
    }

    public void setCreatorName(String creatorName) {
        this.creatorName = creatorName;
    }

    public String getCreatorNickName() {
        return creatorNickName;
    }

    public void setCreatorNickName(String creatorNickName) {
        this.creatorNickName = creatorNickName;
    }

    public Integer getCreatorType() {
        return creatorType;
    }

    public void setCreatorType(Integer creatorType) {
        this.creatorType = creatorType;
    }

    public String getCreatorTypeName() {
        return creatorTypeName;
    }

    public void setCreatorTypeName(String creatorTypeName) {
        this.creatorTypeName = creatorTypeName;
    }

    public Boolean getIsSend() {
        return isSend;
    }

    public void setIsSend(Boolean isSend) {
        this.isSend = isSend;
    }

    public String getTicketId() {
        return ticketId;
    }

    public void setTicketId(String ticketId) {
        this.ticketId = ticketId;
    }

    public String getTicketNo() {
        return ticketNo;
    }

    public void setTicketNo(String ticketNo) {
        this.ticketNo = ticketNo;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public String getHeadImage() {
        return headImage;
    }

    public void setHeadImage(String headImage) {
        this.headImage = headImage;
    }
}
