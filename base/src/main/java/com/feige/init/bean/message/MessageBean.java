package com.feige.init.bean.message;

/**
 * MrLiu253@163.com
 *
 * @time 2/9/22
 * 描述:
 */
public class MessageBean {

    /**
     * 消息类型
     * 1 通知
     * 2 文本
     * 3 图片
     * 4 文件
     * 5 未知消息 (客户端自己使用的容错类型)
     */
    private String msgType;

    /**
     * 文本内容
     * 文本消息时：文本内容
     * 图片消息时：图片url
     * 文件消息时：文件url
     * 通知消息是：提示内容
     */
    private String content;

    /**
     * 客服发送的消息(agent)
     * 访客发送的消息(visitor)
     * 系统消息类型(system)
     */
    private String status;

    private String notice;

    private boolean isFirstReply;

    /**
     * 发送时间
     */
    private String time;

    private long ReplyTime;

    /**
     * 客服昵称
     */
    private String nickname;

    /**
     * 客服头像
     */
    private String headImg;

    private Integer companyId;
    private Integer websiteId;

    public MessageBean() {
    }


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

    public String getMsgType() {
        return msgType == null ? "" : msgType;
    }

    public void setMsgType(String msgType) {
        this.msgType = msgType;
    }

    public String getContent() {
        return content == null ? "" : content;
    }

    public void setContent(String content) {
        this.content = content;
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

    public String getTime() {
        return time == null ? "" : time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getStatus() {
        return status == null ? "" : status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getNotice() {
        return notice;
    }

    public void setNotice(String notice) {
        this.notice = notice;
    }

    public long getReplyTime() {
        return ReplyTime;
    }

    public void setReplyTime(long replyTime) {
        ReplyTime = replyTime;
    }

    public boolean isFirstReply() {
        return isFirstReply;
    }

    public void setFirstReply(boolean firstReply) {
        isFirstReply = firstReply;
    }
}
