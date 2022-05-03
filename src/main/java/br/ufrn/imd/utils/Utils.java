package br.ufrn.imd.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

/**
 * Util class for the project with generics implementations, constants and methods to print.
 *
 * @author Jonas, Neylane e Débora.
 * @version 1.0.
 * @see br.ufrn.imd.Cattle
 */
public final class Utils {
    /**
     * Date time format for brazilian formart.
     */
    public final static DateTimeFormatter BRAZILIAN_DATE_FORMAT = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    /**
     * Reset color.
     */
    public static final String RESET = "\u001B[0m";
    /**
     * Black color.
     */
    public static final String BLACK = "\u001B[30m";
    /**
     * Red color.
     */
    public static final String RED = "\u001B[31m";
    /**
     * Green color.
     */
    public static final String GREEN = "\u001B[32m";
    /**
     * Yellow color.
     */
    public static final String YELLOW = "\u001B[33m";
    /**
     * Blue color.
     */
    public static final String BLUE = "\u001B[34m";
    /**
     * Purple color.
     */
    public static final String PURPLE = "\u001B[35m";
    /**
     * Cyan color.
     */
    public static final String CYAN = "\u001B[36m";
    /**
     * White color.
     */
    public static final String WHITE = "\u001B[37m";

    /**
     * Black background.
     */
    public static final String BLACK_BACKGROUND = "\u001B[40m";
    /**
     * Red background.
     */
    public static final String RED_BACKGROUND = "\u001B[41m";
    /**
     * Green background.
     */
    public static final String GREEN_BACKGROUND = "\u001B[42m";
    /**
     * Yellow background.
     */
    public static final String YELLOW_BACKGROUND = "\u001B[43m";
    /**
     * Blue background.
     */
    public static final String BLUE_BACKGROUND = "\u001B[44m";
    /**
     * Purple background.
     */
    public static final String PURPLE_BACKGROUND = "\u001B[45m";
    /**
     * Cyan background.
     */
    public static final String CYAN_BACKGROUND = "\u001B[46m";
    /**
     * White background.
     */
    public static final String WHITE_BACKGROUND = "\u001B[47m";

    /**
     * Returns a string with representation of my list.
     *
     * @param list List to be transformed in string.
     * @param <T>  Value type.
     * @return List representation in string.
     */
    public static <T> String ListToString(final List<T> list) {
        if (list.isEmpty()) return "[]";

        StringBuilder sb = new StringBuilder().append("[").append(System.getProperty("line.separator")).append("\t");

        for (T t : list) {
            sb.append(t.toString()).append(", ");
        }

        sb.append(System.getProperty("line.separator")).append("]");

        return sb.toString();
    }

    /**
     * Returns a string with representation of my map.
     *
     * @param map Map to be represented in string.
     * @param <T> Key type.
     * @param <U> Value type.
     * @return Map Representation in string.
     */
    public static <T, U> String MapToString(final Map<T, U> map) {
        return MapToString(map, Object::toString);
    }

    /**
     * Returns a string with representation of my map.
     *
     * @param map       Map to be represented in string.
     * @param tToString Lambda expression that transforms key in string.
     * @param <T>       Key type.
     * @param <U>       Value type.
     * @return Map Representation in string.
     */
    public static <T, U> String MapToString(final Map<T, U> map, final Function<T, String> tToString) {
        if (map.isEmpty()) return "[]";

        StringBuilder sb = new StringBuilder().append("[").append(System.getProperty("line.separator")).append("\t");

        for (T t : map.keySet()) {
            sb.append("{ ").append((tToString.apply(t))).append(": ").append(map.get(t).toString()).append(" }, ");
        }

        sb.append(System.getProperty("line.separator")).append("]");

        return sb.toString();
    }

    /**
     * Return String with date formatted in brazilian format.
     *
     * @param date Date.
     * @return String with date formatted in brazilian format.
     */
    public static String LocalDateToString(LocalDate date) {
        return date.format(BRAZILIAN_DATE_FORMAT);
    }

    /**
     * Print text in black color.
     *
     * @param string text to be printed.
     */
    public static void printBlack(final String string) {
        System.out.println(BLACK + string + RESET);
    }

    /**
     * Print text in red color.
     *
     * @param string text to be printed.
     */
    public static void printRed(final String string) {
        System.out.println(RED + string + RESET);
    }

    /**
     * Print text in green color.
     *
     * @param string text to be printed.
     */
    public static void printGreen(final String string) {
        System.out.println(GREEN + string + RESET);
    }

    /**
     * Print text in yellow color.
     *
     * @param string text to be printed.
     */
    public static void printYellow(final String string) {
        System.out.println(YELLOW + string + RESET);
    }

    /**
     * Print text in blue color.
     *
     * @param string text to be printed.
     */
    public static void printBlue(final String string) {
        System.out.println(BLUE + string + RESET);
    }

    /**
     * Print text in purple color.
     *
     * @param string text to be printed.
     */
    public static void printPurple(final String string) {
        System.out.println(PURPLE + string + RESET);
    }

    /**
     * Print text in cyan color.
     *
     * @param string text to be printed.
     */
    public static void printCyan(final String string) {
        System.out.println(CYAN + string + RESET);
    }

    /**
     * Print text in white color.
     *
     * @param string text to be printed.
     */
    public static void printWhite(final String string) {
        System.out.println(WHITE + string + RESET);
    }

    /**
     * Print text.
     *
     * @param string text to be printed.
     */
    public static void print(final String string) {
        System.out.println(string);
    }

    /**
     * Print empty line.
     */
    public static void printEmptyLine() {
        System.out.println();
    }
}
