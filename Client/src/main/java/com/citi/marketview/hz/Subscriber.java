package com.citi.marketview.hz;

import com.hazelcast.core.HazelcastInstance;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import java.net.MalformedURLException;
import java.util.Map;

/**
 * Created by zs16243 on 18/04/2017.
 */
public class Subscriber {
    private Map.Entry<String, Integer> guardian;
    public Subscriber(String entity, IMapEntryProcessor handler){
        HazelcastInstance instance = Client.getInstance();
        GuardianMapping g = new GuardianMapping();
        try {
            g.getGuardian(instance);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        try {
            String map = Unirest.post(g.setupSubscription(entity).toString()).body(instance.getCluster().getLocalMember().getUuid()).asString().getBody();
            instance.getMap(map).addEntryListener(new CustomMapListener(handler), true);
        } catch (UnirestException e) {
            e.printStackTrace();
        }
    }

}
