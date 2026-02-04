package org.fdu;

// JUnit imports - test cases and assertions
import org.junit.jupiter.api.Test;

import static org.fdu.Throw.RpsEnum.*;
import static org.junit.jupiter.api.Assertions.*;

// Throw class access - allows access to static methods without prefix


class ThrowTest {
    @Test
    void normalizeThrowTest() {
    System.out.println("*** verify leading and trailing white space is rmoved");
    System.out.println("   & all characters are converted to lower case");

    String leadingWhitePre = "   Shuffling";
    String leadingWhitePost = "shuffling";
    String trailingWhitePre = "mADNESS   ";
    String trailingWhitePost = "madness";
    String leadingTrailingWhitePre = "\tLoCoMOTIVe\t\n";
    String leadingTrailingWhitePost = "locomotive";
    String midWordWhitePre = "Bre ath";
    String midWordWhitePost = "bre ath";
    assertEquals(leadingWhitePost, normalizeThrow(leadingWhitePre),
            "Leading white space not deleted");
    assertEquals(trailingWhitePost, normalizeThrow(trailingWhitePre),
            "Trailing white space not deleted");
    assertEquals(leadingTrailingWhitePost, normalizeThrow(leadingTrailingWhitePre),
            "Leading &/or trailing white space not deleted");
    assertEquals(midWordWhitePost, normalizeThrow(midWordWhitePre),
            "mid-word white space not handled correctly");
    }

    //  Start w/ straightforward tests, then
    //    throw non-normalized input
    //    then code-change to call normalizeThrow() from within parseThrow() and verify
    @Test
    void parseThrowTest() {
        System.out.println("*** verify rock, paper and scissors are recognized as valid - other as invalid");
        // valid - expected throws after normalization
        String rock = "rock";
        String paper = "paper";
        String scissors = "scissors";
        // invalid throws
        String spock =  "spock";
        String lizard = "lizard";
        assertEquals(ROCK, parseThrow(rock),
                "rock not recognized as valid!");
        assertEquals(PAPER, parseThrow(paper),
                "paper not recognized as valid!");
        assertEquals(SCISSORS, parseThrow(scissors),
                "scissors not recognized as valid!");
        assertEquals(INVALID, parseThrow(spock),
                "spock should be invalid!");
        assertEquals(INVALID, parseThrow(lizard),
                "lizard should be invalid!");
    }

    void getRandomThrowTest() {
        System.out.println("Verify we get a variety of random values and all are valid");
        int rock = 0;
        int paper = 0;
        int scissors = 0;
        for (int itr = 0; itr < 10; itr++) {
            // get a random throw and match to rock, paper or scissors
        }
        // assert what?
    }
}