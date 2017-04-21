package com.hazelcast.license.extractor;
import com.hazelcast.license.domain.Feature;
import com.hazelcast.license.domain.License;
import com.hazelcast.license.domain.LicenseType;
import com.hazelcast.license.exception.InvalidLicenseException;
import com.hazelcast.license.util.LicenseHelper;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
public class LicenseExtractorV4
{
    public static final int reserved = 30;
    public static License extractLicense(String licenseKey)
            throws InvalidLicenseException
    {
        License l = new License(1234567890,"dsx4MZQvo2tqegGLpWhCDXnPYzciBR3murF5SA7KIObaw1Vf6JNyjEl0UTkH","LIPA",new Date(), new Date(Long.MAX_VALUE),false,"aaa@aaa.com",null,9999, Integer.MAX_VALUE, LicenseType.ENTERPRISE_HD, 38);
        List<Feature> featureList = new ArrayList<>();
        featureList.add(Feature.MAN_CENTER);
        featureList.add(Feature.WEB_SESSION);
        featureList.add(Feature.CLUSTERED_REST);
        featureList.add(Feature.CLUSTERED_JMX);
        featureList.add(Feature.SECURITY);
        featureList.add(Feature.WAN);
        featureList.add(Feature.CONTINUOUS_QUERY_CACHE);
        l.setFeatures(featureList);
        return l;
    }
    private static int ix0(char c) {
        return ix(LicenseHelper.chars, c);
    }
    private static int ix1(char c) {
        return ix(LicenseHelper.digits, c);
    }
    private static int ix(char[] cc, char c) {
        for (int i = 0; i < cc.length; i++) {
            if (c == cc[i]) {
                return i;
            }
        }
        return -1;
    }
}


/* Location:              C:\Users\zs16243\Desktop\mancenter\mancenter-3.8.1\WEB-INF\lib\hazelcast-license-extractor-1.1.6.jar!\com\hazelcast\license\extractor\LicenseExtractorV4.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */