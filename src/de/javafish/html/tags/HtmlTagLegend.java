package de.javafish.html.tags;

/**
 * Das HtmlTag {@literal <legend>}. Definiert eine Überschrift für eine Gruppe
 * von Formularelementen.
 *
 * @author fmk
 */
public class HtmlTagLegend extends HtmlBodyTag {

    /**
     * Erzeugt ein leeres HtmlTag.
     */
    public HtmlTagLegend() {
        super("legend");
        setValidAttributes(new String[]{"accesskey", "align"});
    }

}
