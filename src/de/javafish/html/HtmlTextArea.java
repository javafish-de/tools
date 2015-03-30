package de.javafish.html;

import de.javafish.html.tags.*;

public class HtmlTextArea extends Html {

    private HtmlTextArea() {
        tag = new HtmlTagTextarea();
    }
    
    public HtmlTextArea(String name, int cols, int rows) {
        this();
        tag.addAttribute("name", name);
        tag.addAttribute("cols", ""+cols);
        tag.addAttribute("rows", ""+rows);
    }
}

