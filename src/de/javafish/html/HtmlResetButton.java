package de.javafish.html;

import de.javafish.html.tags.*;

public class HtmlResetButton extends Html {

    public HtmlResetButton() {
        tag = new HtmlTagInput();
        tag.addAttribute("type", "reset");
    }
    
    public HtmlResetButton(String name, String label) {
        this();
        tag.addAttribute("name", name);
        tag.addAttribute("value", label);
    }
}

