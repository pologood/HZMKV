package com.citi.marketview.hz;

import com.hazelcast.core.HazelcastInstance;

import java.net.MalformedURLException;
import java.util.Map;

/**
 * Created by zs16243 on 18/04/2017.
 */
public class Publisher {
    private Map.Entry<String, Integer> guardian;

    public Publisher(){
        HazelcastInstance instance = Client.getInstance();
        GuardianMapping g = new GuardianMapping();
        try {
            g.getGuardian(instance);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    private void publish(String entity, Map<String,String> content){

    }

}
