package com.feige.init.bean;

import com.chad.library.adapter.base.entity.node.BaseNode;

import org.jetbrains.annotations.Nullable;

import java.util.List;

/**
 * MrLiu253@163.com
 *
 * @time 1/25/22
 * 描述:
 */
public class TransgerMsgBean extends BaseNode{
    private String id;
    private String nickName;

    public TransgerMsgBean(String id, String nickName) {
        this.id = id;
        this.nickName = nickName;
    }

    public String getId() {
        return id == null ? "" : id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNickName() {
        return nickName == null ? "" : nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    @Nullable
    @Override
    public List<BaseNode> getChildNode() {
        return null;
    }
}
