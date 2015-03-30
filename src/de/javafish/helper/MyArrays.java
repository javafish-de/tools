package de.javafish.helper;

/**
 * Utility-Klasse mit Methoden, die von den API-Entwicklern vergessen wurden.
 * 
 * @author fmk
 */
public final class MyArrays {

    private MyArrays() {
    }
    
    public static Byte[] boxArray(byte[] ba) {
        Byte[] bArray = new Byte[ba.length];
        for (int i = 0; i < ba.length; i++) {
            bArray[i] = ba[i];
        }
        return bArray;
    }

    public static Short[] boxArray(short[] sa) {
        Short[] sArray = new Short[sa.length];
        for (int i = 0; i < sa.length; i++) {
            sArray[i] = sa[i];
        }
        return sArray;
    }

    public static Integer[] boxArray(int[] ia) {
        Integer[] iArray = new Integer[ia.length];
        for (int i = 0; i < ia.length; i++) {
            iArray[i] = ia[i];
        }
        return iArray;
    }

    public static Long[] boxArray(long[] la) {
        Long[] lArray = new Long[la.length];
        for (int i = 0; i < la.length; i++) {
            lArray[i] = la[i];
        }
        return lArray;
    }

    public static Float[] boxArray(float[] fa) {
        Float[] fArray = new Float[fa.length];
        for (int i = 0; i < fa.length; i++) {
            fArray[i] = fa[i];
        }
        return fArray;
    }

    public static Double[] boxArray(double[] da) {
        Double[] dArray = new Double[da.length];
        for (int i = 0; i < da.length; i++) {
            dArray[i] = da[i];
        }
        return dArray;
    }

    public static Character[] boxArray(char[] ca) {
        Character[] chArray = new Character[ca.length];
        for (int i = 0; i < ca.length; i++) {
            chArray[i] = ca[i];
        }
        return chArray;
    }

    public static Boolean[] boxArray(boolean[] ba) {
        Boolean[] bArray = new Boolean[ba.length];
        for (int i = 0; i < ba.length; i++) {
            bArray[i] = ba[i];
        }
        return bArray;
    }
}
