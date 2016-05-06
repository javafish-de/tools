package de.javafish.html;

public class TestHtml {

    private final HtmlPage page = new HtmlPage("Eigene Webseite");
    
    public static void main(String[] args) {
        new TestHtml().go();
    }
    
    private void go() {
        
        HtmlTable table = new HtmlTable();
        
        HtmlTableRow row = new HtmlTableRow();
        row.add("a1");
        row.add("a2");
        row.add("a3");
        row.add("a4");
        row.add("a5");
        table.addRow(row);
        
        row = new HtmlTableRow();
        row.add("b1");
        row.add("b2");
        row.add("b3");
        row.add("b4");
        row.add("b5");
        table.addRow(row);
        
        HtmlList list = new HtmlList();
        list.add("Eintrag 1");
        list.add("Eintrag 2");
        list.add("Eintrag 3");
        list.add("Eintrag 4");
        
        HtmlList list2 = new HtmlList(true);
        list2.add("Eintrag 1");
        list2.add("Eintrag 2");
        list2.add("Eintrag 3");
        list2.add("Eintrag 4");
        
        HtmlForm form = new HtmlForm("meineform", "index.jsp");
        form.addText("Vorname");
        form.addTextInput("vorname", 20);
        form.addNewline();
        
        form.addText("Kennwort");
        form.addPasswordInput("kennwort", 20);
        form.addNewline();
        
        form.addCheckbox("checky", "Bitte ankreuzen");
        form.addNewline();
        
        form.addRadioButtons("radios", 0, "Selection 1", "Selektion 2", "Selektion 3");
        form.addNewline();

        form.addSubmitButton("absenden", "Absenden");
        
        page.addHeadline2("Überschrift");
        page.addTable(table);
        page.addNewline();
        page.addHR();
        page.addLink("http://localhost", "hier");
        page.add(" das ist reiner Text");
        page.addList(list);
        page.addList(list2);
        page.addForm(form);
        
        System.out.println(page);
    }
}
