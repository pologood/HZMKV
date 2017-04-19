package com.citi.marketview.hz;

import com.hazelcast.core.HazelcastInstance;

/**
 * Created by zs16243 on 18/04/2017.
 */
public class StorageMain {
    public static void main(String[] args) {
        HazelcastInstance hi = Storage.getInstance("STORAGE_NAME");
    }
}
