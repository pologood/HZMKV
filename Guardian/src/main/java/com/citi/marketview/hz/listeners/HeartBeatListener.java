package com.citi.marketview.hz.listeners;

import com.hazelcast.core.EntryEvent;
import com.hazelcast.map.listener.EntryEvictedListener;

/**
 * Created by LosLocos on 4/18/2017.
 */
public class HeartBeatListener implements EntryEvictedListener<String,Long> {
    @Override
    public void entryEvicted(EntryEvent<String, Long> entryEvent) {
        System.out.println(entryEvent.getKey() +  " - Lack of Hearbeats");
    }
}
