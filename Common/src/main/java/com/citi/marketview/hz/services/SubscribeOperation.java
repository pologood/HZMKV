package com.citi.marketview.hz.services;

import com.hazelcast.nio.ObjectDataInput;
import com.hazelcast.nio.ObjectDataOutput;
import com.hazelcast.spi.Operation;
import com.hazelcast.spi.PartitionAwareOperation;

import java.io.IOException;

@SuppressWarnings("unused")
class SubscribeOperation extends Operation implements PartitionAwareOperation {

    private String objectId;
    private String entity;
    private String returnValue;

    // it is important to have a no-arg constructor for deserialization
    public SubscribeOperation() {
    }

    SubscribeOperation(String objectId, String entity) {
        this.entity = entity;
        this.objectId = objectId;
    }

    @Override
    public void run() throws Exception {
        System.out.println("Executing " + objectId + ".inc() on: " + getNodeEngine().getThisAddress());
        String uuid = this.getCallerUuid();
        this.getNodeEngine().getHazelcastInstance().getMap("");
        returnValue = "";
    }

    @Override
    public Object getResponse() {
        return returnValue;
    }

    @Override
    protected void writeInternal(ObjectDataOutput out) throws IOException {
        super.writeInternal(out);
        out.writeUTF(objectId);
        out.writeUTF(entity);
    }

    @Override
    protected void readInternal(ObjectDataInput in) throws IOException {
        super.readInternal(in);
        objectId = in.readUTF();
        entity = in.readUTF();
    }
}
