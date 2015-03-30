package de.javafish.html.tags;

/**
 * Das HtmlTag {@literal <form>}. Definiert ein Formular.
 * 
 * @author fmk
 */
public class HtmlTagForm extends HtmlBodyTag {

    /**
     * Erzeugt ein leeres HtmlTag.
     */
    public HtmlTagForm() {
        super("form");
        setValidAttributes(new String[]{"action", "accept", "accept-charset", "enctype", "method", "name", "onreset", "onsubmit", "target"});
    }
}
