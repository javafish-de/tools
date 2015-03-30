package de.javafish.html.tags;

/**
 * Das HtmlTag {@literal <tbody>}. Bestimmt in einer Tabelle den Tabellenkörper.
 *
 * @author fmk
 */
public class HtmlTagTbody extends HtmlBodyTag {

    /**
     * Erzeugt ein leeres HtmlTag.
     */
    public HtmlTagTbody() {
        super("tbody");
        setValidAttributes(new String[]{"align", "char", "charoff", "valign"});
    }

}
