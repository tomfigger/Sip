package com.feige.init.bean;

import com.google.gson.annotations.SerializedName;

public class BrownRecord {

   @SerializedName("id")
   private Integer id;
   @SerializedName("createTime")
   private String createTime;
   @SerializedName("customerId")
   private Integer customerId;
   @SerializedName("pageTitle")
   private String pageTitle;
   @SerializedName("pageUrl")
   private String pageUrl;

   public Integer getId() {
      return id;
   }

   public void setId(Integer id) {
      this.id = id;
   }

   public String getCreateTime() {
      return createTime;
   }

   public void setCreateTime(String createTime) {
      this.createTime = createTime;
   }

   public Integer getCustomerId() {
      return customerId;
   }

   public void setCustomerId(Integer customerId) {
      this.customerId = customerId;
   }

   public String getPageTitle() {
      return pageTitle;
   }

   public void setPageTitle(String pageTitle) {
      this.pageTitle = pageTitle;
   }

   public String getPageUrl() {
      return pageUrl;
   }

   public void setPageUrl(String pageUrl) {
      this.pageUrl = pageUrl;
   }
}
