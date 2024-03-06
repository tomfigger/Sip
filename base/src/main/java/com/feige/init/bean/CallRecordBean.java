package com.feige.init.bean;

import com.alibaba.fastjson.annotation.JSONField;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class CallRecordBean implements Serializable {

    @SerializedName("id")
    private Integer id;
    @SerializedName("accountName")
    private String accountName;
    @SerializedName("customerName")
    private String customerName;
    @SerializedName("calledNumber")
    private String calledNumber;
    @SerializedName("callStatus")
    private Integer callStatus;
    @SerializedName("callStatusName")
    private String callStatusName;
    @SerializedName("callDuration")
    private String callDuration;
    @SerializedName("beginTime")
    private Object beginTime;
    @SerializedName("endTime")
    private Object endTime;
    @SerializedName("recoredUrl")
    private String recoredUrl;
    @SerializedName("billingNumber")
    private Integer billingNumber;
    @SerializedName("agentName")
    private String agentName;
    @SerializedName("realName")
    private String realName;
    @SerializedName("nickName")
    private String nickName;
    @SerializedName("remark")
    private String remark;
    @SerializedName("createTime")
    private String createTime;
    @SerializedName("accountId")
    private Integer accountId;
    @SerializedName("headImg")
    private String headImg;
    @JSONField(name = "isBatchCall")
    private Boolean isBatchCall;
    @JSONField(name = "callType")
    private Integer callType;
    @JSONField(name = "callerNumber")
    private String callerNumber;
    @JSONField(name = "customerId")
    private Integer customerId;
    @JSONField(name = "endTime")
    private String endTimeX;
    @JSONField(name = "beginTime")
    private String beginTimeX;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCalledNumber() {
        return calledNumber;
    }

    public void setCalledNumber(String calledNumber) {
        this.calledNumber = calledNumber;
    }

    public Integer getCallStatus() {
        return callStatus;
    }

    public void setCallStatus(Integer callStatus) {
        this.callStatus = callStatus;
    }

    public String getCallStatusName() {
        return callStatusName;
    }

    public void setCallStatusName(String callStatusName) {
        this.callStatusName = callStatusName;
    }

    public String getCallDuration() {
        return callDuration;
    }

    public void setCallDuration(String callDuration) {
        this.callDuration = callDuration;
    }

    public Object getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Object beginTime) {
        this.beginTime = beginTime;
    }

    public Object getEndTime() {
        return endTime;
    }

    public void setEndTime(Object endTime) {
        this.endTime = endTime;
    }

    public String getRecoredUrl() {
        return recoredUrl;
    }

    public void setRecoredUrl(String recoredUrl) {
        this.recoredUrl = recoredUrl;
    }

    public Integer getBillingNumber() {
        return billingNumber;
    }

    public void setBillingNumber(Integer billingNumber) {
        this.billingNumber = billingNumber;
    }

    public String getAgentName() {
        return agentName;
    }

    public void setAgentName(String agentName) {
        this.agentName = agentName;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    public String getHeadImg() {
        return headImg;
    }

    public void setHeadImg(String headImg) {
        this.headImg = headImg;
    }

    public Boolean getIsBatchCall() {
        return isBatchCall;
    }

    public void setIsBatchCall(Boolean isBatchCall) {
        this.isBatchCall = isBatchCall;
    }

    public Integer getCallType() {
        return callType;
    }

    public void setCallType(Integer callType) {
        this.callType = callType;
    }

    public String getCallerNumber() {
        return callerNumber;
    }

    public void setCallerNumber(String callerNumber) {
        this.callerNumber = callerNumber;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getEndTimeX() {
        return endTimeX;
    }

    public void setEndTimeX(String endTimeX) {
        this.endTimeX = endTimeX;
    }

    public String getBeginTimeX() {
        return beginTimeX;
    }

    public void setBeginTimeX(String beginTimeX) {
        this.beginTimeX = beginTimeX;
    }
}
