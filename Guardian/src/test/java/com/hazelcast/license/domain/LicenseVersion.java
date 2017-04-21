/*    */ package com.hazelcast.license.domain;
/*    */ 
/*    */ import java.io.Serializable;
/*    */ 
/*    */ public enum LicenseVersion implements Serializable
/*    */ {
/*  7 */   V1(0, "V1-pre 3.5"), 
/*  8 */   V2(1, "V2 3.5"), 
/*  9 */   V3(2, "V3 3.6"), 
/* 10 */   V4(3, "V4 3.6.1+");
/*    */   
/*    */   private int code;
/*    */   private String text;
/*    */   
/*    */   private LicenseVersion(int code, String text) {
/* 16 */     this.code = code;
/* 17 */     this.text = text;
/*    */   }
/*    */   
/*    */   public int getCode() {
/* 21 */     return this.code;
/*    */   }
/*    */   
/*    */   public String getText() {
/* 25 */     return this.text;
/*    */   }
/*    */   
/*    */   public static LicenseVersion getDefault() {
/* 29 */     return V1;
/*    */   }
/*    */   
/*    */ }


/* Location:              C:\Users\zs16243\Desktop\mancenter\mancenter-3.8.1\WEB-INF\lib\hazelcast-license-extractor-1.1.6.jar!\com\hazelcast\license\domain\LicenseVersion.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */