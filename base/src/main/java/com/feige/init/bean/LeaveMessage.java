package com.feige.init.bean;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class LeaveMessage implements Serializable {

    @SerializedName("id")
    private Integer id;
    @SerializedName("accountId")
    private Integer accountId;
    @SerializedName("companyId")
    private Integer companyId;
    @SerializedName("websiteId")
    private Integer websiteId;
    @SerializedName("websiteName")
    private String websiteName;
    @SerializedName("contactName")
    private String contactName;
    @SerializedName("contactWay")
    private String contactWay;
    @SerializedName("content")
    private String content;
    @SerializedName("status")
    private Integer status;
    @SerializedName("guestIM")
    private String guestIM;
    @SerializedName("province")
    private String province;
    @SerializedName("city")
    private String city;
    @SerializedName("devinceType")
    private String devinceType;
    @SerializedName("roomId")
    private String roomId;
    @SerializedName("searchFrom")
    private String searchFrom;
    @SerializedName("createTime")
    private String createTime;
    @SerializedName("visitTimes")
    private String visitTimes;

    public int getSourceType() {
        return sourceType;
    }

    public void setSourceType(int sourceType) {
        this.sourceType = sourceType;
    }

    private int sourceType;

    public String statusStr() {
        return 1 == status ? "未处理" : "已处理";
    }

    public String visitTimesStr() {
        return "[访问次数： " + ("0".equalsIgnoreCase(visitTimes) ? "1" : visitTimes) + "]";
    }

    public String searchFromStr() {
        return "unknow".equalsIgnoreCase(searchFrom) ? "未知" : searchFrom;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getContactWay() {
        return contactWay;
    }

    public void setContactWay(String contactWay) {
        this.contactWay = contactWay;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getGuestIM() {
        return guestIM;
    }

    public void setGuestIM(String guestIM) {
        this.guestIM = guestIM;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDevinceType() {
        return devinceType;
    }

    public void setDevinceType(String devinceType) {
        this.devinceType = devinceType;
    }

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    public String getSearchFrom() {
        return searchFrom;
    }

    public void setSearchFrom(String searchFrom) {
        this.searchFrom = searchFrom;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getVisitTimes() {
        return visitTimes;
    }

    public void setVisitTimes(String visitTimes) {
        this.visitTimes = visitTimes;
    }
}
