package com.feige.init.bean;

import java.io.Serializable;

public class PhoneBelong implements Serializable {


   private String phone;
   private String placeOwnership;
   private String operator;

   public String getPhone() {
      return phone;
   }

   public void setPhone(String phone) {
      this.phone = phone;
   }

   public String getPlaceOwnership() {
      return placeOwnership;
   }

   public void setPlaceOwnership(String placeOwnership) {
      this.placeOwnership = placeOwnership;
   }

   public String getOperator() {
      return operator;
   }

   public void setOperator(String operator) {
      this.operator = operator;
   }
}
