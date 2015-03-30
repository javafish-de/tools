package de.javafish.html;

import de.javafish.html.tags.*;

public class HtmlPasswordInput extends Html {

    private HtmlPasswordInput() {
        tag = new HtmlTagInput();
        tag.addAttribute("type", "password");
    }
    
    public HtmlPasswordInput(String name, int size) {
        this();
        tag.addAttribute("name", name);
        tag.addAttribute("size", ""+size);
    }
}

