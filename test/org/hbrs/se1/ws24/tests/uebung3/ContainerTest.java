package org.hbrs.se1.ws24.tests.uebung3;
import org.hbrs.se1.ws24.exercises.uebung3.control.member.ConcreteMember;
import org.hbrs.se1.ws24.exercises.uebung3.control.Container;
import org.hbrs.se1.ws24.exercises.uebung3.control.member.Member;
import org.hbrs.se1.ws24.exercises.uebung3.control.exceptions.ContainerException;
import org.hbrs.se1.ws24.exercises.uebung3.persistence.PersistenceException;
import org.hbrs.se1.ws24.exercises.uebung3.persistence.PersistenceStrategyMongoDB;
import org.hbrs.se1.ws24.exercises.uebung3.persistence.PersistenceStrategyStream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ContainerTest {

    Container container = null;
    Member concreteMember = null;
    Member concreteMember2 = null;

    @BeforeEach
    public void setUp() throws ContainerException {
        container = Container.getInstance();

        //Leerer Container
        List<Member> members = container.getCurrentList();
        ArrayList<Integer> membersIDs = new ArrayList<Integer>();
        for (Member member : members) {
            membersIDs.add(member.getID());
        }
        for(Integer memberID : membersIDs){
            container.removeMember(memberID);
        }
        concreteMember = new ConcreteMember();
        concreteMember2 = new ConcreteMember();
        container.addMember(concreteMember);
        container.addMember(concreteMember2);
    }


    @Test
    public void nullTest() {
        try {
            container.store();
        } catch (Exception e){
            System.out.println(e.getMessage());
            //assertEquals(e.getMessage(),"Das Member-Objekt mit der ID [1] ist bereits vorhanden!");
            assertTrue(e instanceof PersistenceException);
        }
    }

    @Test
    public void mongoDBTest() {
        try {
            container.setPersistenceStrategy(new PersistenceStrategyMongoDB());
            container.store();
        } catch (Exception e){
            assertTrue(e instanceof UnsupportedOperationException);
        }
    }

    @Test
    public void falscheLocationTest() {
        try {
            PersistenceStrategyStream<Member> persistenceStrategy = new PersistenceStrategyStream();
            persistenceStrategy.setLocation("./test/objects.ser");
            container.setPersistenceStrategy(persistenceStrategy);
            container.store();

        }catch (Exception e){
            assertTrue(e instanceof PersistenceException);
        }
    }

    @Test
    public void roundTripTest() {
        try {
            container.setPersistenceStrategy(new PersistenceStrategyStream());
            container.store();
            assertEquals(container.size(),2);
            List<Member> members = container.getCurrentList();

            /**for(Member member : members) {
                container.removeMember(member.getID());
            }**/
            ArrayList<Integer> membersIDs = new ArrayList<Integer>();
            for (Member member : members) {
                membersIDs.add(member.getID());
            }
            for(Integer memberID : membersIDs){
                container.removeMember(memberID);
            }

            assertEquals(container.size(),0);
            container.load();
            assertEquals(container.size(),2);
            System.out.println(container.getCurrentList());
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
