package de.javafish.helper;

import java.util.*;

/**
 * Utility-Klasse für diverse Kalender-Funktionen.
 *
 * @author fmk
 */
public final class CalendarHelper {

    /**
     * Privater Contsructor, da ausschließlich statische Methoden vorhanden.
     */
    private CalendarHelper() {
    }

    /**
     * Helfer-Methode, die einen Kalender erzeugt, der auf das Datum und die
     * Uhrzeit, der übergebenen Parameter zeigt.
     *
     * @param year
     * @param month als int (0 - Januar, 1 - Februar, ..., 11 - Dezember)
     * @param day
     * @param hour
     * @param minute
     * @param second
     * @return ein Calendar-Objekt
     */
    public static Calendar makeCalendar(int year, int month, int day, int hour, int minute, int second) {
        Calendar c = Calendar.getInstance();
        c.set(year, month, day, hour, minute, second);
        return c;
    }

    /**
     * Helfer-Methode, die einen Kalender erzeugt, der auf das Datum und die
     * Uhrzeit, der übergebenen Parameter zeigt. Als Wert für die Sekunden wird
     * <code>0</code> eingesetzt.
     *
     * @param year
     * @param month als int (0 - Januar, 1 - Februar, ..., 11 - Dezember)
     * @param day
     * @param hour
     * @param minute
     * @return ein Calendar-Objekt
     */
    public static Calendar makeCalendar(int year, int month, int day, int hour, int minute) {
        return makeCalendar(year, month, day, hour, minute, 0);
    }

    /**
     * Helfer-Methode, die einen Kalender erzeugt, der auf das Datum der
     * übergebenen Parameter zeigt.
     *
     * @param year
     * @param month als int (0 - Januar, 1 - Februar, ..., 11 - Dezember)
     * @param day
     * @return ein Calendar-Objekt
     */
    public static Calendar makeCalendar(int year, int month, int day) {
        return makeCalendar(year, month, day, 0, 0, 0);
    }

    /**
     * Helfer-Methode, die einen Kalender erzeugt, der auf das Datum und die
     * Uhrzeit, der übergebenen Parameter zeigt.
     *
     * @param year
     * @param month als Month (Month.JANUARY, Month.FEBRUARY, ...,
     * Month.DECEMBER)
     * @param day
     * @param hour
     * @param minute
     * @param second
     * @return ein Calendar-Objekt
     */
    public static Calendar makeCalendar(int year, Month month, int day, int hour, int minute, int second) {
        return makeCalendar(year, month.ordinal(), day, hour, minute, second);
    }

    /**
     * Helfer-Methode, die einen Kalender erzeugt, der auf das Datum und die
     * Uhrzeit, der übergebenen Parameter zeigt. Als Wert für die Sekunden wird
     * <code>0</code> eingesetzt.
     *
     * @param year
     * @param month als Month (Month.JANUARY, Month.FEBRUARY, ...,
     * Month.DECEMBER)
     * @param day
     * @param hour
     * @param minute
     * @return ein Calendar-Objekt
     */
    public static Calendar makeCalendar(int year, Month month, int day, int hour, int minute) {
        return makeCalendar(year, month.ordinal(), day, hour, minute);
    }

    /**
     * Helfer-Methode, die einen Kalender erzeugt, der auf das Datum der
     * übergebenen Parameter zeigt.
     *
     * @param year
     * @param month als Month (Month.JANUARY, Month.FEBRUARY, ...,
     * Month.DECEMBER)
     * @param day
     * @return ein Calendar-Objekt
     */
    public static Calendar makeCalendar(int year, Month month, int day) {
        return makeCalendar(year, month.ordinal(), day);
    }

    /**
     * Helfer-Methode, die einen Kalender erzeugt, der auf das Datum und die
     * Uhrzeit, der übergebenen Parameter zeigt.
     *
     * @param year
     * @param monat als Monat (Monat.JANUAR, Monat.FEBRUAR, ..., Monat.DEZEMBER)
     * @param day
     * @param hour
     * @param minute
     * @param second
     * @return ein Calendar-Objekt
     */
    public static Calendar makeCalendar(int year, Monat monat, int day, int hour, int minute, int second) {
        return makeCalendar(year, monat.ordinal(), day, hour, minute, second);
    }

    /**
     * Helfer-Methode, die einen Kalender erzeugt, der auf das Datum und die
     * Uhrzeit, der übergebenen Parameter zeigt. Als Wert für die Sekunden wird
     * <code>0</code> eingesetzt.
     *
     * @param year
     * @param monat als Monat (Monat.JANUAR, Monat.FEBRUAR, ..., Monat.DEZEMBER)
     * @param day
     * @param hour
     * @param minute
     * @return ein Calendar-Objekt
     */
    public static Calendar makeCalendar(int year, Monat monat, int day, int hour, int minute) {
        return makeCalendar(year, monat.ordinal(), day, hour, minute);
    }

    /**
     * Helfer-Methode, die einen Kalender erzeugt, der auf das Datum der
     * übergebenen Parameter zeigt.
     *
     * @param year
     * @param monat als Monat (Monat.JANUAR, Monat.FEBRUAR, ..., Monat.DEZEMBER)
     * @param day
     * @return ein Calendar-Objekt
     */
    public static Calendar makeCalendar(int year, Monat monat, int day) {
        return makeCalendar(year, monat.ordinal(), day);
    }

    /**
     * Helfer-Methode, die einen Kalender erzeugt, der auf das Datum des
     * übergebenen Parameter zeigt.
     *
     * @param date
     * @return ein Calendar-Objekt
     */
    public static Calendar makeCalendar(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        return c;
    }

    /**
     * Helfer-Methode, die einen Kalender erzeugt, der das Datum des übergebenen
     * Parameter referenziert.
     *
     * @param date im format yyyymmdd
     * @return ein Calendar-Objekt
     */
    public static Calendar makeCalendar(int date) {
        int d = date;
        int y = d / 10000;
        d -= y * 10000;
        int m = d / 100;
        d -= m * 100;
        return makeCalendar(y, m-1, d);
    }

    /**
     * Helfer-Methode, die einen Kalender erzeugt, der das Datum des übergebenen
     * Strings referenziert.
     *
     * @param str im format "dd.mm.yyyy"
     * @return ein Calendar-Objekt
     */
    public static Calendar makeCalendar(String str) {
        String[] date = str.split("\\.");
        int day = Integer.parseInt(date[0]);
        int month = Integer.parseInt(date[1])-1;
        int year = Integer.parseInt(date[2]);
        return makeCalendar(year, month, day);
    }
    
    /**
     * Helfer-Methode, die aus einem Kalender einen String im Format
     * "dd.mm.jjjj" erzeugt.
     * 
     * @param calendar
     * @return 
     */
    public static String getDateString(Calendar calendar) {
        if (calendar == null) {
            return "";
        }
        return String.format(
                "%02d.%02d.%04d",
                calendar.get(Calendar.DATE),
                calendar.get(Calendar.MONTH) + 1,
                calendar.get(Calendar.YEAR));
    }

    public static String getDateString(Date date) {
        if (date == null) {
            return "";
        }
        return getDateString(makeCalendar(date));
    }

    /**
     * Helfer-Methode, die aus einem Kalender einen MySQL-kompatiblen String
     * erzeugt.
     *
     * @param calendar
     * @return ein String im Format <code>yyyy-mm-dd</code>
     */
    public static String mysqlDateString(Calendar calendar) {
        return String.format(
                "%04d-%02d-%02d",
                calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH) + 1,
                calendar.get(Calendar.DATE));
    }

    public static String mysqlDateString(Date date) {
        return mysqlDateString(makeCalendar(date));
    }

    public static Calendar getDifferenceDay(int tage) {
        Calendar cDiff = Calendar.getInstance();
        cDiff.add(Calendar.DATE, tage);
        return cDiff;
    }

    public static double getDifference(Date now, Date then) {
        if (now == null || then == null) {
            throw new IllegalArgumentException("date must not null");
        }
        Double dNow = ((Long) now.getTime()).doubleValue();
        Double dThen = ((Long) then.getTime()).doubleValue();
        Double d3 = dNow - dThen;
        return d3;
    }

    public static double getDifference(Date then) {
        return getDifference(new Date(), then);
    }

    public static double getMonthDifference(Date now, Date then) {
        return getDifference(now, then) / 1000 / 60 / 60 / 24 / 30;
        //                           ms     s    m    h    d   
    }

    public static double getMonthDifference(Date then) {
        return getDifference(then) / 1000 / 60 / 60 / 24 / 30;
        //                        ms     s    m    h    d   
    }

    public static double getYearDifference(Date now, Date then) {
        return getDifference(now, then) / 1000 / 60 / 60 / 24 / 365;
        //                           ms     s    m    h    d
    }

    public static double getYearDifference(Date then) {
        return getDifference(then) / 1000 / 60 / 60 / 24 / 365;
        //                        ms     s    m    h    d
    }

    
    /**
     * Lifert den Montag der Woche des übergebene Datum als Calendar.
     * 
     * @param date
     * @return 
     */
    public static Calendar getMonday(Date date) {
        int subtract = -(getDayOfWeek(date) - 1);
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, subtract);
        return cal;
    }

    /**
     * Ermittelt den Wochentag des übergebenen Date.
     * 
     * @param date
     * @return 1 - Montag, ... 7 - Sonntag
     */
    public static int getDayOfWeek(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int wocht = cal.get(Calendar.DAY_OF_WEEK) - 1;
        return wocht == 0 ? 7 : wocht;
    }

}
