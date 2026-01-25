package org.fdu;
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
    /// Create a method for checking the outcome of the game, will return 0 for tie, 1 for player win, and 2 for player loss
    public static int CheckWin(int pc, int cc) {
        if (pc == cc) {
            return 0;
        }
        if((pc==1 && cc ==3)|| (pc == 2 && cc == 1) || (pc == 3&& cc ==2)) {
            return 1;
        }
        else {
            return 2;
        }
    }
    public static void main( String[] args ) {
        /// Introduce user to rules
        RpsUi.uiWriteMessage("Welcome to Rock Paper Scissors!\nHere are the controls:\n");
        RpsUi.uiWriteMessage("Rock beats scissors, scissors beats paper, and paper beats rock");
        RpsUi.uiWriteMessage("If you and the computer make the same choice, its a tie!\n");

        /// Game wins counter
        int playerWin = 0;
        int totalGames = 0;
        int ties = 0;
        /// game loop starts. Game will continue running until user selects 2 to quit

        int gameLoop = 1;
        while (gameLoop == 1) {
            /// Enter Game Loop and display current game stats
            RpsUi.uiWriteMessage("Player Wins: " + playerWin + "       Ties: " + ties +"      Total Games: " + totalGames + "\n");

            /// Have basic input where 1 == rock, 2 == paper, and 3 == scissors
            RpsUi.uiWriteMessage("Make your choice...");
            int pc = RpsUi.uiReadInt("Input 1 for rock, two for paper, or 3 for scissors!");
            while (pc != 1 && pc !=2 && pc !=3) {
                pc = RpsUi.uiReadInt("Invalid input, please select 1 for rock, 2 for paper, or 3 for scissors");
            }

            //generate computer choice from range 1-3 inclusive
            int cc = (int)(Math.random() * 3) + 1;

            ///Convert numeric choice into a string for final output message
            String compText = "";
            String playerText = "";
            if(pc ==1) {
                playerText = "rock";
            }

            if(pc ==2) {
                playerText = "paper";
            }

            if(pc ==3) {
                playerText = "scissors";
            }
            if(cc ==1) {
                compText = "rock";
            }

            if(cc ==2) {
                compText = "paper";
            }

            if(cc ==3) {
                compText = "scissors";
            }

            /// Simulate RPS
            RpsUi.uiWriteMessage("Rock\nPaper\nScissors\nShoot!\n");

            /// Output player choice and computer choice
            RpsUi.uiWriteMessage("You chose: " + playerText);
            RpsUi.uiWriteMessage("Your opponent chose: " + compText + "\n");

            /// Declare winner
            int outcome = CheckWin(pc,cc);
            if(outcome == 0) {
                RpsUi.uiWriteMessage("It's a tie!");
                ties++;
            }
            if(outcome == 1) {
                RpsUi.uiWriteMessage("You win! :)");
                playerWin++;
            }
            if(outcome==2) {
                RpsUi.uiWriteMessage("You lose :P");

            }
            totalGames++;
                ///Ask player if they would like to play again
            int gameChoice = RpsUi.uiReadInt("Would you like to play again? Select 1 to continue or 2 to quit");
          /// Verify input
            while (gameChoice != 1 && gameChoice !=2) {
                gameChoice = RpsUi.uiReadInt("Incorrect input, please select 1 or 2");
            }
            if(gameChoice == 2) {
                gameLoop = 0;
            }

        }
        RpsUi.uiWriteMessage("Thank you for playing!");
        RpsUi.uiWriteMessage("_______Final Score________ \nTotal Wins: " + playerWin + "\nTotal ties: " + ties
                + "\nTotal Games Played: " + totalGames);



    }
}
