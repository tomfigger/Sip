package com.feige.init.bean;

import com.google.gson.annotations.SerializedName;

public class CityBean {

   @SerializedName("code")
   private String code;
   @SerializedName("name")
   private String name;

   public String getCode() {
      return code;
   }

   public void setCode(String code) {
      this.code = code;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   @Override
   public String toString() {
      return name;
   }
}
