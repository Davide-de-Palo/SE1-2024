package org.hbrs.se1.ws24.tests.uebung2;
import org.hbrs.se1.ws24.exercises.uebung2.ConcreteMember;
import org.hbrs.se1.ws24.exercises.uebung2.Container;
import org.hbrs.se1.ws24.exercises.uebung2.Member;
import org.hbrs.se1.ws24.exercises.uebung2.exceptions.ContainerException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ContainerTest {

    Container container = null;
    Member concreteMember = null;
    Member concreteMember2 = null;

    @BeforeEach
    public void setUp() {
        container = new Container();
        concreteMember = new ConcreteMember();
        concreteMember2 = new ConcreteMember();
    }


    @Test
    public void containerTest() {
        try {
            //Hinzufügen (pos)
            container.addMember(concreteMember);
            container.addMember(concreteMember2);
            //Ausgeben (pos)
            container.dump();
            //Größe (pos)
            assertEquals(container.size(),2);
            //Löschen (pos)
            assertEquals(container.removeMember(0),"Das Member-Objekt mit der ID [0] wurde gelöscht!");
            container.dump();
            assertEquals(container.size(),1);

            try {
                container.addMember(concreteMember2);
            } catch (Exception e){
                //assertEquals(e.getMessage(),"Das Member-Objekt mit der ID [1] ist bereits vorhanden!");
                assertTrue(e instanceof ContainerException);
            }

            //Doppelt hinzufügen (neg)
            assertThrows(ContainerException.class, () -> {
                // Der Code, der die Exception werfen soll
                container.addMember(concreteMember2);
            });
            //Nicht vorhandenes Löschen (neg)
            assertEquals(container.removeMember(2),"Das Member-Objekt mit der ID [2] ist nicht vorhanden!");
            //Negative ID löschen (neg)
            assertEquals(container.removeMember(-1),"Das Member-Objekt mit der ID [-1] ist nicht vorhanden!");

        } catch (ContainerException e) {
            e.printStackTrace();
        }



    }


}
