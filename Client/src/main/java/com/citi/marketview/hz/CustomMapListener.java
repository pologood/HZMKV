package com.citi.marketview.hz;

import com.hazelcast.core.EntryEvent;
import com.hazelcast.map.listener.EntryAddedListener;
import com.hazelcast.map.listener.EntryEvictedListener;
import com.hazelcast.map.listener.EntryRemovedListener;
import com.hazelcast.map.listener.EntryUpdatedListener;

/**
 * Created by zs16243 on 18/04/2017.
 */
public class CustomMapListener implements EntryAddedListener<String, String>,
        EntryRemovedListener<String, String>,
        EntryUpdatedListener<String, String>,
        EntryEvictedListener<String, String> {

    private IMapEntryProcessor imp;

    public CustomMapListener(IMapEntryProcessor imp){
        this.imp = imp;
    }

    @Override
    public void entryAdded(EntryEvent<String, String> entryEvent) {
        process(entryEvent);
    }

    @Override
    public void entryEvicted(EntryEvent<String, String> entryEvent) {
        process(entryEvent);
    }

    @Override
    public void entryRemoved(EntryEvent<String, String> entryEvent) {
        process(entryEvent);
    }

    @Override
    public void entryUpdated(EntryEvent<String, String> entryEvent) {
        process(entryEvent);
    }

    private void process(EntryEvent<String, String> entryEvent){
        imp.process(entryEvent);
    }

}
