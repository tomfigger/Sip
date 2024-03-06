package com.feige.init.bean;

import com.alibaba.fastjson.annotation.JSONField;
import com.blankj.utilcode.util.StringUtils;
import com.feige.init.R;

import java.io.Serializable;
import java.util.List;

public class ClientConcat implements Serializable {

    @JSONField(name = "id")
    private Integer id = 0;


    private int customerId;
    private List<CustomerContactFileds> customerContactFileds;

    public long getTempId() {
        return tempId;
    }

    public void setTempId(long tempId) {
        this.tempId = tempId;
    }

    private long tempId = 0;
    @JSONField(name = "contactName")
    private String contactName = "";
    @JSONField(name = "gender")
    private Integer gender = 0;
    @JSONField(name = "telephone")
    private String telephone = "";
    @JSONField(name = "cellphone")
    private String cellphone = "";
    @JSONField(name = "email")
    private String email = "";
    @JSONField(name = "wechat")
    private String wechat = "";
    @JSONField(name = "qq")
    private String qq = "";
    @JSONField(name = "position")
    private String position = "";
    @JSONField(name = "isDefault")
    private Boolean isDefault = false;

    public void setChecked(boolean checked) {
        isChecked = checked;
    }

    private boolean isChecked;

    public boolean isChecked() {
        return isChecked;
    }

    public boolean isTrimEmpty(String s) {
        return StringUtils.isTrimEmpty(s);
    }

    public boolean isShowWrite(String key) {
        if (StringUtils.isTrimEmpty(key)) {
            return false;
        }
        if (customerContactFileds == null)
            return false;
        for (CustomerContactFileds customerContactFiled : customerContactFileds) {
            if (key.equalsIgnoreCase(customerContactFiled.getFiledNameEN())) {
                return customerContactFiled.getIsWrite();
            }
        }
        return false;
    }

    public String gender2Str(Integer gender) {
        if (1 == gender) {
            return "男";
        } else if (2 == gender) {
            return "女";
        } else return "未知";
    }

    public int updateGenderStr(String s) {
        if (s.equals("男")) {
            return 1;
        } else if (s.equals("女")) {
            return 2;
        } else {
            return 0;
        }
    }

    public int genderDrawable() {
        if (1 == gender) {
            return R.drawable.client_concat_man;
        } else if (2 == gender) {
            return R.drawable.client_concat_woman;
        } else return 0;
    }


    public String getFirstCharName() {
        if (StringUtils.isTrimEmpty(contactName)) {
            return "";
        }
        return contactName.substring(0, 1);
    }

    public String allInfoStr() {
        String s = "";
        s += StringUtils.isTrimEmpty(cellphone) ? "" : "手机" + cellphone + "\t";
        s += StringUtils.isTrimEmpty(email) ? "" : "邮箱" + email + "\t";
        return s;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Boolean getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(Boolean isDefault) {
        this.isDefault = isDefault;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public void setCustomerContactFileds(List<CustomerContactFileds> customerContactFileds) {
        this.customerContactFileds = customerContactFileds;
    }
}
