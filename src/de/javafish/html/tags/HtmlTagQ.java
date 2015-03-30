package de.javafish.html.tags;

/**
 * Das HtmlTag {@literal <q>}. Markiert ein Zitat.
 *
 * @author fmk
 */
public class HtmlTagQ extends HtmlBodyTag {

    /**
     * Erzeugt ein leeres HtmlTag.
     */
    public HtmlTagQ() {
        super("q");
        setValidAttributes(new String[]{"cite"});
    }

}
