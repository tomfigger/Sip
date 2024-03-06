package com.feige.init.bean;

import com.alibaba.fastjson.annotation.JSONField;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class GuestInfo implements Serializable {

    @SerializedName("userjid")
    private String userjid;
    @SerializedName("cityRegion")
    private String cityRegion;
    @SerializedName("im")
    private String im;
    @SerializedName("websiteId")
    private Integer websiteId;
    @SerializedName("country")
    private String country;
    @SerializedName("province")
    private String province;
    @SerializedName("city")
    private String city;
    @SerializedName("area")
    private String area;
    @SerializedName("ip")
    private String ip;
    @SerializedName("keyword")
    private String keyword;
    @SerializedName("sourcePage")
    private String sourcePage;
    @SerializedName("companyName")
    private String companyName;
    @SerializedName("websiteName")
    private String websiteName;
    @SerializedName("equipmentType")
    private String equipmentType;
    @SerializedName("currentWebsite")
    private String currentWebsite;
    @SerializedName("trajectory")
    private List<TrajectoryDTO> trajectory;
    @SerializedName("currentWebTitle")
    private String currentWebTitle;
    @SerializedName("searchKey")
    private String searchKey;
    @SerializedName("visitTimes")
    private Integer visitTimes;
    @SerializedName("imid")
    private String imid;
    @JSONField(name = "deviceType")
    private String deviceType;
    @JSONField(name = "landingAndChatPage")
    private LandingAndChatPageDTO landingAndChatPage;

    public String getUserjid() {
        return userjid;
    }

    public void setUserjid(String userjid) {
        this.userjid = userjid;
    }

    public String getCityRegion() {
        return cityRegion;
    }

    public void setCityRegion(String cityRegion) {
        this.cityRegion = cityRegion;
    }

    public String getIm() {
        return im;
    }

    public void setIm(String im) {
        this.im = im;
    }

    public Integer getWebsiteId() {
        return websiteId;
    }

    public void setWebsiteId(Integer websiteId) {
        this.websiteId = websiteId;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getSourcePage() {
        return sourcePage;
    }

    public void setSourcePage(String sourcePage) {
        this.sourcePage = sourcePage;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getWebsiteName() {
        return websiteName;
    }

    public void setWebsiteName(String websiteName) {
        this.websiteName = websiteName;
    }

    public String getEquipmentType() {
        return equipmentType;
    }

    public void setEquipmentType(String equipmentType) {
        this.equipmentType = equipmentType;
    }

    public String getCurrentWebsite() {
        return currentWebsite;
    }

    public void setCurrentWebsite(String currentWebsite) {
        this.currentWebsite = currentWebsite;
    }

    public List<TrajectoryDTO> getTrajectory() {
        return trajectory;
    }

    public void setTrajectory(List<TrajectoryDTO> trajectory) {
        this.trajectory = trajectory;
    }

    public String getCurrentWebTitle() {
        return currentWebTitle;
    }

    public void setCurrentWebTitle(String currentWebTitle) {
        this.currentWebTitle = currentWebTitle;
    }

    public String getSearchKey() {
        return searchKey;
    }

    public void setSearchKey(String searchKey) {
        this.searchKey = searchKey;
    }

    public Integer getVisitTimes() {
        return visitTimes;
    }

    public void setVisitTimes(Integer visitTimes) {
        this.visitTimes = visitTimes;
    }

    public String getImid() {
        return imid;
    }

    public void setImid(String imid) {
        this.imid = imid;
    }

    public String getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }

    public LandingAndChatPageDTO getLandingAndChatPage() {
        return landingAndChatPage;
    }

    public void setLandingAndChatPage(LandingAndChatPageDTO landingAndChatPage) {
        this.landingAndChatPage = landingAndChatPage;
    }

    public static class TrajectoryDTO implements Serializable {
        @SerializedName("title")
        private String title;
        @SerializedName("url")
        private String url;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }

    public static class LandingAndChatPageDTO {
        @JSONField(name = "landingPage")
        private String landingPage;
        @JSONField(name = "landingTitle")
        private String landingTitle;
        @JSONField(name = "chatPage")
        private String chatPage;
        @JSONField(name = "chatTitle")
        private String chatTitle;

        public String getLandingPage() {
            return landingPage;
        }

        public void setLandingPage(String landingPage) {
            this.landingPage = landingPage;
        }

        public String getLandingTitle() {
            return landingTitle;
        }

        public void setLandingTitle(String landingTitle) {
            this.landingTitle = landingTitle;
        }

        public String getChatPage() {
            return chatPage;
        }

        public void setChatPage(String chatPage) {
            this.chatPage = chatPage;
        }

        public String getChatTitle() {
            return chatTitle;
        }

        public void setChatTitle(String chatTitle) {
            this.chatTitle = chatTitle;
        }
    }
}