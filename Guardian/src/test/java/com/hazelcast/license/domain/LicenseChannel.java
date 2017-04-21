/*    */ package com.hazelcast.license.domain;
/*    */ 
/*    */ import java.io.Serializable;
/*    */ 
/*    */ public enum LicenseChannel implements Serializable
/*    */ {
/*  7 */   LICENSE_GENERATOR(0, "Web"), 
/*  8 */   WEB(1, "Dowload");
/*    */   
/*    */   private int code;
/*    */   private String text;
/*    */   
/*    */   private LicenseChannel(int code, String text) {
/* 14 */     this.code = code;
/* 15 */     this.text = text;
/*    */   }
/*    */   
/*    */   public int getCode() {
/* 19 */     return this.code;
/*    */   }
/*    */   
/*    */   public String getText() {
/* 23 */     return this.text;
/*    */   }
/*    */   
/*    */   public static LicenseChannel getDefault() {
/* 27 */     return WEB;
/*    */   }
/*    */   
/*    */ }


/* Location:              C:\Users\zs16243\Desktop\mancenter\mancenter-3.8.1\WEB-INF\lib\hazelcast-license-extractor-1.1.6.jar!\com\hazelcast\license\domain\LicenseChannel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */