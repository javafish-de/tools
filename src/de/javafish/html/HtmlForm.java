package de.javafish.html;

import de.javafish.html.tags.*;

/**
 * Repräsentiert ein Html-Formular. Es wird folgendes Grundgerüst von Tags
 * bereitgestellt. <p>
 * <code>
 * {@literal <form name="name" action="action">}{@literal </form>}</br>
 * </code> </p> <p> Die Gestaltung des Formulars erfolgt in der Hauptsache durch
 * nachfolgende Aufrufe der add()-Methode, welche die Formular-Elemente aufnimmt
 * und dem Formular hinzufügt. </p>
 *
 * @author fmk
 */
public class HtmlForm extends Html {

    /**
     * Erzeugt ein Html-Formular.
     *
     * @param name
     * @param action
     */
    public HtmlForm(String name, String action) {
        this(name, action, false);
    }

    /**
     * Erzeugt ein Html-Formular.
     *
     * @param name
     * @param action
     * @param getMethod
     */
    public HtmlForm(String name, String action, boolean getMethod) {
        tag = new HtmlTagForm();
        tag.addAttribute("name", name);
        tag.addAttribute("action", action);
        if (getMethod) {
            tag.addAttribute("method", "get");
        } else {
            tag.addAttribute("method", "post");
        }
    }

    public void add(HtmlTag tag) {
        this.tag.addTag(tag);
    }

    public void add(HtmlTextInput t) {
        add(t.getTag());
    }

    public void add(HtmlTextArea t) {
        add(t.getTag());
    }

    public void add(HtmlPasswordInput t) {
        add(t.getTag());
    }

    public void add(HtmlSubmitButton t) {
        add(t.getTag());
    }

    public void add(HtmlResetButton t) {
        add(t.getTag());
    }

    public void add(HtmlCheckbox t) {
        add(t.getTag());
    }

    public void add(HtmlRadioButton t) {
        add(t.getTag());
    }

    public void add(HtmlHidden t) {
        add(t.getTag());
    }

    public void add(String text) {
        add(new HtmlTagText(text));
    }

    public void addTextInput(String name, int size) {
        add(new HtmlTextInput(name, size));
    }

    public void addTextArea(String name, int cols, int rows) {
        add(new HtmlTextArea(name, cols, rows));
    }

    public void addPasswordInput(String name, int size) {
        add(new HtmlPasswordInput(name, size));
    }

    public void addSubmitButton(String name, String label) {
        add(new HtmlSubmitButton(name, label));
    }

    public void addResetButton(String name, String label) {
        add(new HtmlResetButton(name, label));
    }

    public void addCheckbox(String name, String value, boolean checked) {
        add(new HtmlCheckbox(name, value, checked));
        add(value);
        addNewline();
    }

    public void addCheckbox(String name, String value) {
        addCheckbox(name, value, false);
    }

    public void addRadioButton(String name, String value, boolean checked) {
        add(new HtmlRadioButton(name, value, checked));
        add(value);
        addNewline();
    }

    public void addRadioButton(String name, String value) {
        addRadioButton(name, value, false);
    }

    public void addRadioButtons(String name, int selected, String... values) {
        for (int i = 0; i < values.length; i++) {
            if (i == selected) {
                addRadioButton(name, values[i], true);
            } else {
                addRadioButton(name, values[i]);
            }
        }
    }

    public void addHidden(String name, String value) {
        add(new HtmlHidden(name, value));
    }

    public void addText(String text) {
        add(text);
    }

    public void addNewline() {
        add(HtmlPage.BR);
    }

    public HtmlTag getForm() {
        return getTag();
    }

}
