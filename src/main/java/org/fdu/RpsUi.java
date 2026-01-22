package org.fdu;
/**
 *UI class - supports writing to console and reading user input and returning to caller
 *
 * <p>Stateless and content unaware.  The UI methods do not process the input or output</p>
 *
 * @author tbd
 * @version 1.0.0
 * @since 2026-01-10
 */
import java.util.Scanner;

public class RpsUi {

    //Create only one scanner to reuse it and read the lines
    private static Scanner scanner = new Scanner(System.in);

    /** empty constructor - utility class - assumed all methods called statically */
    RpsUi() {    }

    /**
     * Writes the provided String to the console.
     * @param message - String to be output to the console
     */
    public static void uiWriteMessage(String message) {
        System.out.println(message);
    }

    /**
     * Reads a line and return it to the caller
     * @return user input as an integer
     */

    public static int uiReadInput(){
        while(!scanner.hasNext()) {
            scanner.next();
            uiWriteMessage("Invalid Input!");
        }
        int input = scanner.nextInt();
        scanner.nextLine();
        return input;
    }
}
