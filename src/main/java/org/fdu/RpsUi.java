package org.fdu;
import java.util.Scanner;
/**
 * UI class - supports writing to console and reading user input and returning to caller
 *
 * <p>Stateless and content unaware.  The UI methods do not process the input or output</p>
 *
 * @author tbd
 * @version 1.0.0
 * @since 2026-01-10
 */

public class RpsUi {

    /** empty constructor - utility class - assumed all methods called statically */
    RpsUi() {    }

    /// Default scanner for user input
    static Scanner scanner = new Scanner(System.in);
    /**
     * Writes the provided String to the console.
     * @param message - String to be output to the console
     */
    public static void uiWriteMessage(String message) {
        System.out.println(message);
    }

    /// Read function that utilizes a scanner to get user input (ints)
    public static int uiReadInt(String prompt) {
        uiWriteMessage(prompt);
        return scanner.nextInt();
    }
}
