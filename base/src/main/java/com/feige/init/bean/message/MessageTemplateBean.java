package com.feige.init.bean.message;

/**
 * MrLiu253@163.com
 *
 * @time 2/9/22
 * 描述:
 */
public class MessageTemplateBean extends MessageBean {

    private Integer tempType;
    private Integer tempId;


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
}
