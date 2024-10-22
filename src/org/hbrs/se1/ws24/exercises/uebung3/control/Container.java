package org.hbrs.se1.ws24.exercises.uebung3.control;

import org.hbrs.se1.ws24.exercises.uebung3.control.exceptions.ContainerException;
import org.hbrs.se1.ws24.exercises.uebung3.control.member.Member;
import org.hbrs.se1.ws24.exercises.uebung3.persistence.PersistenceException;
import org.hbrs.se1.ws24.exercises.uebung3.persistence.PersistenceStrategy;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Container{
    private static Container containerInstance = null;
    private ArrayList<Member> container = new ArrayList<>();
    private PersistenceStrategy persistenceStrategy = null;

    private Container(){}

    public static Container getInstance(){
        if(containerInstance == null){
            containerInstance = new Container();
        }
        return containerInstance;
    }

    public void addMember(Member member) throws ContainerException {
        if(!container.contains(member)) {
            container.add(member);
        }else {
            throw new ContainerException("Das Member-Objekt mit der ID ["+ member.getID()+"] ist bereits vorhanden!");
        }
    }
    public String removeMember(int id) {
        for(Member member : container) {
            if(member.getID() == id) {
                container.remove(member);
                return "Das Member-Objekt mit der ID ["+ id+"] wurde gelöscht!";
            }
        }
        return "Das Member-Objekt mit der ID ["+ id+"] ist nicht vorhanden!";
    }
    public void setPersistenceStrategy(PersistenceStrategy persistenceStrategy) {
        this.persistenceStrategy = persistenceStrategy;
    }
    public List<Member> getCurrentList(){
        return container;
    }
    public void store() throws PersistenceException, IOException {
        if(persistenceStrategy == null){
            throw new PersistenceException(PersistenceException.ExceptionType.NoStrategyIsSet,"Es wurde keine Strategie gesetzt.");
        }
        persistenceStrategy.save(getCurrentList());
    }

    public void load() throws PersistenceException, IOException, ClassNotFoundException {
        if(persistenceStrategy == null){
            throw new PersistenceException(PersistenceException.ExceptionType.NoStrategyIsSet,"Es wurde keine Strategie gesetzt.");
        }
        container = (ArrayList<Member>) persistenceStrategy.load();
    }

    public void dump() {

    }

    public int size(){
        return container.size();
    }
}
