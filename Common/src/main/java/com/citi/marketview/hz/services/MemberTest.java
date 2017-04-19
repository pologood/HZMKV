package com.citi.marketview.hz.services; /**
 * Created by zs16243 on 19/04/2017.
 */

import com.hazelcast.config.Config;
import com.hazelcast.config.MulticastConfig;
import com.hazelcast.config.ServiceConfig;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;

public class MemberTest {
    public static void main(String[] args) {
        HazelcastInstance[] instances = new HazelcastInstance[2];
        Config c = new Config();
        c.getNetworkConfig().getJoin().setMulticastConfig(new MulticastConfig().setEnabled(true));
        c.getServicesConfig().addServiceConfig(new ServiceConfig().setEnabled(true).setClassName("com.citi.marketview.hz.services.CounterService").setName("CounterService"));
        for (int i = 0; i < instances.length; i++) {
            instances[i] = Hazelcast.newHazelcastInstance(c);
        }

        Counter[] counters = new Counter[4];
        for (int i = 0; i < counters.length; i++) {
            counters[i] = instances[0].getDistributedObject(CounterService.NAME, i + "counter");
        }

        for (Counter counter : counters) {
            System.out.println(counter.inc(1));
        }

        System.out.println("Finished");
        Hazelcast.shutdownAll();
    }
}