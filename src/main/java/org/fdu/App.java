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
        String userInput;
        String[] choices = {"r","p","s"};

        int playerWins = 0;
        int computerWins = 0;

        RpsUi.uiWriteMessage("Welcome to Rock Paper Scissors!");

        while(keepPlaying) {
            RpsUi.uiWriteMessage("Please enter your choice (r for rock, p for paper, s for scissors):");
            playerInput = scanner.nextLine().toLowerCase().trim();
            while (!playerInput.equals("r") && !playerInput.equals("p") && !playerInput.equals("s")) {
                RpsUi.uiWriteMessage("Enter your choice (r for rock, p for paper, s for scissors):");
                playerInput = scanner.nextLine().toLowerCase().trim();

                if (!playerInput.equals("r") && !playerInput.equals("p") && !playerInput.equals("s")) {
                    RpsUi.uiWriteMessage("Invalid choice! Please try again.");
                }
            }
            int index = random.nextInt(3);
            computerInput = choices[index];

            RpsUi.uiWriteMessage("Player Chose: " + playerInput);
            RpsUi.uiWriteMessage("Computer Chose: " + computerInput);

            if(playerInput.equals(computerInput)){
                RpsUi.uiWriteMessage("It's a tie");
            }
            else if((playerInput.equals("r") && computerInput.equals("s") || playerInput.equals("p") && computerInput.equals("s") || playerInput.equals("s") && computerInput.equals("p"))){
                RpsUi.uiWriteMessage("You win!");
                playerWins++;
            }
            else
            {
                RpsUi.uiWriteMessage("Computer win!");
                computerWins++;
            }
            RpsUi.uiWriteMessage("Player wins: " + playerWins);
            RpsUi.uiWriteMessage("Computer wins: " + computerWins);

            RpsUi.uiWriteMessage("Would you like to play again? (Enter y for yes or n for no)");
            userInput = scanner.nextLine().toLowerCase().trim();
            while(!userInput.equals("y") || !userInput.equals("n")){
                RpsUi.uiWriteMessage("Please enter y for yes if you like to play again or n for no to quit");
                userInput = scanner.nextLine().toLowerCase().trim();
            }
            keepPlaying = userInput.equals("y") || userInput.equals("n");
        }
        RpsUi.uiWriteMessage("Thank you for Playing!");
        scanner.close();
    }
}
