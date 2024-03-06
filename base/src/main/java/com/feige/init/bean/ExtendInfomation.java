package com.feige.init.bean;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ExtendInfomation {

    @JSONField(name = "DefaultValue")
    private String defaultValue;
    @JSONField(name = "FieldName")
    private String fieldName;
    @JSONField(name = "FieldOption")
    private String fieldOption;
    @JSONField(name = "FieldType")
    private Integer fieldType;
    @JSONField(name = "IsRequired")
    private Boolean isRequired;
    @JSONField(name = "Value")
    private String value;
    @JSONField(name = "id")
    private Integer id;
    @JSONField(name = "companyId")
    private Integer companyId;
    @JSONField(name = "createTime")
    private String createTime;
    @JSONField(name = "sort")
    private Integer sort;
    @JSONField(name = "templateId")
    private Integer templateId;
    @JSONField(name = "updateTime")
    private String updateTime;


    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }


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

    public String getDefaultValue() {
        return defaultValue;
    }

//    public String getDisplayValue() {
//        return StringUtils.isTrimEmpty(value) ? defaultValue : value;
//    }

    public void setDefaultValue(String defaultValue) {
        this.defaultValue = defaultValue;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getFieldOption() {
        return fieldOption;
    }

    public List<String> getFieldOptionList() {
        String[] split = fieldOption.split(",");
        return new ArrayList(Arrays.asList(split));
    }

    public void setFieldOption(String fieldOption) {
        this.fieldOption = fieldOption;
    }

    public Integer getFieldType() {
        return fieldType;
    }

    public void setFieldType(Integer fieldType) {
        this.fieldType = fieldType;
    }

    public Boolean getIsRequired() {
        return isRequired;
    }

    public void setIsRequired(Boolean isRequired) {
        this.isRequired = isRequired;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Integer getTemplateId() {
        return templateId;
    }

    public void setTemplateId(Integer templateId) {
        this.templateId = templateId;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }
}
