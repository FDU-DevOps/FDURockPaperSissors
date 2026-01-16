package org.fdu;
import java.util.Scanner;

/**
 * A console-based implementation of the classic Rock Paper Scissors game.
 * This application allows a user to play against a computer opponent using
 * standard win/loss logic.
 *
 * <p>Standard rules apply: Rock beats Scissors, Scissors beats Paper,
 * and Paper beats Rock.</p>
 *
 * @author many!
 * @version 1.0.0
 * @since 2026-01-10
 */

public class App 
{
    static void checkOutcome(int playerInput, int computerInput) {
        if (playerInput == computerInput) {
            RpsUi.uiWriteMessage( "Draw!");
        }
        else if (playerInput == 1 && computerInput == 3 || playerInput == 2 && computerInput == 1 || playerInput == 3 && computerInput == 2) {
            RpsUi.uiWriteMessage( "You Win!");
        }
        else {
            RpsUi.uiWriteMessage( "You Lose!");
        }
    }
    public static void main( String[] args ) {
        Scanner scan = new Scanner(System.in);
        RpsUi.uiWriteMessage( "Enter a number! \n 1. Rock \n 2. Paper \n 3. Scissors \n");
        int playerInput;
        int computerInput = (int)(Math.random() * 3) + 1;
        try {
            playerInput = scan.nextInt();
            RpsUi.uiWriteMessage( "The computer chose " + computerInput + "!");
            checkOutcome(playerInput, computerInput);
        }
        catch (Exception e) {
            RpsUi.uiWriteMessage( "Invalid Input, Exiting...");
        }
        scan.close();
    }
}
