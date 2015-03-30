package de.javafish.html.tags;

/**
 * Das HtmlTag {@literal <input>}. Erzeugt ein Formularelement, der Typ wird
 * durch die Attribute bestimmt.
 *
 * @author fmk
 */
public class HtmlTagInput extends HtmlSimpleTag {

    /**
     * Erzeugt ein leeres HtmlTag.
     */
    public HtmlTagInput() {
        super("input");
        setValidAttributes(new String[]{"accept", "accesskey", "align", "alt",
                    "checked", "disabled", "ismap", "maxlength", "name", "onblur",
                    "onchange", "onfocus", "onselect", "readonly", "size", "src",
                    "tabindex", "type", "usemap", "value"});
    }

}
