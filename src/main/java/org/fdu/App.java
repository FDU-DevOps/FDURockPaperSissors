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
    public static void main( String[] args ) {
        RpsUi.uiWriteMessage( "Welcome to Xavier's RPS Game..." );
        RpsUi.uiWriteMessage( "Enter 'R' for Rock, 'P' for Paper, and 'S' for Scissors...\n" );


        Scanner RPS_SCANNER = new Scanner(System.in);
        RpsUi.uiWriteMessage("Player enter your move: ");
        String userTurn = RPS_SCANNER.nextLine();

        //Testing user input
        RpsUi.uiWriteMessage("USER INPUT: " + userTurn);

    }
}
