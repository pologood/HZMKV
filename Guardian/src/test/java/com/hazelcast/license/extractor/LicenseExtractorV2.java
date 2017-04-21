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
/*     */ public class LicenseExtractorV2
/*     */ {
/*     */   public static final int reserved = 25;
/*     */   
/*     */   public static License extractLicense(String licenseKey)
/*     */     throws InvalidLicenseException
/*     */   {
/*  20 */     if ((licenseKey == null) || (licenseKey.isEmpty())) {
/*  21 */       throw new IllegalArgumentException("License key can not be empty.");
/*     */     }
/*     */     
/*  24 */     String[] keyTokens = licenseKey.split("#");
/*     */     
/*  26 */     char[] originalKey = keyTokens[(keyTokens.length - 1)].toCharArray();
/*  27 */     if (LicenseHelper.length != originalKey.length) {
/*  28 */       throw new InvalidLicenseException("Invalid License Key!");
/*     */     }
/*     */     
/*  31 */     char[] key = new char[LicenseHelper.length];
/*  32 */     System.arraycopy(originalKey, 0, key, 0, LicenseHelper.length);
/*  33 */     char fp = key[24];
/*  34 */     key[24] = '\000';
/*  35 */     char lp = key[25];
/*  36 */     key[25] = '\000';
/*     */     
/*  38 */     char[] hash = LicenseHelper.hash(key);
/*  39 */     if ((hash[0] != fp) || (hash[(hash.length - 1)] != lp)) {
/*  40 */       throw new InvalidLicenseException("Invalid License Key!");
/*     */     }
/*     */     
/*  43 */     int ix = 0;
/*  44 */     char r = key[(ix++)];
/*  45 */     boolean isTrial = key[ix0(r)] == '1';
/*     */     
/*  47 */     char t = key[(ix++)];
/*  48 */     char type = key[ix0(t)];
/*  49 */     LicenseType licenseType = null;
/*  50 */     switch (type) {
/*     */     case '0': 
/*  52 */       licenseType = LicenseType.MANAGEMENT_CENTER;
/*  53 */       break;
/*     */     case '1': 
/*  55 */       licenseType = LicenseType.ENTERPRISE;
/*  56 */       break;
/*     */     case '2': 
/*  58 */       licenseType = LicenseType.ENTERPRISE_SECURITY_ONLY;
/*     */     }
/*     */     
/*  61 */     char d0 = key[(ix++)];
/*  62 */     char d1 = key[(ix++)];
/*  63 */     int day = ix1(key[ix0(d0)]) * 10 + ix1(key[ix0(d1)]);
/*     */     
/*  65 */     char m0 = key[(ix++)];
/*  66 */     char m1 = key[(ix++)];
/*  67 */     int month = ix1(key[ix0(m0)]) * 10 + ix1(key[ix0(m1)]);
/*     */     
/*  69 */     char y0 = key[(ix++)];
/*  70 */     char y1 = key[(ix++)];
/*  71 */     int year = 2000 + ix1(key[ix0(y0)]) * 10 + ix1(key[ix0(y1)]);
/*     */     
/*     */ 
/*  74 */     Calendar cal = Calendar.getInstance();
/*  75 */     cal.set(1, year);
/*  76 */     cal.set(2, month - 1);
/*  77 */     cal.set(5, day);
/*     */     
/*     */ 
/*  80 */     char n0 = key[(ix++)];
/*  81 */     char n1 = key[(ix++)];
/*  82 */     char n2 = key[(ix++)];
/*  83 */     char n3 = key[(ix++)];
/*  84 */     int nodes = ix1(key[ix0(n0)]) * 1000 + ix1(key[ix0(n1)]) * 100 + ix1(key[ix0(n2)]) * 10 + ix1(key[ix0(n3)]);
/*     */     
/*     */ 
/*  87 */     char c0 = key[(ix++)];
/*  88 */     char c1 = key[(ix++)];
/*  89 */     char c2 = key[(ix++)];
/*  90 */     char c3 = key[(ix++)];
/*  91 */     int clients = ix1(key[ix0(c0)]) * 1000 + ix1(key[ix0(c1)]) * 100 + ix1(key[ix0(c2)]) * 10 + ix1(key[ix0(c3)]);
/*     */     
/*     */ 
/*  94 */     char h0 = key[(ix++)];
/*  95 */     char h1 = key[(ix++)];
/*  96 */     char h2 = key[(ix++)];
/*  97 */     char h3 = key[(ix++)];
/*  98 */     char h4 = key[(ix++)];
/*  99 */     char h5 = key[(ix++)];
/* 100 */     char h6 = key[(ix++)];
/* 101 */     char h7 = key[(ix++)];
/*     */     
/* 103 */     int hdAmount = ix1(key[ix0(h0)]) * 1000000 + ix1(key[ix0(h1)]) * 1000000 + ix1(key[ix0(h2)]) * 100000 + ix1(key[ix0(h3)]) * 10000 + ix1(key[ix0(h4)]) * 1000 + ix1(key[ix0(h5)]) * 100 + ix1(key[ix0(h6)]) * 10 + ix1(key[ix0(h7)]);
/*     */     
/* 105 */     License license = new License(0, licenseKey, null, null, cal.getTime(), isTrial, null, null, nodes, hdAmount, licenseType, 99);
/* 106 */     license.setVersion(LicenseVersion.V2);
/* 107 */     LicenseHelper.mapFeaturesForLegacyLicense(license);
/* 108 */     return license;
/*     */   }
/*     */   
/*     */   private static int ix0(char c) {
/* 112 */     return ix(LicenseHelper.chars, c);
/*     */   }
/*     */   
/*     */   private static int ix1(char c) {
/* 116 */     return ix(LicenseHelper.digits, c);
/*     */   }
/*     */   
/*     */   private static int ix(char[] cc, char c) {
/* 120 */     for (int i = 0; i < cc.length; i++) {
/* 121 */       if (c == cc[i]) {
/* 122 */         return i;
/*     */       }
/*     */     }
/* 125 */     return -1;
/*     */   }
/*     */ }


/* Location:              C:\Users\zs16243\Desktop\mancenter\mancenter-3.8.1\WEB-INF\lib\hazelcast-license-extractor-1.1.6.jar!\com\hazelcast\license\extractor\LicenseExtractorV2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */