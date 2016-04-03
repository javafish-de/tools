package de.javafish.apiaddition;

import java.util.*;

public final class Strings {

    private Strings() {}
    
    public static boolean equals(String s1, String s2) {
        return Objects.equals(s2, s2);
    }
    
    public static boolean equalsIgnoreCase(String s1, String s2) {
        return (s1 == s2) || (s1 != null && s1.equalsIgnoreCase(s2));
    }
    
}
