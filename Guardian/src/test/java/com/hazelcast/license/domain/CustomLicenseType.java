/*    */ package com.hazelcast.license.domain;
/*    */ 
/*    */ import java.io.Serializable;
/*    */ import java.util.List;
/*    */ 
/*    */ public class CustomLicenseType implements Serializable
/*    */ {
/*    */   private int id;
/*    */   private String text;
/*    */   private List<Feature> features;
/*    */   
/*    */   public CustomLicenseType() {}
/*    */   
/*    */   public CustomLicenseType(int id, String text)
/*    */   {
/* 16 */     this.id = id;
/* 17 */     this.text = text;
/* 18 */     this.features = new java.util.ArrayList();
/*    */   }
/*    */   
/*    */   public int getId() {
/* 22 */     return this.id;
/*    */   }
/*    */   
/*    */   public String getText() {
/* 26 */     return this.text;
/*    */   }
/*    */   
/*    */   public List<Feature> getFeatures() {
/* 30 */     return this.features;
/*    */   }
/*    */   
/*    */   public void setId(int id) {
/* 34 */     this.id = id;
/*    */   }
/*    */   
/*    */   public void setText(String text) {
/* 38 */     this.text = text;
/*    */   }
/*    */   
/*    */   public void setFeatures(List<Feature> features) {
/* 42 */     this.features = features;
/*    */   }
/*    */ }


/* Location:              C:\Users\zs16243\Desktop\mancenter\mancenter-3.8.1\WEB-INF\lib\hazelcast-license-extractor-1.1.6.jar!\com\hazelcast\license\domain\CustomLicenseType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */