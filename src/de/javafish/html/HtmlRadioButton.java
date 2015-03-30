package de.javafish.html;

import de.javafish.html.tags.*;

public class HtmlRadioButton extends Html {

    private HtmlRadioButton() {
        tag = new HtmlTagInput();
        tag.addAttribute("type", "radio");
    }
    
    public HtmlRadioButton(String name, String value, boolean checked) {
        this();
        tag.addAttribute("name", name);
        tag.addAttribute("value", value);
        if (checked) {
            tag.addAttribute("checked");
        }
    }

    public HtmlRadioButton(String name, String value) {
        this(name, value, false);
    }
}

