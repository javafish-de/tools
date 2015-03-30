package de.javafish.html.tags;

/**
 * Das HtmlTag {@literal <button>}. Erzeugt einen Klick-Button.
 * 
 * @author fmk
 */
public class HtmlTagButton extends HtmlBodyTag {

    /**
     * Erzeugt ein leeres HtmlTag.
     */
    public HtmlTagButton() {
        super("button");
        setValidAttributes(new String[]{"accesskey", "disabled", "name", "onblur", "onfocus", "tabindex", "type", "value"});
    }
}
