package com.feige.init.bean;

import com.google.gson.annotations.SerializedName;

public class SeatBean {

   @SerializedName("key")
   private Integer key;
   @SerializedName("value")
   private String value;

   public SeatBean(Integer key, String value) {
      this.key = key;
      this.value = value;
   }

   public SeatBean() {
   }

   public Integer getKey() {
      return key;
   }

   public void setKey(Integer key) {
      this.key = key;
   }

   public String getValue() {
      return value;
   }

   public void setValue(String value) {
      this.value = value;
   }
}
