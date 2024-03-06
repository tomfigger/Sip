package com.feige.init.bean;

import android.os.Parcel;
import android.os.Parcelable;

import com.alibaba.fastjson.JSONObject;
import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class TempleChildren implements Parcelable {

    @SerializedName("id")
    private Integer id;
    @SerializedName("name")
    private String name;
    @SerializedName("pid")
    private Integer pid;
    @SerializedName("isView")
    private Boolean isView;
    @SerializedName("type")
    private Integer type;
    @SerializedName("data")
    private String data;
    @SerializedName("tips")
    private String tips;
    @SerializedName("children")
    private List<TempleChildren> children;

    public Boolean getView() {
        return isView;
    }

    public void setView(Boolean view) {
        isView = view;
    }


    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public List<TempleChildren> getChildren() {
        return children;
    }

    public void setChildren(List<TempleChildren> children) {
        this.children = children;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public Boolean getIsView() {
        return isView;
    }

    public void setIsView(Boolean isView) {
        this.isView = isView;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }


    public String getTips() {
        return tips;
    }

    public void setTips(String tips) {
        this.tips = tips;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(this.id);
        dest.writeString(this.name);
        dest.writeValue(this.pid);
        dest.writeValue(this.isView);
        dest.writeValue(this.type);
        dest.writeString(this.data);
        dest.writeString(this.tips);
        dest.writeTypedList(this.children);
    }

    public void readFromParcel(Parcel source) {
        this.id = (Integer) source.readValue(Integer.class.getClassLoader());
        this.name = source.readString();
        this.pid = (Integer) source.readValue(Integer.class.getClassLoader());
        this.isView = (Boolean) source.readValue(Boolean.class.getClassLoader());
        this.type = (Integer) source.readValue(Integer.class.getClassLoader());
        this.data = source.readString();
        this.tips = source.readString();
        this.children = source.createTypedArrayList(TempleChildren.CREATOR);
    }

    public TempleChildren() {
    }

    protected TempleChildren(Parcel in) {
        this.id = (Integer) in.readValue(Integer.class.getClassLoader());
        this.name = in.readString();
        this.pid = (Integer) in.readValue(Integer.class.getClassLoader());
        this.isView = (Boolean) in.readValue(Boolean.class.getClassLoader());
        this.type = (Integer) in.readValue(Integer.class.getClassLoader());
        this.data = in.readString();
        this.tips = in.readString();
        this.children = in.createTypedArrayList(TempleChildren.CREATOR);
    }

    public static final Creator<TempleChildren> CREATOR = new Creator<TempleChildren>() {
        @Override
        public TempleChildren createFromParcel(Parcel source) {
            return new TempleChildren(source);
        }

        @Override
        public TempleChildren[] newArray(int size) {
            return new TempleChildren[size];
        }
    };
}
