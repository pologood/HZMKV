package com.citi.marketview.hz.services;

import com.hazelcast.spi.AbstractDistributedObject;
import com.hazelcast.spi.InvocationBuilder;
import com.hazelcast.spi.NodeEngine;
import com.hazelcast.util.ExceptionUtil;

import java.util.concurrent.Future;

public class SubscribeProxy extends AbstractDistributedObject<SubscribeService> implements Subscribe {

    private final String name;

    SubscribeProxy(String name, NodeEngine nodeEngine, SubscribeService subscribeServiceService) {
        super(nodeEngine, subscribeServiceService);
        this.name = name;
    }

    @Override
    public String getServiceName() {
        return SubscribeService.NAME;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String subscribe(String entity) {
        NodeEngine nodeEngine = getNodeEngine();
        SubscribeOperation operation = new SubscribeOperation(name, entity);
        int partitionId = nodeEngine.getPartitionService().getPartitionId(name);
        InvocationBuilder builder = nodeEngine.getOperationService().createInvocationBuilder(SubscribeService.NAME, operation, partitionId);
        try {
            Future<String> future = builder.invoke();
            return future.get();
        } catch (Exception e) {
            throw ExceptionUtil.rethrow(e);
        }
    }
}
