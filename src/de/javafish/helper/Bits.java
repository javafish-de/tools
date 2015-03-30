package de.javafish.helper;

/**
 * Utility-Klasse zum setzen, löschen und prüfen gezielter Bits im int.
 *
 * @author fmk
 */
public final class Bits {

    private Bits() {
    }

    /**
     * Setzt im int number das Bit an Position pos in Abhängigkeit von set.
     *
     * @param number
     * @param pos
     * @param set
     * @return
     */
    public static int setBit(int number, int pos, boolean set) {
        if (set) {
            return setBit(number, pos);
        } else {
            return clearBit(number, pos);
        }
    }

    /**
     * Setzt im int number das/die durch mask angegebenen Bit(s) in Abhängigkeit
     * von set.
     *
     * @param number
     * @param mask
     * @param set
     * @return
     */
    public static int setBitMask(int number, int mask, boolean set) {
        if (set) {
            return setBitMask(number, mask);
        } else {
            return clearBitMask(number, mask);
        }
    }

    /**
     * Setzt im int number das Bit an Position pos auf 1.
     *
     * @param number
     * @param pos
     * @return
     */
    public static int setBit(int number, int pos) {
        return setBitMask(number, (1 << pos));
    }

    /**
     * Setzt im int number das/die durch mask angegebenen Bit(s) auf 1.
     *
     * @param number
     * @param mask
     * @return
     */
    public static int setBitMask(int number, int mask) {
        return number | mask;
    }

    /**
     * Setzt im int number das Bit an Position pos auf 0.
     *
     * @param number
     * @param pos
     * @return
     */
    public static int clearBit(int number, int pos) {
        return clearBitMask(number, (1 << pos));
    }

    /**
     * Setzt im int number das/die durch mask angegebenen Bit(s) auf 0.
     *
     * @param number
     * @param mask
     * @return
     */
    public static int clearBitMask(int number, int mask) {
        return number & ~mask;
    }

    /**
     * Negiert im int number das Bit an Position pos.
     *
     * @param number
     * @param pos
     * @return
     */
    public static int flipBit(int number, int pos) {
        return flipBitMask(number, (1 << pos));
    }

    /**
     * Negiert im int number das/die durch mask angegebenen Bit(s).
     *
     * @param number
     * @param mask
     * @return
     */
    public static int flipBitMask(int number, int mask) {
        return number ^ mask;
    }

    /**
     * Prüft im int number das Bit an Position pos.
     *
     * @param number
     * @param pos
     * @return true, falls das Bit gesetzt ist, andernfalls false.
     */
    public static boolean isBit(int number, int pos) {
        return isBitMask(number, (1 << pos));
    }

    /**
     * Prüft im int number das/die durch mask angegebenen Bit(s).
     *
     * @param number
     * @param mask
     * @return true, falls alle Bits in mask gesetzt sind, andernfalls false.
     */
    public static boolean isBitMask(int number, int mask) {
        return (number & mask) == mask;
    }

}
