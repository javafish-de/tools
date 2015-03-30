package de.javafish.helper;

public class MyUtilitiy {

    public static boolean assertionEnabled() {
        boolean b = false;
        assert (b = true);
        return b;
    }

}
