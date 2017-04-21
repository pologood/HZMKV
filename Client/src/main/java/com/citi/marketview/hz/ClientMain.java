package com.citi.marketview.hz;

import com.citi.marketview.hz.objects.HeartBeat;
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
        //Subscriber s = new Subscriber("dupa", new Processor());
    }

    public static void startHB(HazelcastInstance hi){
        Executors.newSingleThreadExecutor().execute(() -> {
            IMap<Long,HeartBeat> hbs = hi.getMap("HEARTBEATS");
            while (true){
                long timestamp = new Date().getTime();
                hbs.put(timestamp ,new HeartBeat(hi),30, TimeUnit.SECONDS);
                System.out.println(timestamp);
                try {
                    TimeUnit.SECONDS.sleep(20);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
    }


}
