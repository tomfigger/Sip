package com.feige.init.bean;

import java.util.ArrayList;
import java.util.List;

/**
 * MrLiu253@163.com
 *
 * @time 1/26/22
 * 描述:
 */
public class ReplyBean {


    private List<GeneralBean> general;
    private List<GeneralBean> personal;

    public List<GeneralBean> getGeneral() {
        if (general == null) {
            return new ArrayList<>();
        }
        return general;
    }

    public void setGeneral(List<GeneralBean> general) {
        this.general = general;
    }

    public List<GeneralBean> getPersonal() {
        if (personal == null) {
            return new ArrayList<>();
        }
        return personal;
    }

    public void setPersonal(List<GeneralBean> personal) {
        this.personal = personal;
    }

    public static class GeneralBean {
        private String accountId;
        private String groupName;
        private List<ReplyContentDtosBean> replyContentDtos;

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

        public List<ReplyContentDtosBean> getReplyContentDtos() {
            if (replyContentDtos == null) {
                return new ArrayList<>();
            }
            return replyContentDtos;
        }

        public void setReplyContentDtos(List<ReplyContentDtosBean> replyContentDtos) {
            this.replyContentDtos = replyContentDtos;
        }

        public static class ReplyContentDtosBean {
            private String title;
            private String content;

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
        }
    }
}
