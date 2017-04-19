package com.citi.marketview.hz;

import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IMap;

import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by zs16243 on 18/04/2017.
 */
public class ClientMain {
    public static void main(String[] args) {
        HazelcastInstance hi = Client.getInstance("CLIENT_NAME");
        startHB(hi);
        Subscriber s = new Subscriber("dupa", new MKVMapListener());
    }

    public static void startHB(HazelcastInstance hi){
        Executors.newSingleThreadExecutor().execute(() -> {
            IMap<String, Long> hbs = hi.getMap("HEARTBEATS");
            while (true){
                hbs.put(hi.getCluster().getLocalMember().getUuid(), new Date().getTime(),10, TimeUnit.SECONDS);
                try {
                    TimeUnit.SECONDS.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
    }


}
