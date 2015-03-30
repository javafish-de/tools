package de.javafish.html.tags;

/**
 * Das HtmlTag {@literal <li>}. Markiert einen Listeneintrag.
 * 
 * @author fmk
 */
public class HtmlTagLi extends HtmlBodyTag {

    /**
     * Erzeugt ein leeres HtmlTag.
     */
    public HtmlTagLi() {
        super("li");
        setValidAttributes(new String[]{"type", "value"});
    }
}
