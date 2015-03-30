package de.javafish.html.tags;

/**
 * Das HtmlTag {@literal <textarea>}. Definiert ein mehrzeiliges Eingabefeld.
 * 
 * @author fmk
 */
public class HtmlTagTextarea extends HtmlBodyTag {

    /**
     * Erzeugt ein leeres HtmlTag.
     */
    public HtmlTagTextarea() {
        super("textarea");
        setValidAttributes(new String[]{"accesskey", "cols", "disabled", "name", "onblur",
            "onchange", "onfocus", "onselect", "readonly", "rows", "tabindex"});
    }
}
