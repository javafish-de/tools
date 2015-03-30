package de.javafish.html;

import de.javafish.html.tags.*;

/**
 * Repräsentiert eine Html-Tabellenzeile. Es wird folgendes Grundgerüst von Tags
 * bereitgestellt. <p>
 * <code>
 * {@literal <tr>}{@literal </tr>}</br>
 * </code> </p> <p> Die Gestaltung der Tabellenzeile erfolgt in der Hauptsache
 * durch nachfolgende Aufrufe der add()-Methode, welche der Tabelle jeweils eine
 * Zelle hinzufügen. </p>
 *
 * @author fmk
 */
public class HtmlTableRow extends Html {

    /**
     * Erzeugt das {@code <tr>}-Tag
     */
    public HtmlTableRow() {
        tag = new HtmlTagTr();
    }

    /**
     * Fügt der Zeile die übergebene Zelle hinzu.
     * 
     * @param td 
     */
    public void add(HtmlTableData td) {
        tag.addTag(td.getTag());
    }

    /**
     * Fügt der Zeile die übergebene Zelle hinzu.
     * 
     * @param t
     */
    public void add(HtmlTag t) {
        add(t, 1);
    }

    /**
     * Fügt der Zeile die übergebene Zelle hinzu.
     * 
     * @param t
     */
    public void add(HtmlTag t, int colspan) {
        add(t.getTagString(), colspan);
    }

    /**
     * Fügt der Zeile eine Zelle mit dem übergebenen Text hinzu.
     * 
     * @param text 
     */
    public void add(String text) {
        add(text, 1);
    }
    
    /**
     * Fügt der Zeile eine Zelle mit dem übergebenen Text hinzu.
     * 
     * @param text 
     */
    public void add(String text, int colspan) {
        tag.addTag(new HtmlTableData(text, colspan).getTag());
    }
    
    public void addHead(String text) {
        HtmlTag t = new HtmlTagTh();
        t.setText(text);
        tag.addTag(t);
    }
}
