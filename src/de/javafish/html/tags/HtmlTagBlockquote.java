package de.javafish.html.tags;

/**
 * Das HtmlTag {@literal <blockquote>}. Markiert ein Zitat.
 * 
 * @author fmk
 */
public class HtmlTagBlockquote extends HtmlBodyTag {

    /**
     * Erzeugt ein leeres HtmlTag.
     */
    public HtmlTagBlockquote() {
        super("blockquote");
        setValidAttributes(new String[]{"cite"});
    }
}
