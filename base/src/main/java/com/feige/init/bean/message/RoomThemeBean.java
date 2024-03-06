package com.feige.init.bean.message;

/**
 * MrLiu253@163.com
 *
 * @time 2/18/22
 * 描述:
 */
public class RoomThemeBean {
    private String roomjid;//房间id
    private String equipmentType;//来源
    private String cityRegion;//地址
    private String currentWebtitle;//
    private String websiteId;
    private String userjid;

    public String getEquipmentType() {
        return equipmentType == null ? "" : equipmentType;
    }

    public void setEquipmentType(String equipmentType) {
        this.equipmentType = equipmentType;
    }

    public String getCityRegion() {
        return cityRegion == null ? "" : cityRegion;
    }

    public void setCityRegion(String cityRegion) {
        this.cityRegion = cityRegion;
    }

    public String getRoomjid() {
        return roomjid == null ? "" : roomjid;
    }

    public void setRoomjid(String roomjid) {
        this.roomjid = roomjid;
    }

    public String getCurrentWebtitle() {
        return currentWebtitle == null ? "" : currentWebtitle;
    }

    public void setCurrentWebtitle(String currentWebtitle) {
        this.currentWebtitle = currentWebtitle;
    }

    public String getWebSiteId() {
        return websiteId == null ? "" : websiteId;
    }

    public void setWebSiteId(String webSiteId) {
        this.websiteId = webSiteId;
    }

    public String getUserjid() {
        return userjid == null ? "" : userjid;
    }

    public void setUserjid(String userjid) {
        this.userjid = userjid;
    }
}
