package com.feige.init.bean;

import com.alibaba.fastjson.annotation.JSONField;
import com.blankj.utilcode.util.StringUtils;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.feige.init.R;
import com.feige.init.bean.message.MessageTable;
import com.google.gson.annotations.SerializedName;

import org.jivesoftware.smack.packet.Presence;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class OrganizeBean implements MultiItemEntity, Serializable {
    public static final int PERSION = 1;
    public static final int DEPEN = 2;
    @SerializedName("index")
    private String index;
    @SerializedName("id")
    private String id;
    @SerializedName("companyId")
    private Integer companyId;
    @SerializedName("name")
    private String name;
    @SerializedName("parentId")
    private Integer parentId;
    @SerializedName("sort")
    private Integer sort;
    @SerializedName("accountName")
    private String accountName;
    @SerializedName("realName")
    private String realName;
    @SerializedName("nickName")
    private String nickName;
    @SerializedName("appVersion")
    private String appVersion;
    @SerializedName("headImg")
    private String headImg;
    @SerializedName("children")
    private List<OrganizeBean> children;
    private AgentStatus agentStatus;
    private MessageTable lastMessage;
    @JSONField(name = "id")
    private Integer idX;
    @JSONField(name = "jobNumber")
    private String jobNumber;
    @JSONField(name = "roleId")
    private Integer roleId;
    @JSONField(name = "roleName")
    private String roleName;
    @JSONField(name = "departmentId")
    private Integer departmentId;
    @JSONField(name = "upperLimit")
    private Integer upperLimit;
    @JSONField(name = "isOpenChat")
    private Boolean isOpenChat;
    @JSONField(name = "seatId")
    private Integer seatId;
    @JSONField(name = "extensionUserName")
    private String extensionUserName;
    @JSONField(name = "extensionPassword")
    private String extensionPassword;
    @JSONField(name = "extensionStatus")
    private Boolean extensionStatus;


    @JSONField(name = "companyIsOpenExtension")
    private Boolean companyIsOpenExtension;
    @JSONField(name = "expirationTime")
    private String expirationTime;
    @JSONField(name = "departmentName")
    private String departmentName;
    @JSONField(name = "isRegister")
    private Boolean isRegister;
    @JSONField(name = "idCardNumber")
    private String idCardNumber;
    @JSONField(name = "authStatus")
    private Integer authStatus;
    private int newMsg = 0;

    public int getSessionsNum() {
        return sessionsNum;
    }

    public void setSessionsNum(int sessionsNum) {
        this.sessionsNum = sessionsNum;
    }

    @SerializedName("sessionsNum")
    private int sessionsNum;

    public String chatStatusStr() {
        if (agentStatus == null) return "离线";
        if (PresenceMode.chat.equalsIgnoreCase(agentStatus.getChatShow())) {
            return "空闲";
        } else if (PresenceMode.dnd.equalsIgnoreCase(agentStatus.getChatShow())) {
            return "忙碌";
        } else {
            return "离线";
        }
    }

    public int getStatusBackGroud() {
        if (agentStatus == null) return R.drawable.shape_999999_3;
        if (Presence.Mode.chat.name().equalsIgnoreCase(agentStatus.getChatShow())) {
            return R.drawable.shape_44d7b6_3;
        } else if (Presence.Mode.dnd.name().equalsIgnoreCase(agentStatus.getChatShow())) {
            return R.drawable.shape_fa6400_3;
        } else {
            return R.drawable.shape_999999_3;
        }
    }

    private String parentName;
    private int personCount;

    public int getPersonCount() {
        return personCount;
    }

    public void setPersonCount(int personCount) {
        this.personCount = personCount;
    }

    public List<OrganizeBean> getChildren() {
        return children;
    }

    public void setChildren(List<OrganizeBean> children) {
        this.children = children;
    }

    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getAppVersion() {
        return appVersion;
    }

    public void setAppVersion(String appVersion) {
        this.appVersion = appVersion;
    }

    public String getHeadImg() {
        return headImg;
    }

    public void setHeadImg(String headImg) {
        this.headImg = headImg;
    }

    @Override
    public int getItemType() {
        if (StringUtils.isTrimEmpty(accountName)) {
            return DEPEN;
        } else return PERSION;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrganizeBean that = (OrganizeBean) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }


    public String sessionsNumStr() {
        return "[今日会话数：" + sessionsNum + "]";
    }

    public void setAgentStatus(AgentStatus agentStatus) {
        this.agentStatus = agentStatus;
    }

    public AgentStatus getAgentStatus() {
        return agentStatus;
    }

    public void setLastMessage(MessageTable lastMessage) {
        this.lastMessage = lastMessage;
    }

    public MessageTable getLastMessage() {
        return lastMessage;
    }

    public Integer getIdX() {
        return idX;
    }

    public void setIdX(Integer idX) {
        this.idX = idX;
    }

    public String getJobNumber() {
        return jobNumber;
    }

    public void setJobNumber(String jobNumber) {
        this.jobNumber = jobNumber;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    public Integer getUpperLimit() {
        return upperLimit;
    }

    public void setUpperLimit(Integer upperLimit) {
        this.upperLimit = upperLimit;
    }

    public Boolean getIsOpenChat() {
        return isOpenChat;
    }

    public void setIsOpenChat(Boolean isOpenChat) {
        this.isOpenChat = isOpenChat;
    }

    public Integer getSeatId() {
        return seatId;
    }

    public void setSeatId(Integer seatId) {
        this.seatId = seatId;
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

    public Boolean getExtensionStatus() {
        return extensionStatus;
    }

    public void setExtensionStatus(Boolean extensionStatus) {
        this.extensionStatus = extensionStatus;
    }

    public Boolean getCompanyIsOpenExtension() {
        return companyIsOpenExtension;
    }

    public void setCompanyIsOpenExtension(Boolean companyIsOpenExtension) {
        this.companyIsOpenExtension = companyIsOpenExtension;
    }

    public String getExpirationTime() {
        return expirationTime;
    }

    public void setExpirationTime(String expirationTime) {
        this.expirationTime = expirationTime;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public Boolean getIsRegister() {
        return isRegister;
    }

    public void setIsRegister(Boolean isRegister) {
        this.isRegister = isRegister;
    }

    public String getIdCardNumber() {
        return idCardNumber;
    }

    public void setIdCardNumber(String idCardNumber) {
        this.idCardNumber = idCardNumber;
    }

    public Integer getAuthStatus() {
        return authStatus;
    }

    public void setAuthStatus(Integer authStatus) {
        this.authStatus = authStatus;
    }

    public int getNewMsg() {
        return newMsg;
    }

    public void setNewMsg(int newMsg) {
        this.newMsg = newMsg;
    }

    public int sourceLoginSrc() {
        if (StringUtils.isTrimEmpty(appVersion)) {
            return R.drawable.colleague_source_ie;
        } else if (appVersion.indexOf("Windows") != -1) {
            return R.drawable.colleague_source_windows;
        } else if (appVersion.indexOf("macOS") != -1) {
            return R.drawable.colleague_source_mac;
        } else {
            return R.drawable.colleague_source_ie;
        }
    }
}
