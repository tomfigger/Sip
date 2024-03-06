package com.feige.init.bean.message;

import com.feige.init.bean.GuestInfo;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;

import java.io.Serializable;

/**
 * MrLiu253@163.com
 *
 * @time 2/17/22
 * 描述:
 */
@Entity
public class Conversion implements Serializable {
    public static final String TIME_TYPE_TALKING = "1";
    public static final String TIME_TYPE_LEAVE = "3";
    private static final long serialVersionUID = 1L;
    private String timeType; //正在会话，排队中，已离开
    private String chatType; //群聊，单聊
    private String contentType; //图片，文字，语音，位置
    @Id
    private String jid;
    private String name;
    private String user;
    private String time;
    private String source;//来源
    private String address;//地址
    private int newMsg;
    private transient GuestInfo guestInfo;
    private transient MessageTable messageTable;
    private String createTime;
    private int timeOut = 0;

    public int getWebsiteId() {
        return websiteId;
    }

    public void setWebsiteId(int websiteId) {
        this.websiteId = websiteId;
    }

    private int websiteId;

    @Generated(hash = 1327668535)
    public Conversion(String timeType, String chatType, String contentType, String jid,
            String name, String user, String time, String source, String address, int newMsg,
            String createTime, int timeOut, int websiteId) {
        this.timeType = timeType;
        this.chatType = chatType;
        this.contentType = contentType;
        this.jid = jid;
        this.name = name;
        this.user = user;
        this.time = time;
        this.source = source;
        this.address = address;
        this.newMsg = newMsg;
        this.createTime = createTime;
        this.timeOut = timeOut;
        this.websiteId = websiteId;
    }

    @Generated(hash = 1178121860)
    public Conversion() {
    }

    public String getTimeType() {
        return timeType == null ? "" : timeType;
    }

    public void setTimeType(String timeType) {
        this.timeType = timeType;
    }

    public String getJid() {
        return jid == null ? "" : jid;
    }

    public void setJid(String jid) {
        this.jid = jid;
    }

    public String getName() {
        return name == null ? "" : name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUser() {
        return user == null ? "" : user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getTime() {
        return time == null ? "0" : time;
    }

    public void setTime(String time) {
        this.time = time;
    }


    public String getSource() {
        return source == null ? "" : source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getAddress() {
        return address == null ? "" : address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getNewMsg() {
        return newMsg;
    }

    public void setNewMsg(int newMsg) {
        this.newMsg = newMsg;
    }

    public GuestInfo getGuestInfo() {
        return guestInfo;
    }

    public void setGuestInfo(GuestInfo guestInfo) {
        this.guestInfo = guestInfo;
    }

    public MessageTable getMessageTable() {
        return messageTable;
    }

    public void setMessageTable(MessageTable messageTable) {
        this.messageTable = messageTable;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public String getChatType() {
        return chatType;
    }

    public void setChatType(String chatType) {
        this.chatType = chatType;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getCreateTime() {
        return createTime;
    }

    public int getTimeOut() {
        return timeOut;
    }

    public void setTimeOut(int timeOut) {
        this.timeOut = timeOut;
    }
}
