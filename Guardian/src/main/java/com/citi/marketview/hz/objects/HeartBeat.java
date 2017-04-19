package com.citi.marketview.hz.objects;

import com.hazelcast.core.HazelcastInstance;

import java.util.Date;

/**
 * Created by zs16243 on 19/04/2017.
 */
public class HeartBeat {
    private MemberEntry member;
    private long timestamp;

    public HeartBeat(HazelcastInstance hi){
        this.timestamp = new Date().getTime();
        this.member = new MemberEntry(hi.getCluster().getLocalMember());
    }
}
