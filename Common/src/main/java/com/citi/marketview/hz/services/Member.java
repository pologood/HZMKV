package com.citi.marketview.hz.services;

import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;

public class Member {
    public static void main(String[] args) {
        HazelcastInstance[] instances = new HazelcastInstance[2];
        for (int i = 0; i < instances.length; i++) {
            instances[i] = Hazelcast.newHazelcastInstance();
        }

        Subscribe[] counters = new Subscribe[10];
        for (int i = 0; i < counters.length; i++) {
            counters[i] = instances[i % instances.length].getDistributedObject(SubscribeService.NAME, i + "counter");
        }

        for (Subscribe counter : counters) {
            System.out.println(counter.subscribe("aaa"));
        }

        System.out.println("Finished");
        Hazelcast.shutdownAll();
    }
}
