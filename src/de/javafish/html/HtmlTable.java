package de.javafish.html;

import de.javafish.html.tags.*;

/**
 * Repräsentiert eine Html-Tabelle. Es wird folgendes Grundgerüst von Tags
 * bereitgestellt. <p>
 * <code>
 * {@literal <table>}{@literal </table>}</br>
 * </code> </p> <p> Die Gestaltung der Tabelle erfolgt in der Hauptsache durch
 * nachfolgende Aufrufe der addRow()-Methode, welche der Tabelle jeweils eine
 * Zeile hinzufügen. </p>
 *
 * @author fmk
 */
public class HtmlTable extends Html {

    /**
     * Erzeugt das {@code <table>}-Tag.
     */
    public HtmlTable() {
        tag = new HtmlTagTable();
    }

    /**
     * Fügt der Tabelle eine Zeile hinzu.
     * 
     * @param row 
     */
    public void addRow(HtmlTableRow row) {
        tag.addTag(row.getTag());
    }

    /**
     * Liefert die Tabelle als HtmlTag.
     * @return die Tabelle als HtmlTag
     */
    public HtmlTag getTable() {
        return getTag();
    }
}
