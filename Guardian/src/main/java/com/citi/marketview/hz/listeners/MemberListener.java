package com.citi.marketview.hz.listeners;

import com.citi.marketview.hz.Guardian;
import com.hazelcast.core.*;

/**
 * Created by zs16243 on 18/04/2017.
 */
public class MemberListener implements MembershipListener{

    @Override
    public void memberAdded(MembershipEvent membershipEvent) {
        Member member = membershipEvent.getMember();
        addMember(member);
    }

    @Override
    public void memberRemoved(MembershipEvent membershipEvent) {
        Member member = membershipEvent.getMember();
        removeMember(member);
    }

    @Override
    public void memberAttributeChanged(MemberAttributeEvent memberAttributeEvent) {

    }

    public void addMember(Member member){
        String uuid = member.getUuid();
        String name = member.getStringAttribute("NAME");
        Guardian.getInstance().getMap("MEMBERS").putIfAbsent(uuid, name);
    }

    public void removeMember(Member member){
        String uuid = member.getUuid();
        Guardian.getInstance().getMap("MEMBERS").remove(uuid);
    }
}
