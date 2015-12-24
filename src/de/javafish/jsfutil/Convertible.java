package de.javafish.jsfutil;

/**
 * Schnittstelle für konvertierbare Klassen.
 * 
 * @author fmk
 */
public interface Convertible {
    
    /**
     * Liefert einen eindeutigen String. Innerhalb eine Sammlung
     * ({@link java.util.Collection}) von gleichartigen Convertibles muss jedes
     * Objekt einen eindeutigen ID-String liefern. Typischerweise ist dies der
     * als String geformte PrimaryKey.
     * 
     * @return der eindeutige ID-String
    */
    String idString();
}
