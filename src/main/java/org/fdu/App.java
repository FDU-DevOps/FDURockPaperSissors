package org.fdu;
import java.util.Random;
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
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        boolean keepPlaying = true;
        String playerInput = "";
        String computerInput = "";
        String userInput = "";

        int playerWins = 0;
        int computerWins = 0;

        RpsUi.uiWriteMessage("Welcome to Rock Paper Scissors!");

        while(keepPlaying) {
            //Asking user to input r for rock, p for paper, s for scissor
            //If user enters invalid, the while will continue until user enters correct input
            while (!playerInput.equals("r") && !playerInput.equals("p") && !playerInput.equals("s")) {
                RpsUi.uiWriteMessage("Please enter your choice (r for rock, p for paper, s for scissors):");
                playerInput = scanner.nextLine().toLowerCase().trim();

                if (!playerInput.equals("r") && !playerInput.equals("p") && !playerInput.equals("s")) {
                    RpsUi.uiWriteMessage("Invalid choice! Please try again.");
                }
            }
            //Create array with choices r = rock, p = paper, s = scissor
            String[] choices = {"r","p","s"};

            //Randomly select r, p, or s from the array and saved as computerInput
            int index = random.nextInt(3);
            computerInput = choices[index];

            //Displays what the user entered and what the computer selected
            RpsUi.uiWriteMessage("r = rock, p = paper, s = scissor");
            RpsUi.uiWriteMessage("Player Chose: " + playerInput);
            RpsUi.uiWriteMessage("Computer Chose: " + computerInput);

            //If statements to find out if user and computer tied, or if user won or if the computer won
            if(playerInput.equals(computerInput)){
                RpsUi.uiWriteMessage("It's a tie");
            }
            else if((playerInput.equals("r") && computerInput.equals("s") || playerInput.equals("p") && computerInput.equals("r") || playerInput.equals("s") && computerInput.equals("p"))){
                RpsUi.uiWriteMessage("You win!");
                playerWins++;
            }
            else
            {
                RpsUi.uiWriteMessage("Computer win!");
                computerWins++;
            }
            //Asking for user input if they wish to continue to play game
            RpsUi.uiWriteMessage("Would you like to play again? (Enter y for yes or n for no)");
            userInput = scanner.nextLine().toLowerCase().trim();

            //Validate the user's input if enter n or y
            while (!userInput.equals("y") && !userInput.equals("n")) {
                RpsUi.uiWriteMessage("Invalid input. Please enter 'y' for yes or 'n' for no: ");
                userInput = scanner.nextLine().trim().toLowerCase();
            }

            //Exit game if user enters n, the game loop will end
            if (userInput.equals("n")) {
                //Once user quits game, score of how many times user won and how many times the computer won is displayed
                RpsUi.uiWriteMessage("Player wins: " + playerWins);
                RpsUi.uiWriteMessage("Computer wins: " + computerWins);
                keepPlaying = false;
            }
            else {
                playerInput = "";  // Reset for next round
            }
        }
        RpsUi.uiWriteMessage("Thank you for Playing!");
        scanner.close();
    }
}
