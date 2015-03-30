package de.javafish.html.tags;

/**
 * Das HtmlTag {@literal <font>}. Markiert Text mit Schriftgröße, Schriftfarbe
 * und Schriftart.
 *
 * @author fmk
 */
public class HtmlTagFont extends HtmlBodyTag {

    /**
     * Erzeugt ein leeres HtmlTag.
     */
    public HtmlTagFont() {
        super("font");
        setValidAttributes(new String[]{"color", "face", "size"});
    }

}
