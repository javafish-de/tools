package de.javafish.html;

import de.javafish.html.tags.*;

public class HtmlList extends Html {

    public HtmlList(boolean ordered) {
        tag = ordered ? new HtmlTagOl() : new HtmlTagUl();
    }

    public HtmlList() {
        this(false);
    }
    
    public void add(HtmlListItem li) {
        tag.addTag(li.getTag());
    }
    
    public void add(String item) {
        add(new HtmlListItem(item));
    }
    
    public HtmlTag getList() {
        return getTag();
    }
}
