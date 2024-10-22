package org.hbrs.se1.ws24.exercises.uebung3.view;

import org.hbrs.se1.ws24.exercises.uebung3.control.member.Member;

import java.util.List;

public class MemberView {
    public void dump(List<Member> liste) {
        /**Iterator<Member> iterator = liste.iterator();
         while(iterator.hasNext()) {
         Member liste = iterator.next();
         System.out.println(member);
         }
         for(Member member : liste) {
         System.out.println(member);
         }

         liste.forEach(x -> System.out.println(x));
         **/

        liste.forEach(System.out::println);
    }
}
