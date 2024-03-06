package com.feige.init.bean;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class BaseTempleData implements Parcelable {
    @SerializedName("id")
    private Integer id;

    public static final Creator<BaseTempleData> CREATOR = new Creator<BaseTempleData>() {
        @Override
        public BaseTempleData createFromParcel(Parcel in) {
            return new BaseTempleData(in);
        }

        @Override
        public BaseTempleData[] newArray(int size) {
            return new BaseTempleData[size];
        }
    };

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(this.id);
    }

    public void readFromParcel(Parcel source) {
        this.id = (Integer) source.readValue(Integer.class.getClassLoader());
    }

    public BaseTempleData() {
    }

    protected BaseTempleData(Parcel in) {
        this.id = (Integer) in.readValue(Integer.class.getClassLoader());
    }

}
