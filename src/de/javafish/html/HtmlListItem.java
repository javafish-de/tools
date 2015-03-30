package de.javafish.html;

import de.javafish.html.tags.*;

public class HtmlListItem extends Html {

    private HtmlListItem() {
        tag = new HtmlTagLi();
    }

    public HtmlListItem(String item) {
        this();
        tag.setText(item);
    }
}
