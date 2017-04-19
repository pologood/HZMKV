package com.citi.marketview.hz;

import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IMap;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;
import java.util.Optional;

/**
 * Created by LosLocos on 4/18/2017.
 */
public class GuardianMapping {

    private String host;
    private int port;
    private String protocol = "http";

    public void getGuardian(HazelcastInstance instance) throws MalformedURLException {
        if(host == null) {
            IMap<String, Integer> guardians = instance.getMap("GUARDIANS_REST");
            Optional<Map.Entry<String, Integer>> guardian = guardians.entrySet().stream().filter(e -> {
                try {
                    return Unirest.get("http://" + e.getKey() + ":" + e.getValue() + "/PING").asString().getBody().equals("PONG");
                } catch (UnirestException e1) {
                    e1.printStackTrace();
                }
                return false;
            }).findFirst();
            if (guardian.isPresent()) {
                this.host = guardian.get().getKey();
                this.port = guardian.get().getValue();
            }
        }
    }

    public URL setupSubscription(String entity){
        return setupRequest("/subscribe/" + entity);
    }

    public URL setupRequest(String file){
        try {
            return new URL(protocol ,host , port, file);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public URL setupPublish(String entity){

    }
}
