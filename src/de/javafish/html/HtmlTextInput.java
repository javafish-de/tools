package de.javafish.html;

import de.javafish.html.tags.*;

public class HtmlTextInput extends Html {

    private HtmlTextInput() {
        tag = new HtmlTagInput();
        tag.addAttribute("type", "text");
    }
    
    public HtmlTextInput(String name, int size) {
        this();
        tag.addAttribute("name", name);
        tag.addAttribute("size", ""+size);
    }
    
    public HtmlTextInput(String name, int size, boolean readonly) {
        this(name, size);
        if (readonly) {
            tag.addAttribute("readonly");
        }
    }
    
    public void setText(String text) {
        tag.addAttribute("value", text);
    }
}

