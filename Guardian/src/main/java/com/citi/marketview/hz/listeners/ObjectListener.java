package com.citi.marketview.hz.listeners;

import com.hazelcast.core.DistributedObjectEvent;
import com.hazelcast.core.DistributedObjectListener;

/**
 * Created by zs16243 on 18/04/2017.
 */
public class ObjectListener implements DistributedObjectListener {
    @Override
    public void distributedObjectCreated(DistributedObjectEvent distributedObjectEvent) {
        System.out.println(distributedObjectEvent.getDistributedObject().getServiceName());
        System.out.println(distributedObjectEvent.getEventType());
        System.out.println(distributedObjectEvent.getObjectName());
        System.out.println(distributedObjectEvent.getDistributedObject().getServiceName());
        System.out.println(distributedObjectEvent.getDistributedObject().getPartitionKey());
    }

    @Override
    public void distributedObjectDestroyed(DistributedObjectEvent distributedObjectEvent) {
        System.out.println(distributedObjectEvent);
    }
}
