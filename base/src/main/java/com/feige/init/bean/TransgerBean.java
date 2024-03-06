package com.feige.init.bean;

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
public class TransgerBean {


    private String id;
    private String nickName;
    private List<AccountsBean> accounts;

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

    public List<AccountsBean> getAccounts() {
        if (accounts == null) {
            return new ArrayList<>();
        }
        return accounts;
    }

    public void setAccounts(List<AccountsBean> accounts) {
        this.accounts = accounts;
    }

    public static class AccountsBean{
        private String id;
        private String nickName;

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


    }
}
