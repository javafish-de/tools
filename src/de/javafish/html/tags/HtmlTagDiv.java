package de.javafish.html.tags;

/**
 * Das HtmlTag {@literal <div>}. Markiert einen allgemeinen Bereich.
 * 
 * @author fmk
 */
public class HtmlTagDiv extends HtmlBodyTag {

    /**
     * Erzeugt ein leeres HtmlTag.
     */
    public HtmlTagDiv() {
        super("div");
        setValidAttributes(new String[]{"align"});
    }
}
