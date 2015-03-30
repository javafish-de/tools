package de.javafish.html.tags;

/**
 * Das HtmlTag {@literal <tr>}. Definiert eine Tabellenzeile.
 * 
 * @author fmk
 */
public class HtmlTagTr extends HtmlBodyTag {

    /**
     * Erzeugt ein leeres HtmlTag.
     */
    public HtmlTagTr() {
        super("tr");
        setValidAttributes(new String[]{"align", "bgcolor", "char", "charoff", "valign"});
    }
}
