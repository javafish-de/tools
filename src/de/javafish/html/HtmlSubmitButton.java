package de.javafish.html;

import de.javafish.html.tags.*;

public class HtmlSubmitButton extends Html {

    public HtmlSubmitButton() {
        tag = new HtmlTagInput();
        tag.addAttribute("type", "submit");
    }
    
    public HtmlSubmitButton(String name, String label) {
        this();
        tag.addAttribute("name", name);
        tag.addAttribute("value", label);
    }
}

