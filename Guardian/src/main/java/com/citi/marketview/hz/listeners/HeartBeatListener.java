package com.citi.marketview.hz.listeners;

import com.citi.marketview.hz.objects.HeartBeat;
import com.hazelcast.core.EntryEvent;
import com.hazelcast.map.listener.EntryEvictedListener;

/**
 * Created by LosLocos on 4/18/2017.
 */
public class HeartBeatListener implements EntryEvictedListener<Long, HeartBeat> {
    @Override
    public void entryEvicted(EntryEvent<Long, HeartBeat> entryEvent) {
        System.out.println(entryEvent +  " - Lack of Hearbeats");
    }
}
