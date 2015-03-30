package de.javafish.html.tags;

/**
 * Das HtmlTag {@literal <menu>}. Markiert eine Menüliste.
 *
 * @author fmk
 */
public class HtmlTagMenu extends HtmlBodyTag {

    /**
     * Erzeugt ein leeres HtmlTag.
     */
    public HtmlTagMenu() {
        super("menu");
        setValidAttributes(new String[]{"compact"});
    }

}
