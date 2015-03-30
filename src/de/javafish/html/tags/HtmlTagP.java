package de.javafish.html.tags;

/**
 * Das HtmlTag {@literal <p>}. Markiert einen Textabsatz.
 * 
 * @author fmk
 */
public class HtmlTagP extends HtmlBodyTag {

    /**
     * Erzeugt ein leeres HtmlTag.
     */
    public HtmlTagP() {
        super("p");
        setValidAttributes(new String[]{"align"});
    }
}
