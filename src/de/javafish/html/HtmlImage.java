package de.javafish.html;

import de.javafish.html.tags.*;

public class HtmlImage extends Html {

    private HtmlImage() {
        tag = new HtmlTagImg();
    }
    
    public HtmlImage(String source, String alt) {
        this();
        tag.addAttribute("src", source);
        tag.addAttribute("alt", alt);
    }
    
    public void setAlignment(HtmlAlignment a) {
        tag.addAttribute("align", a.toString());
    }
}

