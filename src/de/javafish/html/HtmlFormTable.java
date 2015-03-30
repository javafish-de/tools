package de.javafish.html;

/**
 * Kovienience-Klasse zur Erzeugung eines Formulars innerhlab einer Tabelle.
 * 
 * @author fmk
 */
public class HtmlFormTable extends HtmlForm {

    HtmlTable table;

    public HtmlFormTable(String name, String action) {
        this(name, action, false);
    }

    public HtmlFormTable(String name, String action, boolean getMethod) {
        super(name, action, getMethod);
        table = new HtmlTable();
        this.add(table.getTable());
    }

    public void addTextInput(String label, String name, int size) {
        addTextInput(label, name, size, "");
    }
    
    public void addTextInput(String label, String name, int size, String value) {
        addTextInput(label, name, size, value, false);
    }
    
    public void addTextOutput(String label, String name, int size, String value) {
        addTextInput(label, name, size, value, true);
    }
    
    private void addTextInput(String label, String name, int size, String value, boolean readonly) {
        HtmlTableRow row = new HtmlTableRow();
        row.add(label);
        HtmlTextInput ti = new HtmlTextInput(name, size, readonly);
        ti.setText(value);
        row.add(ti.getTag());
        table.addRow(row);
    }

    public void addPasswordInput(String label, String name, int size) {
        HtmlTableRow row = new HtmlTableRow();
        row.add(label);
        HtmlPasswordInput pi = new HtmlPasswordInput(name, size);
        row.add(pi.getTag());
        table.addRow(row);
    }
    
    @Override
    public void addText(String text) {
        HtmlTableRow row = new HtmlTableRow();
        row.add(text, 2);
        table.addRow(row);
    }
    
    public void addLink(String url, String text) {
        HtmlTableRow row = new HtmlTableRow();
        row.add(new HtmlLink(url, text).getTag(), 2);
        table.addRow(row);
    }
    
    @Override
    public void addSubmitButton(String name, String value) {
        HtmlTableRow row = new HtmlTableRow();
        row.add("");
        row.add(new HtmlSubmitButton(name, value).getTag());
        table.addRow(row);
    }

    public void addSubmitButton(String label, String name, String value) {
        HtmlTableRow row = new HtmlTableRow();
        row.add(label, 2);
        row.add(new HtmlSubmitButton(name, value).getTag());
        table.addRow(row);
    }
    
//    add
}
