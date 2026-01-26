package org.fdu;

import java.util.Random;
import java.util.Scanner;

public class App 
{
    public static void main( String[] args )
    {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int playerWins = 0;
        int computerWins = 0;
        int ties = 0;

        System.out.println("=== Rock Paper Scissors ===");
        System.out.println("Type rock, paper, or scissors.");
        System.out.println("You can also use r / p / s.");
        System.out.println("Type q or quit to exit.");
        System.out.println();

        while (true) {
        System.out.print("Your move (rock/paper/scissors or q to quit): ");
        String input = scanner.nextLine();

        if (input == null) {
            System.out.println("No input detected. Exiting.");
            break;
        }

            String trimmed = input.trim().toLowerCase();
            if (trimmed.equals("q") || trimmed.equals("quit"))
            {
                break;
            }

            Move playerMove = Move.fromInput(trimmed);
            if (playerMove == null) {
                System.out.println("Invalid move. Please try again.");
                System.out.println();
                continue;
            }

            Move computerMove = randomMove(random);

            System.out.println("You chose:      " + playerMove);
            System.out.println("Computer chose: " + computerMove);

            if (playerMove == computerMove) {
                System.out.println("Result: It's a tie!");
                ties++;
            } else if (playerMove.beats(computerMove)) {
                System.out.println("Result: You win!");
                playerWins++;
            } else {
                System.out.println("Result: Computer wins!");
                computerWins++;
            }

            System.out.println();
            System.out.println("Score so far:");
            System.out.println("  You:      " + playerWins);
            System.out.println("  Computer: " + computerWins);
            System.out.println("  Ties:     " + ties);
            System.out.println("------------------------------------");
        }

        System.out.println();
        System.out.println("Thanks for playing!");
        System.out.println("Final score:");
        System.out.println("  You:      " + playerWins);
        System.out.println("  Computer: " + computerWins);
        System.out.println("  Ties:     " + ties);

        scanner.close();
    }

    // Pick a random move for the computer
    private static Move randomMove(Random random)
    {
        Move[] moves = Move.values();
        int index = random.nextInt(moves.length);
        return moves[index];
    }
}

