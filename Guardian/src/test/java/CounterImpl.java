import com.citi.marketview.hz.services.Counter;

/**
 * Created by zs16243 on 19/04/2017.
 */
public class CounterImpl implements Counter {
    @Override
    public int inc(int amount) {
        return amount * amount;
    }

    @Override
    public String getPartitionKey() {
        return null;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public String getServiceName() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
