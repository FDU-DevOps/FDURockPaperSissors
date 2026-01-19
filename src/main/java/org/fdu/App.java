package org.fdu;
import java.util.Scanner;
import java.util.Random;


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
    public static void main( String[] args ) {
        RpsUi.uiWriteMessage( "Welcome to Xavier's RPS Game..." );
        RpsUi.uiWriteMessage( "Enter 'R' for Rock, 'P' for Paper, and 'S' for Scissors...\n" );
        // Create Scanner and get user input for turn
        Scanner RPS_SCANNER = new Scanner(System.in);
        RpsUi.uiWriteMessage("Player enter your move: ");
        String userTurn = RPS_SCANNER.nextLine();

        // Generate Computer Turn
        Random random = new Random();
        int randomInt = random.nextInt(3);

        // Translate Random Integer to usable computer rps turn
        String computerTurn = "";
        switch(randomInt)
        {
            case 0:
                computerTurn = "R";break;
            case 1:
                computerTurn = "P"; break;
            case 2:
                computerTurn = "S"; break;
        }

        // Show what each player chose
        RpsUi.uiWriteMessage("User Chose: " + userTurn);
        RpsUi.uiWriteMessage("Computer Chose: " + computerTurn);

        // Check if there is a tie
        if(userTurn.equalsIgnoreCase(computerTurn))
        {
            RpsUi.uiWriteMessage("It's a tie!");
        }
        // If there is no tie, Determine Winner
        else if(userTurn.equalsIgnoreCase("R") && computerTurn.equals("S") ||
                userTurn.equalsIgnoreCase("S") && computerTurn.equals("P") ||
                userTurn.equalsIgnoreCase("P") && computerTurn.equals("R"))
        {
            RpsUi.uiWriteMessage("User wins!");
        }
        else
        {
            RpsUi.uiWriteMessage("Computer Wins!");
        }

    }
}
