package com.citi.marketview.hz;

import com.hazelcast.core.EntryEvent;

/**
 * Created by zs16243 on 19/04/2017.
 */
public class Processor implements IMapEntryProcessor{
    @Override
    public void process(EntryEvent evt) {
        System.out.println(evt);
    }
}
