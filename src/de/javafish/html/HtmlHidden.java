package de.javafish.html;

import de.javafish.html.tags.*;

public class HtmlHidden extends Html {

    private HtmlHidden() {
        tag = new HtmlTagInput();
        tag.addAttribute("type", "hidden");
    }
    
    public HtmlHidden(String name, String value) {
        this();
        tag.addAttribute("name", name);
        tag.addAttribute("value", value);
    }
    
}

