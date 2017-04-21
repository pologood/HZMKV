package com.hazelcast.license.util;
import com.hazelcast.license.domain.Feature;
import com.hazelcast.license.domain.License;
import com.hazelcast.license.domain.LicenseType;
import com.hazelcast.license.domain.LicenseVersion;
import com.hazelcast.license.exception.InvalidLicenseException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public final class LicenseHelper
{
    public static final char[] chars = "dsx4MZQvo2tqegGLpWhCDXnPYzciBR3murF5SA7KIObaw1Vf6JNyjEl0UTkH".toCharArray();
    public static final char[] digits = "0123456789".toCharArray();
    public static final int length = chars.length;
    public static final int yearBase = 2000;
    public static final String INF_STR_ENTERPRISE = "HazelcastEnterprise";
    public static final String INF_STR_ENTERPRISE_HD = "HazelcastEnterpriseHD";
    public static final String INF_STR_MANCENTER = "ManagementCenter";
    public static final String INF_STR_SECURITY = "SecurityOnlyEnterprise";
    public static char[] hash(char[] a)
    {
        if (a == null) {
            return new char[] { '0' };
        }
        int result = 1;
        for (char element : a) {
            result = 31 * result + element;
        }
        return Integer.toString(Math.abs(result)).toCharArray();
    }

    public static int extractHazelcastMajorMinorVersionAsInt(String version) {
        String[] parts = version.split("\\.");
        if (parts.length > 2) {
            Integer versionPart1 = Integer.valueOf(Integer.parseInt(parts[0]));
            Integer versionPart2 = Integer.valueOf(Integer.parseInt(parts[1]));
            return versionPart1.intValue() * 10 + versionPart2.intValue();
        }
        String[] rcParts = parts[1].split("-");
        Integer versionPart1 = Integer.valueOf(Integer.parseInt(parts[0]));
        Integer versionPart2 = Integer.valueOf(Integer.parseInt(rcParts[0]));
        return versionPart1.intValue() * 10 + versionPart2.intValue();
    }

    public static LicenseVersion extractLicenseVersion(String version)
    {
        try
        {
            String[] parts = version.split("\\.");
            if (parts.length > 2) {
                Integer versionPart1 = Integer.valueOf(Integer.parseInt(parts[0]));
                Integer versionPart2 = Integer.valueOf(Integer.parseInt(parts[1]));
                Integer versionPart3 = Integer.valueOf(Integer.parseInt(parts[2]));
                if ((versionPart1.intValue() >= 3) && (versionPart2.intValue() >= 7))
                    return LicenseVersion.V4;
                if ((versionPart1.intValue() == 3) && (versionPart2.intValue() == 6) && (versionPart3.intValue() >= 1))
                    return LicenseVersion.V4;
                if ((versionPart1.intValue() == 3) && (versionPart2.intValue() == 6))
                    return LicenseVersion.V3;
                if ((versionPart1.intValue() >= 3) && (versionPart2.intValue() >= 5)) {
                    return LicenseVersion.V2;
                }
                return LicenseVersion.V1;
            }
            String[] rcParts = parts[1].split("-");
            Integer versionPart1 = Integer.valueOf(Integer.parseInt(parts[0]));
            Integer versionPart2 = Integer.valueOf(Integer.parseInt(rcParts[0]));
            if ((versionPart1.intValue() >= 3) && (versionPart2.intValue() >= 7))
                return LicenseVersion.V4;
            if ((versionPart1.intValue() == 3) && (versionPart2.intValue() == 6))
                return LicenseVersion.V3;
            if ((versionPart1.intValue() >= 3) && (versionPart2.intValue() >= 5)) {
                return LicenseVersion.V2;
            }
            return LicenseVersion.V1;
        }
        catch (Exception e) {
            e.printStackTrace(); }
        return LicenseVersion.V1;
    }

    public static boolean isExpired(License license)
    {
        if (System.currentTimeMillis() > license.getExpiryDate().getTime()) {
            return true;
        }
        return false;
    }

    public static License getLicense(String licenseKey, String versionString) {
        License license = new License(1234567890,"dsx4MZQvo2tqegGLpWhCDXnPYzciBR3murF5SA7KIObaw1Vf6JNyjEl0UTkH","LIPA",new Date(), new Date(Long.MAX_VALUE),false,"aaa@aaa.com",null,9999, Integer.MAX_VALUE, LicenseType.ENTERPRISE_HD, 38);
        List<Feature> featureList = new ArrayList<>();
        featureList.add(Feature.MAN_CENTER);
        featureList.add(Feature.WEB_SESSION);
        featureList.add(Feature.CLUSTERED_REST);
        featureList.add(Feature.CLUSTERED_JMX);
        featureList.add(Feature.SECURITY);
        featureList.add(Feature.WAN);
        featureList.add(Feature.HD_MEMORY);
        featureList.add(Feature.HOT_RESTART);
        featureList.add(Feature.CONTINUOUS_QUERY_CACHE);
        license.setFeatures(featureList);
        return license;
    }

    public static License checkLicenseKey(String licenseKey, String versionString, LicenseType... requiredLicenseTypes)
    {
        License license = getLicense(licenseKey, versionString);
        if (!Arrays.asList(requiredLicenseTypes).contains(license.getType())) {
            throw new InvalidLicenseException("Invalid License Type! Please contact sales@hazelcast.com");
        }
        return license;
    }

    public static License checkLicenseKeyPerFeature(String licenseKey, String versionString, Feature feature) {
        License license = getLicense(licenseKey, versionString);
        if (!license.getFeatures().contains(feature)) {
            throw new InvalidLicenseException("The Feature " + feature.getText() + " is not enabled for your license key." + "Please contact sales@hazelcast.com");
        }
        return license;
    }

    public static License mapFeaturesForLegacyLicense(License license){
        List<Feature> featureList = new ArrayList();
        if (license.getType() == LicenseType.MANAGEMENT_CENTER) {
            featureList.add(Feature.MAN_CENTER);
        }
        if (license.getType() == LicenseType.ENTERPRISE_SECURITY_ONLY) {
            featureList.add(Feature.SECURITY);
        }
        if (license.getType() == LicenseType.ENTERPRISE) {
            addEnterpriseFeatures(featureList);
            if (license.getVersion() == LicenseVersion.V2) {
                featureList.add(Feature.HD_MEMORY);
            }
        }
        if ((license.getVersion() == LicenseVersion.V3) && (license.getType() == LicenseType.ENTERPRISE_HD))
        {
            addEnterpriseFeatures(featureList);
            featureList.add(Feature.HD_MEMORY);
            featureList.add(Feature.HOT_RESTART);
        }
        license.setFeatures(featureList);
        return license;
    }

    private static void addEnterpriseFeatures(List<Feature> featureList) {
        featureList.add(Feature.MAN_CENTER);
        featureList.add(Feature.WEB_SESSION);
        featureList.add(Feature.CLUSTERED_REST);
        featureList.add(Feature.CLUSTERED_JMX);
        featureList.add(Feature.SECURITY);
        featureList.add(Feature.WAN);
        featureList.add(Feature.CONTINUOUS_QUERY_CACHE);
    }
}