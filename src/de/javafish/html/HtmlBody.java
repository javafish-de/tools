package de.javafish.html;

import de.javafish.html.tags.*;

/**
 * Repräsentiert den Rumpf einer Html-Seite. Es wird folgendes Grundgerüst
 * von Tags bereitgestellt. <p>
 * <code>
 * {@literal <body>}{@literal </body>}<br />
 * </code> </p> <p> Die Gestaltung des Rumpfes erfolgt in der Hauptsache durch
 * nachfolgende Aufrufe der add()-Methode, welche Html-Elemente aufnimmt und der
 * Seite hinzufügt. </p>
 *
 * @author fmk
 */
public class HtmlBody extends HtmlContainer {


    /**
     * Erzeugt einen leeren Body.
     */
    public HtmlBody() {
        tag = new HtmlTagBody();
    }

}