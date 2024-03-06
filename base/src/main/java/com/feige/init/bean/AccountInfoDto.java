package com.feige.init.bean;


import java.util.List;

public class AccountInfoDto {
    private UserInfoBean userInfo;
    private CompanyInfo companyInfo;
    private List<MenuTree> menuTree;

    public UserInfoBean getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfoBean userInfo) {
        this.userInfo = userInfo;
    }

    public CompanyInfo getCompanyInfo() {
        return companyInfo;
    }

    public void setCompanyInfo(CompanyInfo companyInfo) {
        this.companyInfo = companyInfo;
    }

    public List<MenuTree> getMenuTree() {
        return menuTree;
    }

    public void setMenuTree(List<MenuTree> menuTree) {
        this.menuTree = menuTree;
    }
}
