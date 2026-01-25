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
        int gameLoop = 1;
        while (gameLoop == 1) {
            RpsUi.uiWriteMessage("Welcome to Rock Paper Scissors!");
            int gameChoice = RpsUi.uiReadInt("Would you like to play again? Select 1 to continue or 2 to quit");
            while (gameChoice != 1 && gameChoice !=2) {
                gameChoice = RpsUi.uiReadInt("Incorrect input, please select 1 or 2");
            }
            if(gameChoice == 2) {
                gameLoop = 0;
            }

        }
        /// game loop starts
        /// Have basic input where 1 == rock, 2 == paper, and 3 == scissors
        /// Randomly generate the computers choice
        /// output
        /// Game counter for player wins, computer wins and ties

    }
}
