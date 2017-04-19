import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

/**
 * Created by zs16243 on 18/04/2017.
 */
public class Testing {
    public static void main(String[] args) throws UnirestException {
        System.out.println(Unirest.get("http://127.0.0.1:5703/hazelcast/rest/cluster").asString().getBody());
    }
}
