package org.fdu;

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
    private static final String ROCK = "Rock";
    private static final String PAPER = "Paper";
    private static final String SCISSORS = "Scissors";
    private static final String[] CHOICES = {ROCK, PAPER, SCISSORS};

    private static int playerWins = 0;
    private static int computerWins = 0;
    private static int ties = 0;


    public static void main( String[] args ) {
        RpsUi.uiWriteMessage("Welcome to the game!");

        boolean playAgain = true;

        while (playAgain) {
            playRound();
            displayScore();
            playAgain = askPlayAgain();
        }

        RpsUi.uiWriteMessage("Thanks for playing!");
        displayFinalScore();
    }

    //Plays a single round
    private static void playRound(){
        String playerChoice = getPlayerChoice();
        String computerChoice = getComputerChoice();

        RpsUi.uiWriteMessage("\nYou chose: " + playerChoice);
        RpsUi.uiWriteMessage("Computer chose: " + computerChoice);

        String result = Winner(playerChoice, computerChoice);
        RpsUi.uiWriteMessage("\n" + result);
    }

    /**
     * Gets the players choice from user input
     * @return the player's valid choice (r, p, s)
     */
    private static String getPlayerChoice(){
        int choice = 0;
        boolean valid = false;

        while(!valid) {
            RpsUi.uiWriteMessage("\nMake your choice:");
            RpsUi.uiWriteMessage("1. Rock");
            RpsUi.uiWriteMessage("2. Paper");
            RpsUi.uiWriteMessage("3. Scissors");
            RpsUi.uiWriteMessage("Enter 1, 2, or 3:");

            choice = RpsUi.uiReadInput();

            if(choice >= 1 && choice <= 3){
                valid = true;
            }
            else{
                RpsUi.uiWriteMessage("Wrong input, please type 1, 2 or 3");
            }
        }
        return CHOICES[choice - 1];
    }

    /** Generates random choice for the computer
     * @return the computer's choice
     */

    private static String getComputerChoice(){
        Random random = new Random();
        int index = random.nextInt(CHOICES.length);
        return CHOICES[index];
    }

    /**
     * Determines who is the winner of the round and updates the score
     * @param playerChoice the player's choice
     * @param computerChoice the computer's choice
     * @return a message indicating the result
     */
    private static String Winner(String playerChoice, String computerChoice) {
        if (playerChoice.equals(computerChoice)) {
            ties++;
            return "It's a tie!";
        }

        boolean playerWon = false;

        if (playerChoice.equals(ROCK) && computerChoice.equals(SCISSORS)) {
            playerWon = true;
        } else if (playerChoice.equals(PAPER) && computerChoice.equals(ROCK)) {
            playerWon = true;
        } else if (playerChoice.equals(SCISSORS) && computerChoice.equals(PAPER)) {
            playerWon = true;
        }

        if (playerWon) {
            playerWins++;
            return "You win this round!!!";
        } else {
            computerWins++;
            return "Computer wins this round!!!";
        }
    }

    //Display current score
    private static void displayScore(){
        RpsUi.uiWriteMessage("Current Score");
        RpsUi.uiWriteMessage("Player Score: " + playerWins);
        RpsUi.uiWriteMessage("Computer Score:" + computerWins);
        RpsUi.uiWriteMessage("Ties: " + ties);
    }

    /**
     * Displays the final score at the end of the game
     */
    private static void displayFinalScore() {
        int totalRounds = playerWins + computerWins + ties;

        RpsUi.uiWriteMessage("FINAL SCORE");
        RpsUi.uiWriteMessage("Player Wins:   " + playerWins);
        RpsUi.uiWriteMessage("Computer Wins: " + computerWins);
        RpsUi.uiWriteMessage("Ties:" + ties);
        RpsUi.uiWriteMessage("Total Rounds:  " + totalRounds);

        if (playerWins > computerWins) {
            RpsUi.uiWriteMessage("\nCONGRATULATIONS! You won!");
        } else if (computerWins > playerWins) {
            RpsUi.uiWriteMessage("\nThe computer won the game......");
        } else {
            RpsUi.uiWriteMessage("\n The game ended in a tie! ");
        }
    }
    /**
     * Asks the player if they want to play another round
     * @return true if the player wants to play again, false if not
     */
    private static boolean askPlayAgain() {
        RpsUi.uiWriteMessage("\nDo you want to play again?");
        RpsUi.uiWriteMessage("1. Yes");
        RpsUi.uiWriteMessage("2. No");
        RpsUi.uiWriteMessage("Enter 1 or 2:");

        int response = RpsUi.uiReadInput();
        return response == 1;
    }
}
