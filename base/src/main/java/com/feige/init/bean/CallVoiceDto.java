package com.feige.init.bean;

public class CallVoiceDto {
    private int callType;
    private String callee;
    private String taskId;

    public int getCallType() {
        return callType;
    }

    public void setCallType(int callType) {
        this.callType = callType;
    }

    public String getCallee() {
        return callee;
    }

    public void setCallee(String callee) {
        this.callee = callee;
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }
}
