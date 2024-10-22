package org.hbrs.se1.ws24.exercises.uebung3.control.member;

import java.io.Serializable;

public class ConcreteMember implements Member, Serializable {
    private static int memberCreated = 0;
    private int id;

    public ConcreteMember() {
        id = memberCreated++;
    }
    @Override
    public Integer getID() {
        return this.id;
    }
    public String toString() {
        return "Member (ID = " + id + ")";
    }
}
