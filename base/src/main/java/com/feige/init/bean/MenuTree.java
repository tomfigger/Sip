package com.feige.init.bean;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.List;

public class MenuTree {

    @JSONField(name = "parentId")
    private Integer parentId;
    @JSONField(name = "moduleKey")
    private String moduleKey;
    @JSONField(name = "buttons")
    private List<ButtonMenu> buttons;
    @JSONField(name = "id")
    private Integer id;
    @JSONField(name = "updateTime")
    private String updateTime;
    @JSONField(name = "moduleName")
    private String moduleName;
    @JSONField(name = "modules")
    private List<MenuTree> modules;
    @JSONField(name = "businessType")
    private Integer businessType;
    @JSONField(name = "createTime")
    private String createTime;
    @JSONField(name = "isSelected")
    private Boolean isSelected;

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getModuleKey() {
        return moduleKey;
    }

    public void setModuleKey(String moduleKey) {
        this.moduleKey = moduleKey;
    }

    public List<ButtonMenu> getButtons() {
        return buttons;
    }

    public void setButtons(List<ButtonMenu> buttons) {
        this.buttons = buttons;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public List<MenuTree> getModules() {
        return modules;
    }

    public void setModules(List<MenuTree> modules) {
        this.modules = modules;
    }

    public Integer getBusinessType() {
        return businessType;
    }

    public void setBusinessType(Integer businessType) {
        this.businessType = businessType;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public Boolean getIsSelected() {
        return isSelected;
    }

    public void setIsSelected(Boolean isSelected) {
        this.isSelected = isSelected;
    }

    public class ButtonMenu {

        @JSONField(name = "isSelected")
        private Boolean isSelected;
        @JSONField(name = "id")
        private Integer id;
        @JSONField(name = "buttonKey")
        private String buttonKey;
        @JSONField(name = "createTime")
        private String createTime;
        @JSONField(name = "buttonName")
        private String buttonName;
        @JSONField(name = "updateTime")
        private String updateTime;

        public Boolean getIsSelected() {
            return isSelected;
        }

        public void setIsSelected(Boolean isSelected) {
            this.isSelected = isSelected;
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getButtonKey() {
            return buttonKey;
        }

        public void setButtonKey(String buttonKey) {
            this.buttonKey = buttonKey;
        }

        public String getCreateTime() {
            return createTime;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
        }

        public String getButtonName() {
            return buttonName;
        }

        public void setButtonName(String buttonName) {
            this.buttonName = buttonName;
        }

        public String getUpdateTime() {
            return updateTime;
        }

        public void setUpdateTime(String updateTime) {
            this.updateTime = updateTime;
        }
    }
}
