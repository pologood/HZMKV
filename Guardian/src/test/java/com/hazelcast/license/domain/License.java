/*     */ package com.hazelcast.license.domain;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ import java.text.DateFormat;
/*     */ import java.text.SimpleDateFormat;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Date;
/*     */ import java.util.List;
/*     */ 
/*     */ 
/*     */ public class License
/*     */   implements Serializable
/*     */ {
/*     */   public static final int UNLIMITED_MARKER = 9999;
/*     */   public static final int UNLIMITED_MARKER_HD_CACHE = 99999999;
/*     */   private int allowedNumberOfNodes;
/*     */   private LicenseType type;
/*     */   private LicenseVersion version;
/*     */   private long licenseId;
/*     */   private String pardotId;
/*     */   private String companyName;
/*     */   private String licenseName;
/*     */   private String email;
/*     */   private Boolean trial;
/*     */   private String key;
/*     */   private Date creationDate;
/*     */   private Date expiryDate;
/*     */   private int allowedNativeMemorySize;
/*     */   private LicenseChannel licenseChannel;
/*     */   private String creatorEmail;
/*     */   private int hazelcastVersion;
/*     */   private int customTypeId;
/*     */   private List<Feature> features;
/*     */   
/*     */   public int getAllowedNumberOfNodes()
/*     */   {
/*  37 */     return this.allowedNumberOfNodes;
/*     */   }
/*     */   
/*     */   public void setAllowedNumberOfNodes(int allowedNumberOfNodes) {
/*  41 */     this.allowedNumberOfNodes = allowedNumberOfNodes;
/*     */   }
/*     */   
/*     */   public LicenseType getType() {
/*  45 */     return this.type;
/*     */   }
/*     */   
/*     */   public void setType(LicenseType type) {
/*  49 */     this.type = type;
/*     */   }
/*     */   
/*     */   public LicenseVersion getVersion() {
/*  53 */     return this.version;
/*     */   }
/*     */   
/*     */   public void setVersion(LicenseVersion version) {
/*  57 */     this.version = version;
/*     */   }
/*     */   
/*     */   public long getLicenseId() {
/*  61 */     return this.licenseId;
/*     */   }
/*     */   
/*     */   public void setLicenseId(long licenseId) {
/*  65 */     this.licenseId = licenseId;
/*     */   }
/*     */   
/*     */   public String getPardotId() {
/*  69 */     return this.pardotId;
/*     */   }
/*     */   
/*     */   public void setPardotId(String pardotId) {
/*  73 */     this.pardotId = pardotId;
/*     */   }
/*     */   
/*     */   public String getCompanyName() {
/*  77 */     return this.companyName;
/*     */   }
/*     */   
/*     */   public void setCompanyName(String companyName) {
/*  81 */     this.companyName = companyName;
/*     */   }
/*     */   
/*     */   public String getEmail() {
/*  85 */     return this.email;
/*     */   }
/*     */   
/*     */   public void setEmail(String email) {
/*  89 */     this.email = email;
/*     */   }
/*     */   
/*     */   public Boolean isTrial() {
/*  93 */     return this.trial;
/*     */   }
/*     */   
/*     */   public void setTrial(Boolean trial) {
/*  97 */     this.trial = trial;
/*     */   }
/*     */   
/*     */   public String getKey() {
/* 101 */     return this.key;
/*     */   }
/*     */   
/*     */   public void setKey(String key) {
/* 105 */     this.key = key;
/*     */   }
/*     */   
/*     */   public Date getCreationDate() {
/* 109 */     return this.creationDate;
/*     */   }
/*     */   
/*     */   public void setCreationDate(Date creationDate) {
/* 113 */     this.creationDate = creationDate;
/*     */   }
/*     */   
/*     */   public Date getExpiryDate() {
/* 117 */     return this.expiryDate;
/*     */   }
/*     */   
/*     */   public void setExpiryDate(Date expiryDate) {
/* 121 */     this.expiryDate = expiryDate;
/*     */   }
/*     */   
/*     */   public int getAllowedNativeMemorySize() {
/* 125 */     return this.allowedNativeMemorySize;
/*     */   }
/*     */   
/*     */   public void setAllowedNativeMemorySize(int allowedNativeMemorySize) {
/* 129 */     this.allowedNativeMemorySize = allowedNativeMemorySize;
/*     */   }
/*     */   
/*     */   public LicenseChannel getLicenseChannel() {
/* 133 */     return this.licenseChannel;
/*     */   }
/*     */   
/*     */   public void setLicenseChannel(LicenseChannel licenseChannel) {
/* 137 */     this.licenseChannel = licenseChannel;
/*     */   }
/*     */   
/*     */   public String getCreatorEmail() {
/* 141 */     return this.creatorEmail;
/*     */   }
/*     */   
/*     */   public void setCreatorEmail(String creatorEmail) {
/* 145 */     this.creatorEmail = creatorEmail;
/*     */   }
/*     */   
/*     */   public int getHazelcastVersion() {
/* 149 */     return this.hazelcastVersion;
/*     */   }
/*     */   
/*     */   public void setHazelcastVersion(int hazelcastVersion) {
/* 153 */     this.hazelcastVersion = hazelcastVersion;
/*     */   }
/*     */   
/*     */   public int getCustomTypeId() {
/* 157 */     return this.customTypeId;
/*     */   }
/*     */   
/*     */   public void setCustomTypeId(int customTypeId) {
/* 161 */     this.customTypeId = customTypeId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public License() {}
/*     */   
/*     */ 
/*     */ 
/*     */   public License(int licenseId, String key, String companyName, Date creationDate, Date expiryDate, boolean isTrial, String email, String pardotId, int allowedNumberOfNodes, int allowedNativeMemorySize, LicenseType type, int hazelcastVersion)
/*     */   {
/* 172 */     this.licenseId = licenseId;
/* 173 */     this.key = key;
/* 174 */     this.allowedNumberOfNodes = allowedNumberOfNodes;
/* 175 */     this.type = type;
/* 176 */     this.companyName = companyName;
/* 177 */     this.email = email;
/* 178 */     this.pardotId = pardotId;
/* 179 */     this.trial = Boolean.valueOf(isTrial);
/* 180 */     this.creationDate = creationDate;
/* 181 */     this.expiryDate = expiryDate;
/* 182 */     this.allowedNativeMemorySize = allowedNativeMemorySize;
/* 183 */     this.hazelcastVersion = hazelcastVersion;
/* 184 */     this.features = new ArrayList();
/*     */   }
/*     */   
/*     */   public String getLicenseName() {
/* 188 */     return this.licenseName;
/*     */   }
/*     */   
/*     */   public void setLicenseName(String licenseName) {
/* 192 */     this.licenseName = licenseName;
/*     */   }
/*     */   
/*     */   public List<Feature> getFeatures() {
/* 196 */     return this.features;
/*     */   }
/*     */   
/*     */   public void setFeatures(List<Feature> features) {
/* 200 */     this.features = features;
/*     */   }
/*     */   
/*     */   private String formatHazelcastVersion() {
/* 204 */     int majorPart = this.hazelcastVersion / 10;
/* 205 */     int minorPart = this.hazelcastVersion % 10;
/* 206 */     return majorPart + "." + minorPart;
/*     */   }
/*     */   
/*     */   private String listFeatures() {
/* 210 */     StringBuilder builder = new StringBuilder();
/* 211 */     builder.append("[ ");
/* 212 */     for (int i = 0; i < this.features.size(); i++) {
/* 213 */       builder.append(((Feature)this.features.get(i)).getText());
/* 214 */       if (i < this.features.size() - 1) {
/* 215 */         builder.append(", ");
/*     */       }
/*     */     }
/* 218 */     builder.append(" ]");
/* 219 */     return builder.toString();
/*     */   }
/*     */   
/*     */   public boolean equals(Object o)
/*     */   {
/* 224 */     if (this == o) return true;
/* 225 */     if (!(o instanceof License)) { return false;
/*     */     }
/* 227 */     License license = (License)o;
/*     */     
/* 229 */     if (this.allowedNumberOfNodes != license.allowedNumberOfNodes) return false;
/* 230 */     if (this.allowedNativeMemorySize != license.allowedNativeMemorySize) return false;
/* 231 */     if (this.trial != license.trial) return false;
/* 232 */     if (this.licenseId != license.licenseId) return false;
/* 233 */     if (this.pardotId != license.pardotId) return false;
/* 234 */     if (this.companyName != null ? !this.companyName.equals(license.companyName) : license.companyName != null) return false;
/* 235 */     if (this.creationDate.compareTo(license.creationDate) != 0) return false;
/* 236 */     if (!this.email.equals(license.email)) return false;
/* 237 */     if (this.expiryDate != null ? this.expiryDate.compareTo(license.expiryDate) != 0 : license.expiryDate != null) return false;
/* 238 */     if (!this.key.equals(license.key)) return false;
/* 239 */     if (this.type != license.type) return false;
/* 240 */     if (this.hazelcastVersion != license.hazelcastVersion) return false;
/* 241 */     return true;
/*     */   }
/*     */   
/*     */   public int hashCode()
/*     */   {
/* 246 */     int result = this.allowedNumberOfNodes;
/* 247 */     result = 31 * result + this.type.hashCode();
/* 248 */     result = 31 * result + this.pardotId.hashCode();
/* 249 */     result = 31 * result + (this.companyName != null ? this.companyName.hashCode() : 0);
/* 250 */     result = 31 * result + this.email.hashCode();
/* 251 */     result = 31 * result + (this.trial.booleanValue() ? 1 : 0);
/* 252 */     result = 31 * result + this.key.hashCode();
/* 253 */     result = 31 * result + this.creationDate.hashCode();
/* 254 */     result = 31 * result + (this.expiryDate != null ? this.expiryDate.hashCode() : 0);
/* 255 */     result = 31 * result + this.allowedNativeMemorySize;
/* 256 */     result = 31 * result + this.hazelcastVersion;
/* 257 */     result = 31 * result + this.licenseName.hashCode();
/* 258 */     result = 31 * result + this.customTypeId;
/* 259 */     return result;
/*     */   }
/*     */   
/*     */   public String toString()
/*     */   {
/* 264 */     DateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
/* 265 */     return "License{allowedNumberOfNodes=" + this.allowedNumberOfNodes + ", expiryDate=" + formatter.format(this.expiryDate) + ", featureList=" + listFeatures() + (this.hazelcastVersion == 99 ? ", No Version Restriction" : new StringBuilder().append(", restrictedToVersion=").append(formatHazelcastVersion()).toString()) + '}';
/*     */   }
/*     */ }


/* Location:              C:\Users\zs16243\Desktop\mancenter\mancenter-3.8.1\WEB-INF\lib\hazelcast-license-extractor-1.1.6.jar!\com\hazelcast\license\domain\License.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */