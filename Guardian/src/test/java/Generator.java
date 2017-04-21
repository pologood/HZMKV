import com.hazelcast.license.domain.License;
import com.hazelcast.license.extractor.LicenseExtractorV4;

/**
 * Created by zs16243 on 20/04/2017.
 */
public class Generator {

    private char[] charset;

    private int min; //var added for min char length
    private int max; //var added for max char length

    public Generator() {
        charset = "dsx4MZQvo2tqegGLpWhCDXnPYzciBR3murF5SA7KIObaw1Vf6JNyjEl0UTkH".toCharArray();
        min = 60; //char min start
        max = 61; //char max end
    }

    public void generate(String str, int pos, int length) {
        if (length == 0) {
            //System.out.println(str);
            try {
                License l = LicenseExtractorV4.extractLicense(str);
                System.out.println(l);
            }catch (Exception e){

            }
        } else {

            //This if statement resets the char position back to the very first character in the character set ('a'), which makes this a complete solution to an all combinations bruteforce!
            if (pos != 0) {
                pos = 0;
            }

            for (int i = pos; i < charset.length; i++) {
                generate(str + charset[i], i, length - 1);
            }
        }
    }

    public static void main(String[] args) {
        Generator bruteforce = new Generator();

        for (int length = bruteforce.min; length < bruteforce.max; length++) // Change bruteforce.min and bruteforce.max for number of characters to bruteforce.
            bruteforce.generate("", 0, length); //prepend_string, pos, length
    }
}
