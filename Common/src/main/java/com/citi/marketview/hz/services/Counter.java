package com.citi.marketview.hz.services;

import com.hazelcast.core.DistributedObject;

public interface Counter extends DistributedObject {

    int inc(int amount);
}