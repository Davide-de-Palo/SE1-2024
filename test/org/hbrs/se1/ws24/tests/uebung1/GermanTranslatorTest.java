package org.hbrs.se1.ws24.tests.uebung1;
import static org.junit.jupiter.api.Assertions.*;

import org.hbrs.se1.ws24.exercises.uebung1.control.Translator;
import org.hbrs.se1.ws24.exercises.uebung1.control.TranslatorFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GermanTranslatorTest {

    Translator translator = null;

    @BeforeEach
    public void setUp() {
        translator = TranslatorFactory.createGermanTranslator();
    }

    @Test
    public void positivTest() {
        assertEquals("eins",translator.translateNumber(1));
        assertEquals("zehn",translator.translateNumber(10));
    }
    @Test
    public void negativTest(){
        assertEquals("Übersetzung der Zahl " + -1+ " nicht möglich. [1.0]" ,translator.translateNumber(-1));
        assertEquals("Übersetzung der Zahl " + 0+ " nicht möglich. [1.0]" ,translator.translateNumber(0));
        assertEquals("Übersetzung der Zahl " + 11+ " nicht möglich. [1.0]" ,translator.translateNumber(11));
    }

}