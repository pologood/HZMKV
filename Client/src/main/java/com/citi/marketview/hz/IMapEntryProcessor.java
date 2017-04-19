package com.citi.marketview.hz;

import com.hazelcast.core.EntryEvent;

/**
 * Created by LosLocos on 4/18/2017.
 */
public interface IMapEntryProcessor {
    void process(EntryEvent evt);
}
