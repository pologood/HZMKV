import com.hazelcast.license.domain.Feature;
import com.hazelcast.license.domain.License;
import com.hazelcast.license.domain.LicenseType;
import com.hazelcast.license.util.LicenseHelper;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by zs16243 on 18/04/2017.
 */
public class Testing {
    public static void main(String[] args) throws UnirestException {
        System.out.println(Unirest.get("http://127.0.0.1:5703/hazelcast/rest/cluster").asString().getBody());
    }

    @Test
    public void lic(){
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
        LicenseHelper.mapFeaturesForLegacyLicense(l);
        LicenseHelper.checkLicenseKey("dsx4MZQvo2tqegGLpWhCDXnPYzciBR3murF5SA7KIObaw1Vf6JNyjEl0UTkH","3.8.1", LicenseType.ENTERPRISE_HD);
    }

    List<String> words(char min, char max, int n) {
        List<String> ret = new ArrayList<String>();
        ret.add("");
        int start = 0;
        for(int length = 1; length <= n; ++length) {
            int end = ret.size();
            for(int i = 0; i < end; ++i) {
                for(char c = min; c <= max; ++c) {
                    ret.add(ret.get(i) + c);
                }
            }
            start = end;
        }
        return ret;
    }

}
