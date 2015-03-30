package de.javafish.html.tags;

/**
 * Das HtmlTag {@literal <optgroup>}. Markiert eine Gruppe von Einträgen in
 * einer Menüstruktur.
 *
 * @author fmk
 */
public class HtmlTagOptgroup extends HtmlBodyTag {

    /**
     * Erzeugt ein leeres HtmlTag.
     */
    public HtmlTagOptgroup() {
        super("optgroup");
        setValidAttributes(new String[]{"disabled", "label"});
    }

}
