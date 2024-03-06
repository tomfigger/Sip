package com.feige.init.bean;

import com.chad.library.adapter.base.entity.node.BaseExpandNode;
import com.chad.library.adapter.base.entity.node.BaseNode;

import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

/**
 * MrLiu253@163.com
 *
 * @time 1/25/22
 * 描述:
 */
public class TransgerTitleBean extends BaseExpandNode {
    private List<BaseNode> accounts;
    private String id;
    private String nickName;

    public TransgerTitleBean(List<BaseNode> childNode, String id, String title) {
        this.accounts = childNode;
        this.id = id;
        this.nickName = title;
        setExpanded(false);
    }

    public String getId() {
        return id == null ? "" : id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setChildNode(List<BaseNode> childNode) {
        this.accounts = childNode;
    }

    public String getTitle() {
        return nickName == null ? "" : nickName;
    }

    public void setTitle(String title) {
        this.nickName = title;
    }

    @Nullable
    @Override
    public List<BaseNode> getChildNode() {
        if (accounts == null) {
            return new ArrayList<>();
        }
        return accounts;
    }
}
