package org.fdu;

import java.util.Locale;

public enum Move {
    ROCK,
    PAPER,
    SCISSORS;

    // Turn user input text into a Move
    public static Move fromInput(String input) {
        if (input == null) {
            return null;
        }

        String normalized = input.trim().toLowerCase(Locale.ROOT);

        // Java 8 style switch (no "->")
        switch (normalized) {
            case "r":
            case "rock":
                return ROCK;
            case "p":
            case "paper":
                return PAPER;
            case "s":
            case "scissors":
            case "scissor":
                return SCISSORS;
            default:
                return null;
        }
    }

    // Does this move beat the other move?
    public boolean beats(Move other) {
        // Java 8 style switch (no "->")
        switch (this) {
            case ROCK:
                return other == SCISSORS;
            case PAPER:
                return other == ROCK;
            case SCISSORS:
                return other == PAPER;
            default:
                // should never happen
                return false;
        }
    }
}
