package com.feige.init.bean;

import android.os.Parcel;
import android.os.Parcelable;

import com.chad.library.adapter.base.entity.node.BaseNode;

import org.jetbrains.annotations.Nullable;

import java.util.List;

/**
 * MrLiu253@163.com
 *
 * @time 1/26/22
 * 描述:
 */
public class ReplyMsgBean extends BaseNode implements Parcelable {

    private String title;
    private String content;

    public ReplyMsgBean(String title, String content) {
        this.title = title;
        this.content = content;
    }

    protected ReplyMsgBean(Parcel in) {
        title = in.readString();
        content = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(title);
        dest.writeString(content);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<ReplyMsgBean> CREATOR = new Creator<ReplyMsgBean>() {
        @Override
        public ReplyMsgBean createFromParcel(Parcel in) {
            return new ReplyMsgBean(in);
        }

        @Override
        public ReplyMsgBean[] newArray(int size) {
            return new ReplyMsgBean[size];
        }
    };

    public String getTitle() {
        return title == null ? "" : title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content == null ? "" : content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Nullable
    @Override
    public List<BaseNode> getChildNode() {
        return null;
    }
}
