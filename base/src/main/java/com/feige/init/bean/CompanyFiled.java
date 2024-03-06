package com.feige.init.bean;


import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;
import java.util.List;

public class CompanyFiled implements Serializable {

    @JSONField(serialize = false)
    private String filedNameCN;
    private String filedNameEN;
    @JSONField(serialize = false)
    private List<String> option;
    @JSONField(serialize = false)
    private String defultVale;
    @JSONField(serialize = false)
    private Boolean isWrite;
    @JSONField(serialize = false)
    private String filedType;
    @JSONField(serialize = false)
    private Boolean isDefault;
    private String filedValue = "";

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

    public List<String> getOption() {
        return option;
    }

    public void setOption(List<String> option) {
        this.option = option;
    }

    public String getDefultVale() {
        return defultVale;
    }

    public void setDefultVale(String defultVale) {
        this.defultVale = defultVale;
    }

    public Boolean getIsWrite() {
        return isWrite;
    }

    public void setIsWrite(Boolean isWrite) {
        this.isWrite = isWrite;
    }

    public String getFiledType() {
        return filedType;
    }

    public void setFiledType(String filedType) {
        this.filedType = filedType;
    }

    public Boolean getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(Boolean isDefault) {
        this.isDefault = isDefault;
    }

    public String getFiledValue() {
        return filedValue;
    }

    public void setFiledValue(String filedValue) {
        this.filedValue = filedValue;
    }
}
