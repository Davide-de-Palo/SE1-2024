package org.hbrs.se1.ws24.exercises.uebung1.control;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class TranslatorFactory {

    public static Translator createGermanTranslator() {
        String aktuellerMonatAlsString = LocalDate.now().format(DateTimeFormatter.ofPattern("MMMM"));

        GermanTranslator gt = new GermanTranslator();
        gt.setDate(aktuellerMonatAlsString);
        return gt;
    }

}
