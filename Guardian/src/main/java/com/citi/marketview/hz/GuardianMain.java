package com.citi.marketview.hz;

import com.citi.marketview.hz.listeners.HeartBeatListener;
import com.citi.marketview.hz.listeners.MemberListener;
import com.citi.marketview.hz.listeners.ObjectListener;
import com.hazelcast.core.Cluster;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IMap;

/**
 * Created by zs16243 on 18/04/2017.
 */
public class GuardianMain {
    public static void main(String[] args) throws InterruptedException {
        RestController.startService();
        HazelcastInstance hi = Guardian.getInstance("GUARDIAN_NAME");
        hi.addDistributedObjectListener(new ObjectListener());
        //TimeUnit.SECONDS.sleep(5);
        MemberListener memberListener = new MemberListener();
        Cluster cluster = hi.getCluster();
        cluster.getMembers().stream().forEach(m -> memberListener.addMember(m));
        cluster.addMembershipListener(memberListener);
        IMap<String, Long> hbs = hi.getMap("HEARTBEATS");
        hbs.addEntryListener(new HeartBeatListener(), true);
        hi.getMap("MAPPING").put("dupa","lipa");
        hi.getMap("GUARDIANS_REST").put(hi.getCluster().getLocalMember().getAddress().getHost(),12321);

    }

}
