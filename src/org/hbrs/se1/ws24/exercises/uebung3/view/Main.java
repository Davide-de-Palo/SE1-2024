package org.hbrs.se1.ws24.exercises.uebung3.view;

import org.hbrs.se1.ws24.exercises.uebung3.control.Container;
import org.hbrs.se1.ws24.exercises.uebung3.control.exceptions.ContainerException;
import org.hbrs.se1.ws24.exercises.uebung3.persistence.PersistenceException;
import org.hbrs.se1.ws24.exercises.uebung3.persistence.PersistenceStrategyStream;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws ContainerException, PersistenceException, IOException, ClassNotFoundException {
        Container.getInstance().setPersistenceStrategy(new PersistenceStrategyStream());
        Client.start();

    }
}
