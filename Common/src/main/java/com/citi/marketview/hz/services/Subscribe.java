package com.citi.marketview.hz.services;

import com.hazelcast.core.DistributedObject;

public interface Subscribe extends DistributedObject {

    String subscribe(String entity);
}
