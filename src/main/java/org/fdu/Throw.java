package org.fdu;

import java.util.Random;

/**
 * Throw class - stateless, static utility to normalize, cleanup player input throws, as well as generating random npc throws.
 * <p>
 * Scope: <br>
 *         defines enum for throws including INVALID <br>
 *         normalizes throw (e.g. removes white space, converts to all lower case) w/ no validation <br>
 *         validates / parses guess (ie one of “rock”, “paper”, “scissors”) <br>
 *         includes method to return a random, valid throw as an enum
 */

public class Throw {
    /**
     * Enum reflecting the different types of throws - rock, paper or scissors <br>
     * include value for invalid user input (returned by validation method)
     */
    public enum RpsEnum {
        ROCK,
        PAPER,
        SCISSORS,
        INVALID; /** entered input is invalid */

        /**
         * Modify player input to remove leading and trailing whitespace, convert to all lowercase
         * @param playerInput - raw string player input for their throw
         * @return - updated string - all lowercase, with leading and trailing whitespace removed
         */
        public static String normalizeThrow(String playerInput) {
            return playerInput.trim().toLowerCase();    // trim removes leading and trailing whitespace
        }

        /**
         * validates the user input, and parses into an enum representing their choice of throws
         * requires normalized user input (trimmed and without leading or training whitespace)
         * <p>
         * ToDo: update to enhanced Java switch avail in JDK 21 - cleaner, tighter
         *
         * @param normalizedUserInput - user throw without leading & trailing whitespace & all lowercase
         * @return - enum representing the user's throw.  If user input does not meet input rqmts, return INVALID
         */
        public static RpsEnum parseThrow(String normalizedUserInput) {
            switch (normalizedUserInput) {
                case "rock":
                    return RpsEnum.ROCK;
                case "paper":
                    return RpsEnum.PAPER;
                case "scissors":
                    return RpsEnum.SCISSORS;
                default:
                    return RpsEnum.INVALID;
            }
        }

        private static final Random PRNG = new Random();  // statically initialize, don't reinit every time called

        /**
         * randomly selects one of rock, paper or scissors and returns the associated enum
         * @return - random throw to be associated with npc
         */
        public static RpsEnum getRandomThrow() {
            RpsEnum[] allValues = RpsEnum.values();
            return allValues[PRNG.nextInt(allValues.length-1)];  // BAD - don't include INVALID in random throws
        }
    }
}
