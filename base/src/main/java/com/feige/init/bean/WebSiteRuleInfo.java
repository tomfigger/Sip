package com.feige.init.bean;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class WebSiteRuleInfo implements Serializable {

    @SerializedName("accountWelcomes")
    private String accountWelcomes;
    @SerializedName("autoMessage")
    private AutoMessageDTO autoMessage;
    @SerializedName("chatRule")
    private ChatRuleDTO chatRule;
    @SerializedName("websiteId")
    private String websiteId;

    public String getAccountWelcomes() {
        return accountWelcomes;
    }

    public void setAccountWelcomes(String accountWelcomes) {
        this.accountWelcomes = accountWelcomes;
    }

    public AutoMessageDTO getAutoMessage() {
        return autoMessage;
    }

    public void setAutoMessage(AutoMessageDTO autoMessage) {
        this.autoMessage = autoMessage;
    }

    public ChatRuleDTO getChatRule() {
        return chatRule;
    }

    public void setChatRule(ChatRuleDTO chatRule) {
        this.chatRule = chatRule;
    }

    public String getWebsiteId() {
        return websiteId;
    }

    public void setWebsiteId(String websiteId) {
        this.websiteId = websiteId;
    }

    public static class AutoMessageDTO {
        @SerializedName("welcomes")
        private String welcomes;
        @SerializedName("isStopAfterReplay")
        private Boolean isStopAfterReplay;
        @SerializedName("openGuestWolTime")
        private Integer openGuestWolTime;
        @SerializedName("isOpenGuestWol")
        private Boolean isOpenGuestWol;
        @SerializedName("isOpenPromotion")
        private Boolean isOpenPromotion;
        @SerializedName("isOpenWelcomes")
        private String isOpenWelcomes;
        @SerializedName("openGuestWolText")
        private String openGuestWolText;
        @SerializedName("items")
        private List<ItemsDTO> items;

        public String getWelcomes() {
            return welcomes;
        }

        public void setWelcomes(String welcomes) {
            this.welcomes = welcomes;
        }

        public Boolean getIsStopAfterReplay() {
            return isStopAfterReplay;
        }

        public void setIsStopAfterReplay(Boolean isStopAfterReplay) {
            this.isStopAfterReplay = isStopAfterReplay;
        }

        public Integer getOpenGuestWolTime() {
            return openGuestWolTime;
        }

        public void setOpenGuestWolTime(Integer openGuestWolTime) {
            this.openGuestWolTime = openGuestWolTime;
        }

        public Boolean getIsOpenGuestWol() {
            return isOpenGuestWol;
        }

        public void setIsOpenGuestWol(Boolean isOpenGuestWol) {
            this.isOpenGuestWol = isOpenGuestWol;
        }

        public Boolean getIsOpenPromotion() {
            return isOpenPromotion;
        }

        public void setIsOpenPromotion(Boolean isOpenPromotion) {
            this.isOpenPromotion = isOpenPromotion;
        }

        public String getIsOpenWelcomes() {
            return isOpenWelcomes;
        }

        public void setIsOpenWelcomes(String isOpenWelcomes) {
            this.isOpenWelcomes = isOpenWelcomes;
        }

        public String getOpenGuestWolText() {
            return openGuestWolText;
        }

        public void setOpenGuestWolText(String openGuestWolText) {
            this.openGuestWolText = openGuestWolText;
        }

        public List<ItemsDTO> getItems() {
            return items;
        }

        public void setItems(List<ItemsDTO> items) {
            this.items = items;
        }

        public static class ItemsDTO {
            @SerializedName("conditionKey")
            private Integer conditionKey;
            @SerializedName("pushTime")
            private Integer pushTime;
            @SerializedName("message")
            private String message;
            @SerializedName("operator")
            private Integer operator;
            @SerializedName("sendScope")
            private Integer sendScope;
            @SerializedName("conditionValue")
            private String conditionValue;

            public Integer getConditionKey() {
                return conditionKey;
            }

            public void setConditionKey(Integer conditionKey) {
                this.conditionKey = conditionKey;
            }

            public Integer getPushTime() {
                return pushTime;
            }

            public void setPushTime(Integer pushTime) {
                this.pushTime = pushTime;
            }

            public String getMessage() {
                return message;
            }

            public void setMessage(String message) {
                this.message = message;
            }

            public Integer getOperator() {
                return operator;
            }

            public void setOperator(Integer operator) {
                this.operator = operator;
            }

            public Integer getSendScope() {
                return sendScope;
            }

            public void setSendScope(Integer sendScope) {
                this.sendScope = sendScope;
            }

            public String getConditionValue() {
                return conditionValue;
            }

            public void setConditionValue(String conditionValue) {
                this.conditionValue = conditionValue;
            }
        }
    }

    public static class ChatRuleDTO {
        @SerializedName("autoEndTime")
        private Integer autoEndTime;
        @SerializedName("isAutoEnd")
        private Boolean isAutoEnd;
        @SerializedName("isEndRemind")
        private Boolean isEndRemind;
        @SerializedName("isTimeoutRemind")
        private Boolean isTimeoutRemind;
        @SerializedName("timeoutPeriod")
        private Integer timeoutPeriod;

        public Integer getAutoEndTime() {
            return autoEndTime;
        }

        public void setAutoEndTime(Integer autoEndTime) {
            this.autoEndTime = autoEndTime;
        }

        public Boolean getIsAutoEnd() {
            return isAutoEnd;
        }

        public void setIsAutoEnd(Boolean isAutoEnd) {
            this.isAutoEnd = isAutoEnd;
        }

        public Boolean getIsEndRemind() {
            return isEndRemind;
        }

        public void setIsEndRemind(Boolean isEndRemind) {
            this.isEndRemind = isEndRemind;
        }

        public Boolean getIsTimeoutRemind() {
            return isTimeoutRemind;
        }

        public void setIsTimeoutRemind(Boolean isTimeoutRemind) {
            this.isTimeoutRemind = isTimeoutRemind;
        }

        public Integer getTimeoutPeriod() {
            return timeoutPeriod;
        }

        public void setTimeoutPeriod(Integer timeoutPeriod) {
            this.timeoutPeriod = timeoutPeriod;
        }
    }
}
