package com.feige.init.bean;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;

public class CustomerContactFileds implements Serializable {

    @JSONField(name = "id")
    private Integer id;
    @JSONField(name = "companyId")
    private Integer companyId;
    @JSONField(name = "createTime")
    private String createTime;
    @JSONField(name = "defultVale")
    private String defultVale;
    @JSONField(name = "filedNameCN")
    private String filedNameCN;
    @JSONField(name = "filedNameEN")
    private String filedNameEN;
    @JSONField(name = "filedType")
    private String filedType;
    @JSONField(name = "isChecked")
    private Boolean isChecked;
    @JSONField(name = "isDefault")
    private Boolean isDefault;
    @JSONField(name = "isWrite")
    private Boolean isWrite;
    @JSONField(name = "options")
    private String options;
    @JSONField(name = "option")
    private Object option;
    @JSONField(name = "updateTime")
    private String updateTime;

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

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getDefultVale() {
        return defultVale;
    }

    public void setDefultVale(String defultVale) {
        this.defultVale = defultVale;
    }

    public String getFiledNameCN() {
        return filedNameCN;
    }

    public void setFiledNameCN(String filedNameCN) {
        this.filedNameCN = filedNameCN;
    }

    public String getFiledNameEN() {
        return filedNameEN;
    }

    public void setFiledNameEN(String filedNameEN) {
        this.filedNameEN = filedNameEN;
    }

    public String getFiledType() {
        return filedType;
    }

    public void setFiledType(String filedType) {
        this.filedType = filedType;
    }

    public Boolean getIsChecked() {
        return isChecked;
    }

    public void setIsChecked(Boolean isChecked) {
        this.isChecked = isChecked;
    }

    public Boolean getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(Boolean isDefault) {
        this.isDefault = isDefault;
    }

    public Boolean getIsWrite() {
        return isWrite;
    }

    public void setIsWrite(Boolean isWrite) {
        this.isWrite = isWrite;
    }

    public String getOptions() {
        return options;
    }

    public void setOptions(String options) {
        this.options = options;
    }

    public Object getOption() {
        return option;
    }

    public void setOption(Object option) {
        this.option = option;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }
}
