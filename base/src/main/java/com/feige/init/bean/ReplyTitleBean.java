package com.feige.init.bean;

import android.os.Parcel;
import android.os.Parcelable;

import com.chad.library.adapter.base.entity.node.BaseExpandNode;
import com.chad.library.adapter.base.entity.node.BaseNode;

import org.jetbrains.annotations.Nullable;

import java.util.List;

/**
 * MrLiu253@163.com
 *
 * @time 1/26/22
 * 描述:
 */
public class ReplyTitleBean  extends BaseExpandNode implements Parcelable {
    private String accountId;
    private String groupName;
    private List<BaseNode> replyContentDtos;

    public ReplyTitleBean(String accountId, String groupName, List<BaseNode> replyContentDtos) {
        this.accountId = accountId;
        this.groupName = groupName;
        this.replyContentDtos = replyContentDtos;
        setExpanded(false);
    }

    public String getAccountId() {
        return accountId == null ? "" : accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getGroupName() {
        return groupName == null ? "" : groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public void setReplyContentDtos(List<BaseNode> replyContentDtos) {
        this.replyContentDtos = replyContentDtos;
    }

    @Nullable
    @Override
    public List<BaseNode> getChildNode() {
        return replyContentDtos;
    }


    protected ReplyTitleBean(Parcel in) {
        accountId = in.readString();
        groupName = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(accountId);
        dest.writeString(groupName);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<ReplyTitleBean> CREATOR = new Creator<ReplyTitleBean>() {
        @Override
        public ReplyTitleBean createFromParcel(Parcel in) {
            return new ReplyTitleBean(in);
        }

        @Override
        public ReplyTitleBean[] newArray(int size) {
            return new ReplyTitleBean[size];
        }
    };
}
