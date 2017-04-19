package com.citi.marketview.hz;

import com.citi.marketview.hz.objects.MemberEntry;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.hazelcast.core.Member;
import spark.Spark;

import java.lang.reflect.Type;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by zs16243 on 18/04/2017.
 */

public class RestController {

    public static void startService(){
        Spark.port(12321);

        Spark.get("/PING",(request, response) -> "PONG");

        Spark.get("/members",(request, response) -> {
            Set<Member> members = Guardian.getInstance().getCluster().getMembers();
            Gson gson = new GsonBuilder()
                    .setPrettyPrinting()
                    .create();
            Type type = new TypeToken<Set<MemberEntry>>() {
            }.getType();
            Set<MemberEntry> mentries = null;
            try {
                mentries = members.stream().map(m -> new MemberEntry(m)).collect(Collectors.toSet());
            }catch (Exception e){
                e.printStackTrace();
            }
            return gson.toJson(mentries, type);
        });

        Spark.post("/subscribe/:entity", (request, response) -> {
            String uuid = request.body();
            return Guardian.getInstance().getMap("MAPPING").get(request.params(":entity"));
        } );
    }
}
