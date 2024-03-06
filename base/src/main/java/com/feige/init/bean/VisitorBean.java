package com.feige.init.bean;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.HashMap;

/**
 * MrLiu253@163.com
 *
 * @time 2/23/22
 * 描述: 访客信息
 */
public class VisitorBean {

    private GuestBean guest;
    private HashMap<String,Object> customer;
    @SerializedName("visitTimes")
    private int visitTimes;

    public int getVisitTimes() {
        return visitTimes;
    }

    public void setVisitTimes(int visitTimes) {
        this.visitTimes = visitTimes;
    }

    public GuestBean getGuest() {
        return guest;
    }

    public void setGuest(GuestBean guest) {
        this.guest = guest;
    }

    public HashMap<String, Object> getCustomer() {
        return customer;
    }

    public void setCustomer(HashMap<String, Object> customer) {
        this.customer = customer;
    }

    public static class GuestBean implements Serializable {

        @SerializedName("createTime")
        private String createTime;
        @SerializedName("id")
        private Integer id;
        @SerializedName("area")
        private String area;
        @SerializedName("baiDuId")
        private String baiDuId;
        @SerializedName("beginChatTime")
        private String beginChatTime;
        @SerializedName("chatTime")
        private Integer chatTime;
        @SerializedName("city")
        private String city;
        @SerializedName("collectionForm")
        private String collectionForm;
        @SerializedName("companyId")
        private Integer companyId;
        @SerializedName("country")
        private String country;
        @SerializedName("currentWebsite")
        private String currentWebsite;
        @SerializedName("currentWebTitle")
        private String currentWebTitle;
        @SerializedName("deviceType")
        private String deviceType;
        @SerializedName("duration")
        private Integer duration;
        @SerializedName("endChatTime")
        private Object endChatTime;
        @SerializedName("firstChatTime")
        private String firstChatTime;
        @SerializedName("fromSearchId")
        private String fromSearchId;
        @SerializedName("guestName")
        private String guestName;
        @SerializedName("im")
        private String im;
        @SerializedName("imId")
        private String imId;
        @SerializedName("ip")
        private String ip;
        @SerializedName("isVisit")
        private Boolean isVisit;
        @SerializedName("keyword")
        private String keyword;
        @SerializedName("province")
        private String province;
        @SerializedName("roomId")
        private String roomId;
        @SerializedName("seatId")
        private Integer seatId;
        @SerializedName("seatType")
        private Integer seatType;
        @SerializedName("sourcePage")
        private String sourcePage;
        @SerializedName("sourceType")
        private Integer sourceType;
        @SerializedName("status")
        private Integer status;
        @SerializedName("trajectory")
        private String trajectory;
        @SerializedName("updateTime")
        private String updateTime;
        @SerializedName("visitId")
        private String visitId;
        @SerializedName("websiteId")
        private Integer websiteId;
        @SerializedName("websiteName")
        private String websiteName;

        public int getVisitTimes() {
            return visitTimes;
        }

        public void setVisitTimes(int visitTimes) {
            this.visitTimes = visitTimes;
        }

        @SerializedName("visitTimes")
        private int visitTimes;

        public String getCreateTime() {
            return createTime;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getArea() {
            return area;
        }

        public void setArea(String area) {
            this.area = area;
        }

        public String getBaiDuId() {
            return baiDuId;
        }

        public void setBaiDuId(String baiDuId) {
            this.baiDuId = baiDuId;
        }

        public String getBeginChatTime() {
            return beginChatTime;
        }

        public void setBeginChatTime(String beginChatTime) {
            this.beginChatTime = beginChatTime;
        }

        public Integer getChatTime() {
            return chatTime;
        }

        public void setChatTime(Integer chatTime) {
            this.chatTime = chatTime;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getCollectionForm() {
            return collectionForm;
        }

        public void setCollectionForm(String collectionForm) {
            this.collectionForm = collectionForm;
        }

        public Integer getCompanyId() {
            return companyId;
        }

        public void setCompanyId(Integer companyId) {
            this.companyId = companyId;
        }

        public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
        }

        public String getCurrentWebsite() {
            return currentWebsite;
        }

        public void setCurrentWebsite(String currentWebsite) {
            this.currentWebsite = currentWebsite;
        }

        public String getCurrentWebTitle() {
            return currentWebTitle;
        }

        public void setCurrentWebTitle(String currentWebTitle) {
            this.currentWebTitle = currentWebTitle;
        }

        public String getDeviceType() {
            return deviceType;
        }

        public void setDeviceType(String deviceType) {
            this.deviceType = deviceType;
        }

        public Integer getDuration() {
            return duration;
        }

        public void setDuration(Integer duration) {
            this.duration = duration;
        }

        public Object getEndChatTime() {
            return endChatTime;
        }

        public void setEndChatTime(Object endChatTime) {
            this.endChatTime = endChatTime;
        }

        public String getFirstChatTime() {
            return firstChatTime;
        }

        public void setFirstChatTime(String firstChatTime) {
            this.firstChatTime = firstChatTime;
        }

        public String getFromSearchId() {
            return fromSearchId;
        }

        public void setFromSearchId(String fromSearchId) {
            this.fromSearchId = fromSearchId;
        }

        public String getGuestName() {
            return guestName;
        }

        public void setGuestName(String guestName) {
            this.guestName = guestName;
        }

        public String getIm() {
            return im;
        }

        public void setIm(String im) {
            this.im = im;
        }

        public String getImId() {
            return imId;
        }

        public void setImId(String imId) {
            this.imId = imId;
        }

        public String getIp() {
            return ip;
        }

        public void setIp(String ip) {
            this.ip = ip;
        }

        public Boolean getIsVisit() {
            return isVisit;
        }

        public void setIsVisit(Boolean isVisit) {
            this.isVisit = isVisit;
        }

        public String getKeyword() {
            return keyword;
        }

        public void setKeyword(String keyword) {
            this.keyword = keyword;
        }

        public String getProvince() {
            return province;
        }

        public void setProvince(String province) {
            this.province = province;
        }

        public String getRoomId() {
            return roomId;
        }

        public void setRoomId(String roomId) {
            this.roomId = roomId;
        }

        public Integer getSeatId() {
            return seatId;
        }

        public void setSeatId(Integer seatId) {
            this.seatId = seatId;
        }

        public Integer getSeatType() {
            return seatType;
        }

        public void setSeatType(Integer seatType) {
            this.seatType = seatType;
        }

        public String getSourcePage() {
            return sourcePage;
        }

        public void setSourcePage(String sourcePage) {
            this.sourcePage = sourcePage;
        }

        public Integer getSourceType() {
            return sourceType;
        }

        public void setSourceType(Integer sourceType) {
            this.sourceType = sourceType;
        }

        public Integer getStatus() {
            return status;
        }

        public void setStatus(Integer status) {
            this.status = status;
        }

        public String getTrajectory() {
            return trajectory;
        }

        public void setTrajectory(String trajectory) {
            this.trajectory = trajectory;
        }

        public String getUpdateTime() {
            return updateTime;
        }

        public void setUpdateTime(String updateTime) {
            this.updateTime = updateTime;
        }

        public String getVisitId() {
            return visitId;
        }

        public void setVisitId(String visitId) {
            this.visitId = visitId;
        }

        public Integer getWebsiteId() {
            return websiteId;
        }

        public void setWebsiteId(Integer websiteId) {
            this.websiteId = websiteId;
        }

        public String getWebsiteName() {
            return websiteName;
        }

        public void setWebsiteName(String websiteName) {
            this.websiteName = websiteName;
        }
    }

}
