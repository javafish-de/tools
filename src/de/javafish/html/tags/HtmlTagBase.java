package de.javafish.html.tags;

/**
 * Das HtmlTag {@literal <base>}. Definiert dokumentweit gültige Angabe für
 * Basis-URI und Zielfenster von Verweisen.
 *
 * @author fmk
 */
public class HtmlTagBase extends HtmlSimpleTag {

    /**
     * Erzeugt ein leeres HtmlTag.
     */
    public HtmlTagBase() {
        super("base");
        setValidAttributes(new String[]{"href", "target"});
    }

}
