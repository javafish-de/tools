package de.javafish.html.tags;

/**
 * Das HtmlTag {@literal <bdo>}. Markiert eine Änderung der Textrichtung bei
 * Sprachen mit anderer Schreibrichtung.
 *
 * @author fmk
 */
public class HtmlTagBdo extends HtmlBodyTag {

    /**
     * Erzeugt ein leeres HtmlTag.
     */
    public HtmlTagBdo() {
        super("bdo");
        setValidAttributes(new String[]{"dir"});
    }

}
