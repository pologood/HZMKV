/*    */ package com.hazelcast.license.domain;
/*    */ 
/*    */ import java.io.Serializable;
/*    */ 
/*    */ public enum LicenseType implements Serializable
/*    */ {
/*  7 */   MANAGEMENT_CENTER(1, "Management Center"), 
/*  8 */   ENTERPRISE(0, "Enterprise"), 
/*  9 */   ENTERPRISE_SECURITY_ONLY(2, "Enterprise only with security"), 
/* 10 */   ENTERPRISE_HD(3, "Enterprise HD"), 
/* 11 */   CUSTOM(4, "Custom");
/*    */   
/*    */   private int code;
/*    */   private String text;
/*    */   
/*    */   private LicenseType(int code, String text) {
/* 17 */     this.code = code;
/* 18 */     this.text = text;
/*    */   }
/*    */   
/*    */   public int getCode() {
/* 22 */     return this.code;
/*    */   }
/*    */   
/*    */   public String getText() {
/* 26 */     return this.text;
/*    */   }
/*    */   
/*    */   public static LicenseType getDefault() {
/* 30 */     return ENTERPRISE;
/*    */   }
/*    */   
/*    */ }


/* Location:              C:\Users\zs16243\Desktop\mancenter\mancenter-3.8.1\WEB-INF\lib\hazelcast-license-extractor-1.1.6.jar!\com\hazelcast\license\domain\LicenseType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */