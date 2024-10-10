package org.hbrs.se1.ws24.exercises.uebung1.control;

import java.util.HashMap;
import java.util.Map;

public class GermanTranslator implements Translator {

	public String date = "Okt/2024"; // Default-Wert

	/**
	 * Methode zur Übersetzung einer Zahl in eine String-Repraesentation
	 */
	public String translateNumber( int number ) {
		Map<Integer, String> zahlenZehnMap = new HashMap<>();

		zahlenZehnMap.put(1, "eins");
		zahlenZehnMap.put(2, "zwei");
		zahlenZehnMap.put(3, "drei");
		zahlenZehnMap.put(4, "vier");
		zahlenZehnMap.put(5, "fünf");
		zahlenZehnMap.put(6, "sechs");
		zahlenZehnMap.put(7, "sieben");
		zahlenZehnMap.put(8, "acht");
		zahlenZehnMap.put(9, "neun");
		zahlenZehnMap.put(10, "zehn");

		String stringResult = zahlenZehnMap.get(number);
		if (stringResult == null) {
			return "Übersetzung der Zahl " + number+ " nicht möglich. ["+Translator.version+"]";
		} else {
			return stringResult;
		}

    }
	/**
	 * Objektmethode der Klasse GermanTranslator zur Ausgabe einer Info.
	 */
	public void printInfo(){
		System.out.println( "GermanTranslator v1.9, erzeugt am " + this.date );
	}

	/**
	 * Setzen des Datums, wann der Uebersetzer erzeugt wurde (Format: Monat/Jahr (Beispiel: "Okt/2024"))
	 * Das Datum sollte system-intern durch eine Factory-Klasse gesetzt werden und nicht von externen View-Klassen
	 */
	public void setDate( String date ) {
		this.date = date;
	}

}
