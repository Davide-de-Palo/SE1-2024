package org.hbrs.se1.ws24.exercises.uebung2;

public class ConcreteMember implements Member {
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
