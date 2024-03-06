package com.feige.init.bean;

import java.util.List;

public class MenuButtonInfo {


    private Integer id;
    private String createTime;
    private String icon;
    private Boolean isDefault;
    private String moduleName;
    private Integer parentId;
    private Integer showPosition;
    private Integer sort;
    private String updateTime;
    private String url;
    private Integer businessType;
    private List<MenuButtonInfo> children;
    private Object buttonTreeInfo;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Boolean getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(Boolean isDefault) {
        this.isDefault = isDefault;
    }

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public Integer getShowPosition() {
        return showPosition;
    }

    public void setShowPosition(Integer showPosition) {
        this.showPosition = showPosition;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getBusinessType() {
        return businessType;
    }

    public void setBusinessType(Integer businessType) {
        this.businessType = businessType;
    }

    public List<MenuButtonInfo> getChildren() {
        return children;
    }

    public void setChildren(List<MenuButtonInfo> children) {
        this.children = children;
    }

    public Object getButtonTreeInfo() {
        return buttonTreeInfo;
    }

    public void setButtonTreeInfo(Object buttonTreeInfo) {
        this.buttonTreeInfo = buttonTreeInfo;
    }
}
