package de.javafish.helper;

import java.awt.*;
import java.net.*;
import javax.swing.*;

public class JLink extends JLabel {

    private URI target;
    
    private Font underlined;
    private Font notUnderlined;
    
    public JLink() {
    }

    public JLink(Icon image) {
        super(image);
    }

    public JLink(String text) {
        super(text);
    }

    @Override
    public void setFont(Font font) {
        super.setFont(font);
        notUnderlined = font;
    }

    
}
