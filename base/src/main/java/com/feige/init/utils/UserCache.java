package com.feige.init.utils;

import com.feige.init.base.BaseMMKV;
import com.feige.init.bean.CompanyInfo;
import com.feige.init.bean.UserInfoBean;

import cn.feige.apilibrary.base.LoginInfoCache;
import cn.feige.apilibrary.base.bean.LoginInfo;

/**
 * MrLiu253@163.com
 *
 * @time 1/17/22
 * 描述:
 */
public class UserCache {
    public static String getToken() {
        return null;
    }

    public static void setAgentState(String state) {
        BaseMMKV.INSTANCE.encode("FG_AGENT_STATUS", state);
    }

    public static String getAgentState() {
        return BaseMMKV.INSTANCE.decodeString("FG_AGENT_STATUS");
    }

    public static boolean getIsAgreeProtocol() {
        return BaseMMKV.INSTANCE.decodeBoolean("FG_ISAGREEPROTOCOL");
    }

    public static void setIsAgreeProtocol(boolean b) {
        BaseMMKV.INSTANCE.encode("FG_ISAGREEPROTOCOL", b);
    }

    public static LoginInfo getLoginInfoToken() {
        return LoginInfoCache.getLoginInfoToken();
    }

    public static void setLoginToekn(LoginInfo loginBean) {
        LoginInfoCache.setLoginToekn(loginBean);
    }

    public static UserInfoBean getUserInfo() {
        return BaseMMKV.INSTANCE.decodeParcelable("FG_SERVICE_INFO", UserInfoBean.class);
    }

    public static void setUserInfo(UserInfoBean userInfo) {
        BaseMMKV.INSTANCE.encode("FG_SERVICE_INFO", userInfo);
    }

    public static CompanyInfo getCompanyInfo() {
        return BaseMMKV.INSTANCE.decodeParcelable("FG_SERVICE_COMPANY", CompanyInfo.class);
    }

    public static void setCompanyInfo(CompanyInfo userInfo) {
        BaseMMKV.INSTANCE.encode("FG_SERVICE_COMPANY", userInfo);
    }

    public static String getUserstate() {
        return BaseMMKV.INSTANCE.decodeString("FG_USER_STATE");
    }

    public static void setUserstate(String type) {
        BaseMMKV.INSTANCE.encode("FG_USER_STATE", type);
    }

    public static String getUserPhone() {
        return BaseMMKV.INSTANCE.decodeString("FG_SERVICE_INFO_PHONE");
    }

    public static void setPhone(String phonr) {
        BaseMMKV.INSTANCE.encode("FG_SERVICE_INFO_PHONE", phonr);
    }

    public static void setNotUpdateVersion(String versionNumber) {
        BaseMMKV.INSTANCE.encode("NOT_UPDATE_VERSION", versionNumber);
    }

    public static String getNotUpdateVersion() {
        return BaseMMKV.INSTANCE.decodeString("NOT_UPDATE_VERSION");
    }

    public static void delete() {
        BaseMMKV.INSTANCE.removeKey("FG_SERVICE_INFO");
        BaseMMKV.INSTANCE.removeKey("FG_LOGIN_INFO");
        BaseMMKV.INSTANCE.removeKey("FG_USER_STATE");
        BaseMMKV.INSTANCE.removeKey("FG_AGENT_STATUS");
        BaseMMKV.INSTANCE.removeKey("FG_LOGIN_INFO_TOKEN");
        BaseMMKV.INSTANCE.removeKey("FG_SERVICE_COMPANY");
        BaseMMKV.INSTANCE.removeKey("FG_JPUSH_REGISTRATIONID");
        BaseMMKV.INSTANCE.removeKey("FG_USER_DND_STATE");
        BaseMMKV.INSTANCE.removeKey("FG_SERVICE_PUSH_CHEKCKED");
    }

    public static void setJpushRegistrationId(String registrationId) {
        BaseMMKV.INSTANCE.encode("FG_JPUSH_REGISTRATIONID", registrationId);
    }

    public static String getPushRegistrationId() {
        return BaseMMKV.INSTANCE.decodeString("FG_JPUSH_REGISTRATIONID");
    }


    public static void setDisablePush(boolean b) {
        BaseMMKV.INSTANCE.encode("FG_SERVICE_PUSH_CHEKCKED", b);
    }

    public static boolean isDisablePush() {
        Boolean fg_service_push_chekcked = BaseMMKV.INSTANCE.decodeBoolean("FG_SERVICE_PUSH_CHEKCKED");
        return fg_service_push_chekcked == null ? false : fg_service_push_chekcked;
    }


}
