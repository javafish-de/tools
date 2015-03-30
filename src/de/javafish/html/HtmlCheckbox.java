package de.javafish.html;

import de.javafish.html.tags.*;

/**
 * Die Klasse einer Checkbox für ein Html-Formular.
 *
 * @author fmk
 */
public class HtmlCheckbox extends Html {

    /**
     * Erzeugt das entsprechende {@code <input>}-Tag.
     */
    private HtmlCheckbox() {
        tag = new HtmlTagInput();
        tag.addAttribute("type", "checkbox");
    }

    /**
     * Erzeugt das {@code <input>}-Tag unter Verwendung der angegebenen
     * Parameter.
     *
     * @param name
     * @param value
     * @param checked
     */
    public HtmlCheckbox(String name, String value, boolean checked) {
        this();
        tag.addAttribute("name", name);
        tag.addAttribute("value", value);
        if (checked) {
            tag.addAttribute("checked");
        }
    }

    /**
     * Erzeugt das {@code <input>}-Tag unter Verwendung der angegebenen
     * Parameter.
     *
     * @param name
     * @param value
     */
    public HtmlCheckbox(String name, String value) {
        this(name, value, false);
    }

}
