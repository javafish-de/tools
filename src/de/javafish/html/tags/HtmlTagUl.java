package de.javafish.html.tags;

/**
 * Das HtmlTag {@literal <ul>}. Markiert eine Aufzählungsliste.
 * 
 * @author fmk
 */
public class HtmlTagUl extends HtmlBodyTag {

    /**
     * Erzeugt ein leeres HtmlTag.
     */
    public HtmlTagUl() {
        super("ul");
        setValidAttributes(new String[]{"compact", "type"});
    }
}
