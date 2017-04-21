/*     */ package com.hazelcast.license.extractor;
/*     */ 
/*     */ import com.hazelcast.license.domain.License;
/*     */ import com.hazelcast.license.domain.LicenseType;
/*     */ import com.hazelcast.license.domain.LicenseVersion;
/*     */ import com.hazelcast.license.exception.InvalidLicenseException;
/*     */ import com.hazelcast.license.util.LicenseHelper;
/*     */ import java.util.Calendar;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class LicenseExtractorV3
/*     */ {
/*     */   public static final int reserved = 23;
/*     */   
/*     */   public static License extractLicense(String licenseKey)
/*     */     throws InvalidLicenseException
/*     */   {
/*  22 */     if ((licenseKey == null) || (licenseKey.isEmpty())) {
/*  23 */       throw new IllegalArgumentException("License key can not be empty.");
/*     */     }
/*     */     
/*  26 */     String[] keyTokens = licenseKey.split("#");
/*     */     
/*  28 */     char[] originalKey = keyTokens[(keyTokens.length - 1)].toCharArray();
/*  29 */     if (LicenseHelper.length != originalKey.length) {
/*  30 */       throw new InvalidLicenseException("Invalid License Key!");
/*     */     }
/*     */     
/*  33 */     char[] key = new char[LicenseHelper.length];
/*  34 */     System.arraycopy(originalKey, 0, key, 0, LicenseHelper.length);
/*  35 */     char fp = key[22];
/*  36 */     key[22] = '\000';
/*  37 */     char lp = key[23];
/*  38 */     key[23] = '\000';
/*     */     
/*  40 */     char[] hash = LicenseHelper.hash(key);
/*  41 */     if ((hash[0] != fp) || (hash[(hash.length - 1)] != lp)) {
/*  42 */       throw new InvalidLicenseException("Invalid License Key!");
/*     */     }
/*     */     
/*  45 */     int ix = 0;
/*  46 */     char r = key[(ix++)];
/*  47 */     boolean isTrial = key[ix0(r)] == '1';
/*     */     
/*  49 */     char t = key[(ix++)];
/*  50 */     char type = key[ix0(t)];
/*  51 */     LicenseType licenseType = null;
/*  52 */     switch (type) {
/*     */     case '0': 
/*  54 */       licenseType = LicenseType.MANAGEMENT_CENTER;
/*  55 */       break;
/*     */     case '1': 
/*  57 */       licenseType = LicenseType.ENTERPRISE;
/*  58 */       break;
/*     */     case '2': 
/*  60 */       licenseType = LicenseType.ENTERPRISE_SECURITY_ONLY;
/*  61 */       break;
/*     */     case '3': 
/*  63 */       licenseType = LicenseType.ENTERPRISE_HD;
/*     */     }
/*     */     
/*  66 */     char d0 = key[(ix++)];
/*  67 */     char d1 = key[(ix++)];
/*  68 */     int day = ix1(key[ix0(d0)]) * 10 + ix1(key[ix0(d1)]);
/*     */     
/*  70 */     char m0 = key[(ix++)];
/*  71 */     char m1 = key[(ix++)];
/*  72 */     int month = ix1(key[ix0(m0)]) * 10 + ix1(key[ix0(m1)]);
/*     */     
/*  74 */     char y0 = key[(ix++)];
/*  75 */     char y1 = key[(ix++)];
/*  76 */     int year = 2000 + ix1(key[ix0(y0)]) * 10 + ix1(key[ix0(y1)]);
/*     */     
/*     */ 
/*  79 */     Calendar cal = Calendar.getInstance();
/*  80 */     cal.set(1, year);
/*  81 */     cal.set(2, month - 1);
/*  82 */     cal.set(5, day);
/*     */     
/*     */ 
/*  85 */     char n0 = key[(ix++)];
/*  86 */     char n1 = key[(ix++)];
/*  87 */     char n2 = key[(ix++)];
/*  88 */     char n3 = key[(ix++)];
/*  89 */     int nodes = ix1(key[ix0(n0)]) * 1000 + ix1(key[ix0(n1)]) * 100 + ix1(key[ix0(n2)]) * 10 + ix1(key[ix0(n3)]);
/*     */     
/*     */ 
/*  92 */     char h0 = key[(ix++)];
/*  93 */     char h1 = key[(ix++)];
/*  94 */     char h2 = key[(ix++)];
/*  95 */     char h3 = key[(ix++)];
/*  96 */     char h4 = key[(ix++)];
/*  97 */     char h5 = key[(ix++)];
/*  98 */     char h6 = key[(ix++)];
/*  99 */     char h7 = key[(ix++)];
/*     */     
/* 101 */     int hdAmount = ix1(key[ix0(h0)]) * 1000000 + ix1(key[ix0(h1)]) * 1000000 + ix1(key[ix0(h2)]) * 100000 + ix1(key[ix0(h3)]) * 10000 + ix1(key[ix0(h4)]) * 1000 + ix1(key[ix0(h5)]) * 100 + ix1(key[ix0(h6)]) * 10 + ix1(key[ix0(h7)]);
/*     */     
/*     */ 
/* 104 */     char l0 = key[(ix++)];
/* 105 */     char l1 = key[(ix++)];
/* 106 */     int hazelcastVersion = ix1(key[ix0(l0)]) * 10 + ix1(key[ix0(l1)]);
/*     */     
/* 108 */     License license = new License(0, licenseKey, null, null, cal.getTime(), isTrial, null, null, nodes, hdAmount, licenseType, hazelcastVersion);
/*     */     
/* 110 */     license.setVersion(LicenseVersion.V3);
/* 111 */     LicenseHelper.mapFeaturesForLegacyLicense(license);
/* 112 */     return license;
/*     */   }
/*     */   
/*     */   private static int ix0(char c) {
/* 116 */     return ix(LicenseHelper.chars, c);
/*     */   }
/*     */   
/*     */   private static int ix1(char c) {
/* 120 */     return ix(LicenseHelper.digits, c);
/*     */   }
/*     */   
/*     */   private static int ix(char[] cc, char c) {
/* 124 */     for (int i = 0; i < cc.length; i++) {
/* 125 */       if (c == cc[i]) {
/* 126 */         return i;
/*     */       }
/*     */     }
/* 129 */     return -1;
/*     */   }
/*     */ }


/* Location:              C:\Users\zs16243\Desktop\mancenter\mancenter-3.8.1\WEB-INF\lib\hazelcast-license-extractor-1.1.6.jar!\com\hazelcast\license\extractor\LicenseExtractorV3.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */