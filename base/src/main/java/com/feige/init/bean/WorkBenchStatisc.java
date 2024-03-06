package com.feige.init.bean;

import com.google.gson.annotations.SerializedName;

public class WorkBenchStatisc {

    @SerializedName("createTikectTotal")
    private Integer createTikectTotal;
    @SerializedName("workTikectTotal")
    private Integer workTikectTotal;
    @SerializedName("completeTikectTotal")
    private Integer completeTikectTotal;
    @SerializedName("processing")
    private Integer processing;
    @SerializedName("pending")
    private Integer pending;
    @SerializedName("unassignedTotal")
    private Integer unassignedTotal;
    @SerializedName("beingProcessed")
    private Integer beingProcessed;
    @SerializedName("toReply")
    private Integer toReply;
    @SerializedName("completeTikectAvgTime")
    private Integer completeTikectAvgTime;
    @SerializedName("completeTikectAvgTimeInfo")
    private String completeTikectAvgTimeInfo;
    @SerializedName("tikectResponseAvgTime")
    private Integer tikectResponseAvgTime;
    @SerializedName("tikectResponseAvgTimeInfo")
    private String tikectResponseAvgTimeInfo;

    public Integer getCreateTikectTotal() {
        return createTikectTotal;
    }

    public void setCreateTikectTotal(Integer createTikectTotal) {
        this.createTikectTotal = createTikectTotal;
    }

    public Integer getWorkTikectTotal() {
        return workTikectTotal;
    }

    public void setWorkTikectTotal(Integer workTikectTotal) {
        this.workTikectTotal = workTikectTotal;
    }

    public Integer getCompleteTikectTotal() {
        return completeTikectTotal;
    }

    public void setCompleteTikectTotal(Integer completeTikectTotal) {
        this.completeTikectTotal = completeTikectTotal;
    }

    public Integer getProcessing() {
        return processing;
    }

    public void setProcessing(Integer processing) {
        this.processing = processing;
    }

    public Integer getPending() {
        return pending;
    }

    public void setPending(Integer pending) {
        this.pending = pending;
    }

    public Integer getUnassignedTotal() {
        return unassignedTotal;
    }

    public void setUnassignedTotal(Integer unassignedTotal) {
        this.unassignedTotal = unassignedTotal;
    }

    public Integer getBeingProcessed() {
        return beingProcessed;
    }

    public void setBeingProcessed(Integer beingProcessed) {
        this.beingProcessed = beingProcessed;
    }

    public Integer getToReply() {
        return toReply;
    }

    public void setToReply(Integer toReply) {
        this.toReply = toReply;
    }

    public Integer getCompleteTikectAvgTime() {
        return completeTikectAvgTime;
    }

    public void setCompleteTikectAvgTime(Integer completeTikectAvgTime) {
        this.completeTikectAvgTime = completeTikectAvgTime;
    }

    public String getCompleteTikectAvgTimeInfo() {
        return completeTikectAvgTimeInfo;
    }

    public void setCompleteTikectAvgTimeInfo(String completeTikectAvgTimeInfo) {
        this.completeTikectAvgTimeInfo = completeTikectAvgTimeInfo;
    }

    public Integer getTikectResponseAvgTime() {
        return tikectResponseAvgTime;
    }

    public void setTikectResponseAvgTime(Integer tikectResponseAvgTime) {
        this.tikectResponseAvgTime = tikectResponseAvgTime;
    }

    public String getTikectResponseAvgTimeInfo() {
        return tikectResponseAvgTimeInfo;
    }

    public void setTikectResponseAvgTimeInfo(String tikectResponseAvgTimeInfo) {
        this.tikectResponseAvgTimeInfo = tikectResponseAvgTimeInfo;
    }
}
