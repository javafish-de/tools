package de.javafish.html.tags;

/**
 * Das HtmlTag {@literal <ol>}. Markiert eine nummerierte Liste.
 * 
 * @author fmk
 */
public class HtmlTagOl extends HtmlBodyTag {

    /**
     * Erzeugt ein leeres HtmlTag.
     */
    public HtmlTagOl() {
        super("ol");
        setValidAttributes(new String[]{"compact", "start", "type"});
    }
}
