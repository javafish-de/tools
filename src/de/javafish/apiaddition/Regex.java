package de.javafish.apiaddition;

import java.util.regex.*;

public final class Regex {

    private Regex() {
    }

    public static int stringIndexOf(String s, String regex) {
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(s);
        return m.find() ? m.start() : -1;
    }

}
