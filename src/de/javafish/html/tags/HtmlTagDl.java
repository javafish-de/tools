package de.javafish.html.tags;

/**
 * Das HtmlTag {@literal <dl>}. Markiert eine Definitionsliste.
 *
 * @author fmk
 */
public class HtmlTagDl extends HtmlBodyTag {

    /**
     * Erzeugt ein leeres HtmlTag.
     */
    public HtmlTagDl() {
        super("dl");
        setValidAttributes(new String[]{"compact"});
    }

}
