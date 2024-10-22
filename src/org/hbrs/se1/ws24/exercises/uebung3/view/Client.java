package org.hbrs.se1.ws24.exercises.uebung3.view;

import org.hbrs.se1.ws24.exercises.uebung3.control.exceptions.ContainerException;
import org.hbrs.se1.ws24.exercises.uebung3.control.member.ConcreteMember;
import org.hbrs.se1.ws24.exercises.uebung3.control.Container;
import org.hbrs.se1.ws24.exercises.uebung3.control.member.Member;
import org.hbrs.se1.ws24.exercises.uebung3.persistence.PersistenceException;

import java.io.IOException;

public class Client {
    public static void start() throws ContainerException, PersistenceException, IOException, ClassNotFoundException {
        Container container = Container.getInstance();
        /**Member member = new ConcreteMember();
        Member member2 = new ConcreteMember();

        container.addMember(member);
        container.addMember(member2);**/
        container.load();
        MemberView memberView = new MemberView();
        memberView.dump(container.getCurrentList());
        Member member = new ConcreteMember();
        container.addMember(member);
        //container.addMember(member);
        container.store();
    }
}
