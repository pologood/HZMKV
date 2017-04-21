/*    */ package com.hazelcast.license.domain;
/*    */ 
/*    */ import java.io.Serializable;
/*    */ 
/*    */ public enum Feature implements Serializable
/*    */ {
/*  7 */   MAN_CENTER(0, "Management Center"), 
/*  8 */   WEB_SESSION(1, "Web Session"), 
/*  9 */   CLUSTERED_JMX(2, "Clustered JMX"), 
/* 10 */   CLUSTERED_REST(3, "Clustered Rest"), 
/* 11 */   SECURITY(4, "Security"), 
/* 12 */   WAN(5, "Wan Replication"), 
/* 13 */   HD_MEMORY(6, "High Density Memory"), 
/* 14 */   HOT_RESTART(7, "Hot Restart"), 
/* 15 */   CONTINUOUS_QUERY_CACHE(8, "Continuous Query Cache");
/*    */   
/*    */   private int code;
/*    */   private String text;
/*    */   
/*    */   private Feature(int code, String text) {
/* 21 */     this.code = code;
/* 22 */     this.text = text;
/*    */   }
/*    */   
/*    */   public int getCode() {
/* 26 */     return this.code;
/*    */   }
/*    */   
/*    */   public String getText() {
/* 30 */     return this.text;
/*    */   }
/*    */   
/*    */   public static Feature getDefault() {
/* 34 */     return MAN_CENTER;
/*    */   }
/*    */   
/*    */ }


/* Location:              C:\Users\zs16243\Desktop\mancenter\mancenter-3.8.1\WEB-INF\lib\hazelcast-license-extractor-1.1.6.jar!\com\hazelcast\license\domain\Feature.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */