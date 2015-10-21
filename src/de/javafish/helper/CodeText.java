package de.javafish.helper;

import java.security.*;

public final class CodeText {

    private CodeText() {
    }
    
    public static String getCode(String text) {
        return getCode(text.getBytes());
    }

//    public static String getCode(char[] text) {
//        
////        StringCoding.encode(text, 0, text.length);
//        
//        byte by;
////        List<Byte> bytes = new ArrayList<>();
//        byte[] b;           // the byte-Array for the given text
//
//        // convert the char-Array into a byte-Array, consider a char is two byte
//        b = new byte[text.length << 1];
//        
//        for (int i = 0; i < text.length; i++) {
//            byte bpos = (byte) (i << 1);
//
//            b[bpos] = (byte) ((text[i] & 0xFF00) >> 8);
//            b[bpos+1] = (byte) (text[i] & 0x00FF);
//            
////            if ((by = (byte) ((text[i] & 0xFF00) >> 8)) != 0) {
////                bytes.add(by);
////            }
////            
////            if ((by = (byte) (text[i] & 0x00FF)) != 0) {
////                bytes.add(by);
////            }
//        }
//        
//        return getCode(b);
//    }

    public static String getCode(byte[] ba) {
        
        System.out.println(ba.length);
        
        String s = "";      // the resulting hex-String
        MessageDigest md;   // the MessageDigest
        byte[] d;           // the resulting byte-Array
        
        // get the code
        try {
            // create a MessageDigest
            md = MessageDigest.getInstance("SHA-256");
            
            // send the text (as a byte-Array) to the Digest
            md.update(ba);
            
            // get the hash-code as a byte-Array
            d = md.digest();

            // convert the resulting byte-Array to a String
            for (byte b : d) {
                s += String.format("%02x", b);
            }
        } catch (NoSuchAlgorithmException ex) {
            System.out.println(ex);
        }

        return s;
    }
    
    public static void main(String[] args) {
        String pw = "password3";
        System.out.println(CodeText.getCode(pw));
//        System.out.println(CodeText.getCode(pw.toCharArray()));
        System.out.println(CodeText.getCode(pw.getBytes()));
    }
}

/*
 * char ch;  2 Byte - 16 Bit
 * byte by1, by2;  1 Byte -  8 Bit
 * by1 = (ch & 0xFF00) >> 8;
 * by2 = ch & 0x00FF;
 */