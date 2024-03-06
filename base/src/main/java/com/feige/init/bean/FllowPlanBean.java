package com.feige.init.bean;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class FllowPlanBean implements Serializable {

    @SerializedName("id")
    private Integer id;
    @SerializedName("content")
    private String content;
    @SerializedName("createTime")
    private String createTime;
    @SerializedName("creator")
    private Integer creator;
    @SerializedName("customerId")
    private Integer customerId;
    @SerializedName("customerName")
    private String customerName;
    @SerializedName("customerPhone")
    private String customerPhone;
    @SerializedName("followAccountId")
    private Integer followAccountId;
    @SerializedName("followAccount")
    private String followAccount;
    @SerializedName("followTime")
    private String followTime;
    @SerializedName("followType")
    private Integer followType;
    @SerializedName("nextFollowTime")
    private String nextFollowTime;
    @SerializedName("nickName")
    private String nickName;
    @SerializedName("realName")
    private String realName;
    @SerializedName("accountName")
    private String accountName;
    @SerializedName("customerCompanyName")
    private String customerCompanyName;
    @SerializedName("headImg")
    private String headImg;

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

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public Integer getCreator() {
        return creator;
    }

    public void setCreator(Integer creator) {
        this.creator = creator;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public Integer getFollowAccountId() {
        return followAccountId;
    }

    public void setFollowAccountId(Integer followAccountId) {
        this.followAccountId = followAccountId;
    }

    public String getFollowAccount() {
        return followAccount;
    }

    public void setFollowAccount(String followAccount) {
        this.followAccount = followAccount;
    }

    public String getFollowTime() {
        return followTime;
    }

    public void setFollowTime(String followTime) {
        this.followTime = followTime;
    }

    public Integer getFollowType() {
        return followType;
    }

    public void setFollowType(Integer followType) {
        this.followType = followType;
    }

    public String getNextFollowTime() {
        return nextFollowTime;
    }

    public void setNextFollowTime(String nextFollowTime) {
        this.nextFollowTime = nextFollowTime;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getCustomerCompanyName() {
        return customerCompanyName;
    }

    public void setCustomerCompanyName(String customerCompanyName) {
        this.customerCompanyName = customerCompanyName;
    }

    public String getHeadImg() {
        return headImg;
    }

    public void setHeadImg(String headImg) {
        this.headImg = headImg;
    }
}
