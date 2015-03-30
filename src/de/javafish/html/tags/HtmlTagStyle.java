package de.javafish.html.tags;

/**
 * Das HtmlTag {@literal <style>}. Markiert einen Bereich für
 * Stylesheet-Definitionen.
 *
 * @author fmk
 */
public class HtmlTagStyle extends HtmlBodyTag {

    /**
     * Erzeugt ein leeres HtmlTag.
     */
    public HtmlTagStyle() {
        super("style");
        setValidAttributes(new String[]{"media", "tytle", "type"});
    }

}
