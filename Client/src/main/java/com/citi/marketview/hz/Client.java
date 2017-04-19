package com.citi.marketview.hz;

import com.hazelcast.config.*;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastException;
import com.hazelcast.core.HazelcastInstance;

import java.util.Arrays;

/**
 * Created by zs16243 on 18/04/2017.
 */
public class Client {

    private static HazelcastInstance instance;

    private static String name;
    protected Client(){

    }

    public static HazelcastInstance getInstance(String name) {
        Client.name = name;
        return Client.getInstance();
    }

    public static HazelcastInstance getInstance(){
        if(name == null){
            throw new HazelcastException("No Name provided for Instance");
        }
        if(instance == null){
            Config config = new Config();
            config.getGroupConfig()
                    .setName("MarketViewReplacement")
                    .setPassword("dupadupa");
            config.getNetworkConfig()
                    .setPort(5701)
                    .setPortAutoIncrement(true)
                    .setJoin(
                            new JoinConfig()
                                    .setMulticastConfig(new MulticastConfig().setEnabled(false))
                                    .setTcpIpConfig(
                                            new TcpIpConfig()
                                                    .setEnabled(true)
                                                    .setMembers(Arrays.asList(
                                                            "127.0.0.1"
                                                    ))
                                    )
                                    .setAwsConfig(new AwsConfig().setEnabled(false))
                    )
                    .setPortCount(100);
            config.setLiteMember(true);
            config.setInstanceName("Client");
            config.getMemberAttributeConfig().setStringAttribute("NAME", name);
            config.getMemberAttributeConfig().setStringAttribute("TYPE", "CLIENT");
            instance = Hazelcast.getOrCreateHazelcastInstance(config);
        }
        return instance;
    }
}
