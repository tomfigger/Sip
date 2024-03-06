package com.feige.init.bean.message;

import android.text.TextUtils;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Transient;
import org.jivesoftware.smack.packet.Message;

import java.io.Serializable;

/**
 * MrLiu253@163.com
 *
 * @time 2/24/22
 * 描述:
 */
@Entity
public class MessageTable implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 消息id
     */
    @Id
    private String id;

    /**
     * 属于哪个用户
     */
    private String userId;

    /**
     * 房间号
     */
    private String roomId;

    /**
     * 消息类型
     * 1 通知
     * 2 文本
     * 3 图片
     * 4 文件
     * 5 未知消息 (客户端自己使用的容错类型)
     */
    private int msgType;

    /**
     * 文本内容
     * 文本消息时：文本内容
     * 图片消息时：图片url
     * 文件消息时：文件url
     * 通知消息是：提示内容
     */
    private String content;

    /**
     * 发送时间
     */
    private String time;

    /**
     * 客服昵称
     */
    private String nickname;

    /**
     * 客服头像
     */
    private String headImg;

    /**
     * 客服发送的消息(agent)
     * 访客发送的消息(visitor)
     * 系统消息类型(system)
     */
    private String status;

    /**
     * 发送状态 1发送成功 2发送失败 3发送中,4已读
     */
    private int sendStatus;

    /**
     * 是否是自己发送的
     */
    private boolean isSend;

    private String fileName;
    private String fileSize;
    private String fileType;
    private Integer companyId;
    private Integer websiteId;
    private Integer tempType;
    private Integer tempId;
    private int chatType;

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public Integer getWebsiteId() {
        return websiteId;
    }

    public void setWebsiteId(Integer websiteId) {
        this.websiteId = websiteId;
    }

    public Integer getTempType() {
        return tempType;
    }

    public void setTempType(Integer tempType) {
        this.tempType = tempType;
    }

    public Integer getTempId() {
        return tempId;
    }

    public void setTempId(Integer tempId) {
        this.tempId = tempId;
    }

    @Transient
    private transient Message message;

    @Generated(hash = 1958899551)
    public MessageTable(String id, String userId, String roomId, int msgType,
                        String content, String time, String nickname, String headImg,
                        String status, int sendStatus, boolean isSend, String fileName,
                        String fileSize, String fileType, Integer companyId, Integer websiteId,
                        Integer tempType, Integer tempId, int chatType) {
        this.id = id;
        this.userId = userId;
        this.roomId = roomId;
        this.msgType = msgType;
        this.content = content;
        this.time = time;
        this.nickname = nickname;
        this.headImg = headImg;
        this.status = status;
        this.sendStatus = sendStatus;
        this.isSend = isSend;
        this.fileName = fileName;
        this.fileSize = fileSize;
        this.fileType = fileType;
        this.companyId = companyId;
        this.websiteId = websiteId;
        this.tempType = tempType;
        this.tempId = tempId;
        this.chatType = chatType;
    }

    @Generated(hash = 1805713138)
    public MessageTable() {
    }


    @Override
    public String toString() {
        return "MessageTable{" +
                "id='" + id + '\'' +
                ", userId='" + userId + '\'' +
                ", roomId='" + roomId + '\'' +
                ", msgType=" + msgType +
                ", content='" + content + '\'' +
                ", time='" + time + '\'' +
                ", nickname='" + nickname + '\'' +
                ", headImg='" + headImg + '\'' +
                ", status='" + status + '\'' +
                ", sendStatus=" + sendStatus +
                ", isSend=" + isSend +
                ", fileName='" + fileName + '\'' +
                ", fileSize='" + fileSize + '\'' +
                ", fileType='" + fileType + '\'' +
                ", companyId=" + companyId +
                ", websiteId=" + websiteId +
                ", tempType=" + tempType +
                ", tempId=" + tempId +
                ", message=" + message +
                '}';
    }

    public String getId() {
        return id == null ? "" : id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getMsgType() {
        return msgType;
    }

    public void setMsgType(int msgType) {
        this.msgType = msgType;
    }

    public String getContent() {
        return content == null ? "" : content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTime() {
        if (TextUtils.isEmpty(time)) {
            return "0";
        } else if (time.length() > 13) {
            return time.substring(0, 13);
        } else {
            return time;
        }
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getNickname() {
        return nickname == null ? "" : nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getHeadImg() {
        return headImg == null ? "" : headImg;
    }

    public void setHeadImg(String headImg) {
        this.headImg = headImg;
    }

    public String getStatus() {
        return status == null ? "" : status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getSendStatus() {
        return sendStatus;
    }

    public void setSendStatus(int sendStatus) {
        this.sendStatus = sendStatus;
    }

    public String getRoomId() {
        return roomId == null ? "" : roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    public boolean isSend() {
        return isSend;
    }

    public void setSend(boolean send) {
        isSend = send;
    }

    public boolean getIsSend() {
        return this.isSend;
    }

    public void setIsSend(boolean isSend) {
        this.isSend = isSend;
    }

    public String getUserId() {
        return userId == null ? "" : userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getFileName() {
        return fileName == null ? "" : fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileSize() {
        return fileSize == null ? "" : fileSize;
    }

    public void setFileSize(String fileSize) {
        this.fileSize = fileSize;
    }

    public String getFileType() {
        return fileType == null ? "" : fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }

    public int getChatType() {
        return chatType;
    }

    public void setChatType(int chatType) {
        this.chatType = chatType;
    }
}
