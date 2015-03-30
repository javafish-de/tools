package de.javafish.helper;

/**
 * Repräsentiert eine physikalische Netzwerkadresse (MAC-Adresse). Der
 * Konstruktor nimmt ein Byte-Array von NetworkInterface.getHardwareAdress()
 * entgegen. Die toString()-Methode formt die Adresse in die klassische Form von
 * 6 durch Doppelpunkt getrennte Hex-Bytes.
 * @author fmk
 */
public class HardwareAddress {

    private final byte[] mac;
    
    public HardwareAddress(byte[] mac) {
        this.mac = mac;
    }

    /**
     * 
     * @return Die physikalische Netzwerkadresse als String. 
     */
    @Override
    public String toString() {
        
        if (mac == null) return null;
        
        StringBuilder sb = new StringBuilder();
        for (byte b : mac) {
            sb.append(String.format("%02X", b)).append(":");
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }
}
