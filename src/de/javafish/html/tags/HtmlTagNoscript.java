package de.javafish.html.tags;

/**
 * Das HtmlTag {@literal <noscript>}. Markiert einen Bereich für den Fall, dass
 * ein Script nicht ausgeführt werden kann.
 *
 * @author fmk
 */
public class HtmlTagNoscript extends HtmlBodyTag {

    /**
     * Erzeugt ein leeres HtmlTag.
     */
    public HtmlTagNoscript() {
        super("noscript");
        // No more Attributes
    }

}
