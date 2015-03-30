package de.javafish.html.tags;

/**
 * Das HtmlTag {@literal <ins>}. Markiert Text als eingefügt.
 *
 * @author fmk
 */
public class HtmlTagIns extends HtmlBodyTag {

    /**
     * Erzeugt ein leeres HtmlTag.
     */
    public HtmlTagIns() {
        super("ins");
        setValidAttributes(new String[]{"cite", "datetime"});
    }

}
