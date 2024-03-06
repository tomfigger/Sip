package com.feige.init.utils;

import com.blankj.utilcode.util.StringUtils;
import com.feige.init.bean.CompanyInfo;
import com.feige.init.bean.MenuTree;
import com.feige.init.bean.UserInfoBean;

import java.util.List;

public class UserManager {

    private static UserManager INSTANCE = null;
    private CompanyInfo companyInfo;
    private UserInfoBean userInfo;
    private List<MenuTree> menuTree;

    private UserManager() {
    }


    public static UserManager getInstance() {
        if (INSTANCE == null) {
            synchronized (UserManager.class) {
                if (INSTANCE == null) {
                    INSTANCE = new UserManager();
                }
            }
        }
        return INSTANCE;
    }

    public boolean isShowChat() {
        CompanyInfo companyInfo = getCompanyInfo();
        if (companyInfo == null)
            return false;
        if (2 == companyInfo.getBusinessType()) return false;
        UserInfoBean userInfo = getUserInfo();
        if (userInfo == null)
            return false;
        return userInfo.isOpenChat();
    }

    public boolean isMakeCall() {
        UserInfoBean userInfo = getUserInfo();
        if (userInfo == null) return false;
        if (!userInfo.isCompanyIsOpenExtension()) return false;
        if (StringUtils.isTrimEmpty(userInfo.getExtensionUserName())) return false;
        CompanyInfo companyInfo = getCompanyInfo();
        if (1 == companyInfo.getBusinessType()) return false;
        return 1 == userInfo.getExtensionStatus();
    }


    public UserInfoBean getUserInfo() {
        if (userInfo == null) {
            userInfo = UserCache.getUserInfo();
        }
        return userInfo;
    }

    public void setUserInfo(UserInfoBean userInfo) {
        if (userInfo == null) return;
        this.userInfo = userInfo;
        UserCache.setUserInfo(userInfo);
    }

    public CompanyInfo getCompanyInfo() {
        if (companyInfo == null) {
            companyInfo = UserCache.getCompanyInfo();
        }
        return companyInfo;
    }

    public void setCompanyInfo(CompanyInfo companyInfo) {
        if (companyInfo == null) return;
        this.companyInfo = companyInfo;
        UserCache.setCompanyInfo(companyInfo);
    }

    public boolean isLogin() {
        return getUserInfo() != null && UserCache.getLoginInfoToken() != null;
    }

    public void clear() {
        this.userInfo = null;
        this.companyInfo = null;
        UserCache.delete();
    }

    public boolean isMenuShow(String key) {
        if (menuTree == null)
            return true;
        String[] split = key.split("/");
        if (split == null || split.length <= 0)
            return false;
        boolean menuTreeCheckShow = menuTreeCheckShow(menuTree, split, 0);
//        System.out.println("UserManager.isMenuShow key = " + key + "  = " + menuTreeCheckShow);
//        System.out.println(menuTreeCheckShow);
        return menuTreeCheckShow;
    }


    private boolean menuTreeCheckShow(List<MenuTree> menuTree, String[] split, int index) {
        if (menuTree == null || menuTree.size() <= 0)
            return false;
        boolean isShow = false;
        String s = split[index];
        for (int i = 0; i < menuTree.size(); i++) {
            MenuTree menuTree1 = menuTree.get(i);
            if (s.equalsIgnoreCase(menuTree1.getModuleKey()) && menuTree1.getIsSelected()) {
                if (index + 1 >= split.length) {
                    return true;
                }
                ++index;
                List<MenuTree.ButtonMenu> buttons = menuTree1.getButtons();
                if (buttons != null) {
                    String buttonKey = split[index];
                    for (MenuTree.ButtonMenu button : buttons) {
                        if (button.getButtonKey().equalsIgnoreCase(buttonKey)) {
                            return button.getIsSelected();
                        }
                    }
                }

                List<MenuTree> modules = menuTree1.getModules();
                isShow = menuTreeCheckShow(modules, split, index);
            }
        }
        return isShow;
    }

    public void setMenuTree(List<MenuTree> menuTree) {
        this.menuTree = menuTree;
    }

    public List<MenuTree> getMenuTree() {
        return menuTree;
    }
}
