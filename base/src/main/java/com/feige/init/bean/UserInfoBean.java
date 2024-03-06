package com.feige.init.bean;

import android.os.Parcel;
import android.os.Parcelable;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.ArrayList;
import java.util.List;

/**
 * MrLiu253@163.com
 *
 * @time 2/23/22
 * 描述:
 */
public class UserInfoBean implements Parcelable {
    String accountName;//用户账号
    String agentId;
    String appVersion;
    String companyId;//公司编号
    String createTime;
    String departmentId;
    String id;
    String imPassword;//IM密码
    String isCompanyAdmin;
    String isOnline;
    String jobNumber;
    String onlineTime;
    String realName;//真实姓名
    String roleId;
    String status;
    String upperLimit;//接待访客上限
    List<String> websiteIds;
    String qq;
    String introduction;//个人简介
    String wechat;//微信二维码
    String nickName;//昵称
    String headImg;//头像
    private String slogan;
    private int statusType;
    private int extensionStatus;
    private boolean companyIsOpenExtension;
    private String extensionUserName;
    private String extensionPassword;
    private String ip;
    private String tcpPort;
    private String tcpSIPPort;
    private String wsPort;
    private String wssPort;
    private String voiceService;
    private Boolean isDesensitization;
    private String expirationTime;

    public boolean isCompanyIsOpenExtension() {
        return companyIsOpenExtension;
    }

    public void setCompanyIsOpenExtension(boolean companyIsOpenExtension) {
        this.companyIsOpenExtension = companyIsOpenExtension;
    }

    public boolean isOpenChat() {
        return isOpenChat;
    }

    public void setOpenChat(boolean openChat) {
        isOpenChat = openChat;
    }

    private boolean isOpenChat;


    public String getSlogan() {
        return slogan;
    }

    public void setSlogan(String slogan) {
        this.slogan = slogan;
    }

    public String getTelePhone() {
        return telePhone;
    }

    public void setTelePhone(String telePhone) {
        this.telePhone = telePhone;
    }

    String telePhone;

    public UserInfoBean() {
    }

    public String getAccountName() {
        return accountName == null ? "" : accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getAgentId() {
        return agentId == null ? "" : agentId;
    }

    public void setAgentId(String agentId) {
        this.agentId = agentId;
    }

    public String getAppVersion() {
        return appVersion == null ? "" : appVersion;
    }

    public void setAppVersion(String appVersion) {
        this.appVersion = appVersion;
    }

    public String getCompanyId() {
        return companyId == null ? "" : companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    public String getCreateTime() {
        return createTime == null ? "" : createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getDepartmentId() {
        return departmentId == null ? "" : departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public String getId() {
        return id == null ? "" : id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getImPassword() {
        return imPassword == null ? "" : imPassword;
    }

    public void setImPassword(String imPassword) {
        this.imPassword = imPassword;
    }

    public String getIsCompanyAdmin() {
        return isCompanyAdmin == null ? "" : isCompanyAdmin;
    }

    public void setIsCompanyAdmin(String isCompanyAdmin) {
        this.isCompanyAdmin = isCompanyAdmin;
    }

    public String getIsOnline() {
        return isOnline == null ? "" : isOnline;
    }

    public void setIsOnline(String isOnline) {
        this.isOnline = isOnline;
    }

    public String getJobNumber() {
        return jobNumber == null ? "" : jobNumber;
    }

    public void setJobNumber(String jobNumber) {
        this.jobNumber = jobNumber;
    }

    public String getOnlineTime() {
        return onlineTime == null ? "" : onlineTime;
    }

    public void setOnlineTime(String onlineTime) {
        this.onlineTime = onlineTime;
    }

    public String getRealName() {
        return realName == null ? "" : realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getRoleId() {
        return roleId == null ? "" : roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getStatus() {
        return status == null ? "" : status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUpperLimit() {
        return upperLimit == null ? "" : upperLimit;
    }

    public void setUpperLimit(String upperLimit) {
        this.upperLimit = upperLimit;
    }

    public List<String> getWebsiteIds() {
        if (websiteIds == null) {
            return new ArrayList<>();
        }
        return websiteIds;
    }

    public void setWebsiteIds(List<String> websiteIds) {
        this.websiteIds = websiteIds;
    }

    public String getQq() {
        return qq == null ? "" : qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getIntroduction() {
        return introduction == null ? "" : introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getWechat() {
        return wechat == null ? "" : wechat;
    }

    public void setWechat(String wechat) {
        this.wechat = wechat;
    }

    public String getNickName() {
        return nickName == null ? "" : nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getHeadImg() {
        return headImg == null ? "" : headImg;
    }

    public void setHeadImg(String headImg) {
        this.headImg = headImg;
    }


    public int getExtensionStatus() {
        return extensionStatus;
    }

    public void setExtensionStatus(int extensionStatus) {
        this.extensionStatus = extensionStatus;
    }


    public String getExtensionUserName() {
        return extensionUserName;
    }

    public void setExtensionUserName(String extensionUserName) {
        this.extensionUserName = extensionUserName;
    }

    public String getExtensionPassword() {
        return extensionPassword;
    }

    public void setExtensionPassword(String extensionPassword) {
        this.extensionPassword = extensionPassword;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public int getStatusType() {
        return statusType;
    }

    public void setStatusType(int statusType) {
        this.statusType = statusType;
    }

    public String getTcpPort() {
        return tcpPort;
    }

    public void setTcpPort(String tcpPort) {
        this.tcpPort = tcpPort;
    }

    public String getTcpSIPPort() {
        return tcpSIPPort;
    }

    public void setTcpSIPPort(String tcpSIPPort) {
        this.tcpSIPPort = tcpSIPPort;
    }

    public String getWsPort() {
        return wsPort;
    }

    public void setWsPort(String wsPort) {
        this.wsPort = wsPort;
    }

    public String getWssPort() {
        return wssPort;
    }

    public void setWssPort(String wssPort) {
        this.wssPort = wssPort;
    }

    public Boolean getDesensitization() {
        return isDesensitization;
    }

    public void setDesensitization(Boolean desensitization) {
        isDesensitization = desensitization;
    }

    public String getVoiceService() {
        return voiceService;
    }

    public void setVoiceService(String voiceService) {
        this.voiceService = voiceService;
    }

    public Boolean getIsDesensitization() {
        return isDesensitization;
    }

    public void setIsDesensitization(Boolean isDesensitization) {
        this.isDesensitization = isDesensitization;
    }

    public String getExpirationTime() {
        return expirationTime;
    }

    public void setExpirationTime(String expirationTime) {
        this.expirationTime = expirationTime;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.accountName);
        dest.writeString(this.agentId);
        dest.writeString(this.appVersion);
        dest.writeString(this.companyId);
        dest.writeString(this.createTime);
        dest.writeString(this.departmentId);
        dest.writeString(this.id);
        dest.writeString(this.imPassword);
        dest.writeString(this.isCompanyAdmin);
        dest.writeString(this.isOnline);
        dest.writeString(this.jobNumber);
        dest.writeString(this.onlineTime);
        dest.writeString(this.realName);
        dest.writeString(this.roleId);
        dest.writeString(this.status);
        dest.writeString(this.upperLimit);
        dest.writeStringList(this.websiteIds);
        dest.writeString(this.qq);
        dest.writeString(this.introduction);
        dest.writeString(this.wechat);
        dest.writeString(this.nickName);
        dest.writeString(this.headImg);
        dest.writeString(this.slogan);
        dest.writeInt(this.statusType);
        dest.writeInt(this.extensionStatus);
        dest.writeByte(this.companyIsOpenExtension ? (byte) 1 : (byte) 0);
        dest.writeString(this.extensionUserName);
        dest.writeString(this.extensionPassword);
        dest.writeString(this.ip);
        dest.writeString(this.tcpPort);
        dest.writeString(this.tcpSIPPort);
        dest.writeString(this.wsPort);
        dest.writeString(this.wssPort);
        dest.writeString(this.voiceService);
        dest.writeValue(this.isDesensitization);
        dest.writeString(this.expirationTime);
        dest.writeByte(this.isOpenChat ? (byte) 1 : (byte) 0);
        dest.writeString(this.telePhone);
    }

    public void readFromParcel(Parcel source) {
        this.accountName = source.readString();
        this.agentId = source.readString();
        this.appVersion = source.readString();
        this.companyId = source.readString();
        this.createTime = source.readString();
        this.departmentId = source.readString();
        this.id = source.readString();
        this.imPassword = source.readString();
        this.isCompanyAdmin = source.readString();
        this.isOnline = source.readString();
        this.jobNumber = source.readString();
        this.onlineTime = source.readString();
        this.realName = source.readString();
        this.roleId = source.readString();
        this.status = source.readString();
        this.upperLimit = source.readString();
        this.websiteIds = source.createStringArrayList();
        this.qq = source.readString();
        this.introduction = source.readString();
        this.wechat = source.readString();
        this.nickName = source.readString();
        this.headImg = source.readString();
        this.slogan = source.readString();
        this.statusType = source.readInt();
        this.extensionStatus = source.readInt();
        this.companyIsOpenExtension = source.readByte() != 0;
        this.extensionUserName = source.readString();
        this.extensionPassword = source.readString();
        this.ip = source.readString();
        this.tcpPort = source.readString();
        this.tcpSIPPort = source.readString();
        this.wsPort = source.readString();
        this.wssPort = source.readString();
        this.voiceService = source.readString();
        this.isDesensitization = (Boolean) source.readValue(Boolean.class.getClassLoader());
        this.expirationTime = source.readString();
        this.isOpenChat = source.readByte() != 0;
        this.telePhone = source.readString();
    }

    protected UserInfoBean(Parcel in) {
        this.accountName = in.readString();
        this.agentId = in.readString();
        this.appVersion = in.readString();
        this.companyId = in.readString();
        this.createTime = in.readString();
        this.departmentId = in.readString();
        this.id = in.readString();
        this.imPassword = in.readString();
        this.isCompanyAdmin = in.readString();
        this.isOnline = in.readString();
        this.jobNumber = in.readString();
        this.onlineTime = in.readString();
        this.realName = in.readString();
        this.roleId = in.readString();
        this.status = in.readString();
        this.upperLimit = in.readString();
        this.websiteIds = in.createStringArrayList();
        this.qq = in.readString();
        this.introduction = in.readString();
        this.wechat = in.readString();
        this.nickName = in.readString();
        this.headImg = in.readString();
        this.slogan = in.readString();
        this.statusType = in.readInt();
        this.extensionStatus = in.readInt();
        this.companyIsOpenExtension = in.readByte() != 0;
        this.extensionUserName = in.readString();
        this.extensionPassword = in.readString();
        this.ip = in.readString();
        this.tcpPort = in.readString();
        this.tcpSIPPort = in.readString();
        this.wsPort = in.readString();
        this.wssPort = in.readString();
        this.voiceService = in.readString();
        this.isDesensitization = (Boolean) in.readValue(Boolean.class.getClassLoader());
        this.expirationTime = in.readString();
        this.isOpenChat = in.readByte() != 0;
        this.telePhone = in.readString();
    }

    public static final Creator<UserInfoBean> CREATOR = new Creator<UserInfoBean>() {
        @Override
        public UserInfoBean createFromParcel(Parcel source) {
            return new UserInfoBean(source);
        }

        @Override
        public UserInfoBean[] newArray(int size) {
            return new UserInfoBean[size];
        }
    };
}
