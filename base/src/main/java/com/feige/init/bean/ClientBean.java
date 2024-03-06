package com.feige.init.bean;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;

public class ClientBean implements Serializable {

    @SerializedName("id")
    private Integer id;
    @SerializedName("im")
    private String im;
    @SerializedName("companyId")
    private Integer companyId;
    @SerializedName("customerName")
    private String customerName;
    @SerializedName("contactName")
    private String contactName;

    @SerializedName("contactId")
    private String contactId;
    @SerializedName("gender")
    private String gender;
    @SerializedName("cellphone")
    private String cellphone;
    @SerializedName("wechat")
    private String wechat;
    @SerializedName("qq")
    private String qq;
    @SerializedName("email")
    private String email;
    @SerializedName("province")
    private String province;
    @SerializedName("address")
    private String address;
    @SerializedName("city")
    private String city;
    @SerializedName("area")
    private String area;
    @SerializedName("ip")
    private String ip;
    @SerializedName("tag")
    private String tag;
    @SerializedName("serviceId")
    private Integer serviceId;
    @SerializedName("remark")
    private String remark;
    @SerializedName("source")
    private String source;
    @SerializedName("keyword")
    private String keyword;
    @SerializedName("createTime")
    private String createTime;
    @SerializedName("updateTime")
    private String updateTime;
    @SerializedName("realName")
    private String realName;

    private int cellphoneCalledTimes;
    private int telephoneCalledTimes;

    public int getCellphoneCalledTimes() {
        return cellphoneCalledTimes;
    }

    public void setCellphoneCalledTimes(int cellphoneCalledTimes) {
        this.cellphoneCalledTimes = cellphoneCalledTimes;
    }

    public int getTelephoneCalledTimes() {
        return telephoneCalledTimes;
    }

    public void setTelephoneCalledTimes(int telephoneCalledTimes) {
        this.telephoneCalledTimes = telephoneCalledTimes;
    }

    @SerializedName("extendFileds")
    private ArrayList<CompanyFiled> extendFileds;

    @SerializedName("contacts")
    private ArrayList<ClientConcat> contacts;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIm() {
        return im;
    }

    public void setIm(String im) {
        this.im = im;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }

    public String getWechat() {
        return wechat;
    }

    public void setWechat(String wechat) {
        this.wechat = wechat;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public Integer getServiceId() {
        return serviceId;
    }

    public void setServiceId(Integer serviceId) {
        this.serviceId = serviceId;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public ArrayList<CompanyFiled> getExtendFileds() {
        return extendFileds;
    }

    public void setExtendFileds(ArrayList<CompanyFiled> extendFileds) {
        this.extendFileds = extendFileds;
    }

    public ArrayList<ClientConcat> getContacts() {
        return contacts;
    }

    public void setContacts(ArrayList<ClientConcat> contacts) {
        this.contacts = contacts;
    }


    public String getContactId() {
        return contactId;
    }

    public void setContactId(String contactId) {
        this.contactId = contactId;
    }
}
