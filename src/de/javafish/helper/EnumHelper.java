package de.javafish.helper;

/**
 *
 * @author fmk
 */
public class EnumHelper {

    public static <T extends Enum> String getProperName(T t) {
        String s = "";
        for (String es : t.name().split("_")) {
            s += es.substring(0, 1).toUpperCase();
            s += es.substring(1).toLowerCase();
            s += " ";
        }
        return s.substring(0, s.length() - 1);
    }
}
