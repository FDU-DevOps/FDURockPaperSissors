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
    public static void main(String[] args)
    {
        System.out.println("Rock Paper Scissors:");


        Scanner RPS_Scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("Press 1 for Rock, 2 for Scissors, 3 for Paper");
        int playerChoice = RPS_Scanner.nextInt();

        int computerChoice = random.nextInt(3) + 1;

        if (playerChoice == computerChoice)
        {
            System.out.println("It's a tie!");
        }
        else if (
                (playerChoice == 1 && computerChoice == 2) ||
                        (playerChoice == 2 && computerChoice == 3) ||
                        (playerChoice == 3 && computerChoice == 1)
        )
        {
            System.out.println("You win!");
        }
        else
        {
            System.out.println("You lose!");
        }

        RPS_Scanner.close();
    }
}

