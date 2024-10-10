package org.hbrs.se1.ws24.exercises.uebung2;

import org.hbrs.se1.ws24.exercises.uebung2.exceptions.ContainerException;

import java.util.ArrayList;

public class Container {
    private ArrayList<Member> members = new ArrayList<>();

    private boolean containsMember(Member member) {
        return members.contains(member);
    }

    public void addMember(Member member) throws ContainerException {
        if(!containsMember(member)) {
            members.add(member);
        }else {
            throw new ContainerException("Das Member-Objekt mit der ID ["+ member.getID()+"] ist bereits vorhanden!");
        }
    }
    public String removeMember(int id) {
        for(Member member : members) {
            if(member.getID() == id) {
                members.remove(member);
                return "Das Member-Objekt mit der ID ["+ id+"] wurde gelöscht!";
            }
        }
        return "Das Member-Objekt mit der ID ["+ id+"] ist nicht vorhanden!";

    }

    public void dump() {
        for(Member member : members) {
            System.out.println(member);
        }
    }

    public int size(){
        return members.size();
    }
}