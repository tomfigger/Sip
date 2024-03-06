package com.feige.init.bean;

import com.alibaba.fastjson.annotation.JSONField;

public class WorkBenchOpretor {
    @JSONField(name = "id")
    private Integer id;
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
    @JSONField(name = "creatorType")
    private Integer creatorType;
    @JSONField(name = "creatorTypeName")
    private String creatorTypeName;
    @JSONField(name = "ticketId")
    private Integer ticketId;
    @JSONField(name = "ticketNo")
    private String ticketNo;
    @JSONField(name = "ticketOperationType")
    private Integer ticketOperationType;
    @JSONField(name = "ticketOperationTypeName")
    private String ticketOperationTypeName;
    @JSONField(name = "title")
    private String title;
    @JSONField(name = "headImage")
    private String headImage;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Integer getTicketId() {
        return ticketId;
    }

    public void setTicketId(Integer ticketId) {
        this.ticketId = ticketId;
    }

    public String getTicketNo() {
        return ticketNo;
    }

    public void setTicketNo(String ticketNo) {
        this.ticketNo = ticketNo;
    }

    public Integer getTicketOperationType() {
        return ticketOperationType;
    }

    public void setTicketOperationType(Integer ticketOperationType) {
        this.ticketOperationType = ticketOperationType;
    }

    public String getTicketOperationTypeName() {
        return ticketOperationTypeName;
    }

    public void setTicketOperationTypeName(String ticketOperationTypeName) {
        this.ticketOperationTypeName = ticketOperationTypeName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getHeadImage() {
        return headImage;
    }

    public void setHeadImage(String headImage) {
        this.headImage = headImage;
    }
}
