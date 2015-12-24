package de.javafish.jsfutil;

import java.util.*;
import javax.faces.component.*;
import javax.faces.context.*;
import javax.faces.convert.*;

/**
 * Generische {@link javax.faces.convert.Converter}-Implementierung.
 * Der generische Konverter führt eine Liste von Elementen des zu 
 * konvertierenden Typs - diese müssen {@link Convertible} sein. In der
 * konkreten Kindklasse muss die abstrakte Methode {@link GenericConverter#getItems()}
 * implementiert werden, welche die Liste dieser Elemente liefert. 
 * <p>
 * Beispiel einer typischen Implementierung:
 * 
 * <pre>
 * class Book implements Convertible {
 *     private long isbn;
 *     // some more attributes
 *    {@literal @Override}
 *     public String idString() {
 *         return ""+isbn;
 *     }
 *     // some more Book stuff
 * }
 * 
 * class BookConverter extends GenericConverter&lt;Book&gt; {
 *     MyConverter() {
 *         items();
 *     }
 *    {@literal @Override}
 *     protected List&lt;Book&gt; getItems() {
 *         return // eine Liste mit Book Objekten
 *     }
 * }
 * </pre>
 * 
 * @author fmk
 * @param <T> der zu konvertierende Typ muss {@link Convertible} implementieren
 */
public abstract class GenericConverter<T extends Convertible> implements Converter {

    private List<T> items;

    /**
     * Setzt die Liste der zu konvertierenden Objekte. Sollte im
     * Konstruktor der konkreten Kindklasse angerufen werden.
     */
    protected void items() {
        items = getItems();
    }

    /**
     * Die Liste der von diesem Konverter zu konvertierenden Objekte.
     * 
     * @return List
     */
    protected abstract List<T> getItems();
    
    /**
     * Sucht mit einem übergebenen String nach dem dazugehörigen Objekt. Dieses
     * Objekt muss {@link Convertible} sein und wird über das Ergebnis der
     * {@link Convertible#idString()}-Methode identifiziert.
     * 
     * @see javax.faces.convert.Converter
     * @param context FacesContext
     * @param component UIComponent
     * @param value String
     * @return das zum value passende Objekt
     */
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        return items.stream().filter((item) -> (item.idString().equals(value))).findFirst().orElse(null);
    }

    /**
     * Liefert von einem übergebenen Objekt den eindeutigen ID-String. Zuvor
     * wird geprüft, ob es sich bei value wirklich um ein konvertierbares Objekt
     * handelt.
     * 
     * @see javax.faces.convert.Converter
     * @param context FacesContext
     * @param component UIComponent
     * @param value ein {@link Convertible}
     * @return der zum value gehörende String, oder {@code null} falls value
     * nicht {@link Convertible} ist.
     */
    @Override
    @SuppressWarnings("unchecked")
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (!(value instanceof Convertible)) {
            return null;
        }
        return getAsString((T) value);
    }
    
    /**
     * Liefert den eindeutigen ID-String des übergebenen Objektes.
     * 
     * @param value ein {@link Convertible}
     * @return der zum value gehörende String
     */
    private String getAsString(T value) {
        return value.idString();
    }
}
