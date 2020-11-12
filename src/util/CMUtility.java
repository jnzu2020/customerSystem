package util;

import java.util.Scanner;

public class CMUtility {
    private static final Scanner scanner = new Scanner(System.in);

    /**
     * Used for the selection of menu, only '1'-'5' is allowed
     * @return input The selection of menu
     */
    public static char readMenuSelection() {
        char input;
        while (true) {
            String str = readKeyBoard(1, false);
            input = str.charAt(0);
            if (input != '1' && input != '2' && input != '3' && input != '4' && input != '5') {
                System.out.print("Wrong input, please input again: ");
            } else {
                break;
            }
        }
        return input;
    }

    /**
     * Get a char from keyboard
     * @return input The input
     */
    public static char readChar() {
        char input;
        while (true) {
            String str = readKeyBoard(1, false);
            input = str.charAt(0);
            if (input != 'f' && input != 'm') {
                System.out.print("Wrong input, please input again: ");
            } else {
                break;
            }
        }
        return input;
    }

    /**
     * Get a char from keyboard, if the input of user is empty, use the default value
     * @param defaultValue The default value
     * @return input The input
     */
    public static char readChar(char defaultValue) {
        char input;
        while (true) {
            String str = readKeyBoard(1, true);
            input = str.length() == 0 ? defaultValue : str.charAt(0);
            if (input != 'f' && input != 'm') {
                System.out.print("Wrong input, please input again: ");
            } else {
                break;
            }
        }

        return input;
    }

    /**
     * Get a integer, which length not bigger than 99
     * @return input The input
     */
    public static int readInt() {
        int input;
        while (true) {
            String str = readKeyBoard(2, false);
            try {
                input = Integer.parseInt(str);
                break;
            } catch (Exception e) {
                System.out.print("Wrong number, please input again: ");
            }
        }
        return input;
    }

    /**
     * Get a integer, which length not bigger than 99, if the input of user is empty, use the default value
     * @param defaultValue The default value
     * @return input The input
     */
    public static int readInt(int defaultValue) {
        int input;
        while (true) {
            String str = readKeyBoard(2, true);
            try {
                input = str.length() == 0 ? defaultValue : Integer.parseInt(str);
                break;
            } catch (Exception e) {
                System.out.print("Wrong number, please input again: ");
            }
        }
        return input;
    }

    /**
     * Get a String from keyboard, which length no longer than the limit
     * @param limit The limit of length
     * @return The input
     */
    public static String readString(int limit) {
        return readKeyBoard(limit, false);
    }

    /**
     * Get a String from keyboard, which length no longer than the limit
     * if the input of user is empty, use the default value
     * @param limit The limit of length
     * @param defaultValue The default value
     * @return The input
     */
    public static String readString(int limit, String defaultValue) {
        String str = readKeyBoard(limit, true);
        return str.length() == 0 ? defaultValue : str;
    }

    /**
     * Used for the confirm of selection, only 'Y' or 'N' is allowed
     * @return selection The selection
     */
    public static char readConfirmSelection() {
        char selection;
        while (true) {
            String str = readKeyBoard(1, false).toUpperCase();
            selection = str.charAt(0);
            if (selection == 'Y' || selection == 'N') {
                break;
            } else {
                System.out.print("Wrong selection, please select again: ");
            }
        }
        return selection;
    }

    /**
     * Get the input from keyboard, which length not longer than limit
     * @param limit The limit of length
     * @param blankReturn Whether blank return is allowed
     * @return input The input
     */
    private static String readKeyBoard(int limit, boolean blankReturn) {
        String input = "";
        while (scanner.hasNextLine()) {
            input = scanner.nextLine();
            if (input.length() == 0) {
                if (blankReturn) {
                    return input;
                } else {
                    continue;
                }
            }
            if (input.length() > limit) {
                System.out.print("Wrong! The length of input longer than " + limit + ", please input again: ");
                continue;
            }
            break;
        }
        return input;
    }
}
