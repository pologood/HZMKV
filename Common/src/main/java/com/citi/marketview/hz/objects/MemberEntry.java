package com.citi.marketview.hz.objects;

import com.hazelcast.core.Member;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zs16243 on 18/04/2017.
 */
public class MemberEntry {
    private String ip;
    private Integer port;
    private String uuid;
    private Map<String,String> attributes = new HashMap<>();

    public MemberEntry(Member member){
        ip = member.getAddress().getHost();
        port = member.getAddress().getPort();
        uuid = member.getUuid();
        member.getAttributes().entrySet().stream().forEach(en -> attributes.put(en.getKey(), en.getValue().toString()));
    }

}
