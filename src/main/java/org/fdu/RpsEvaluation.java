package org.fdu;

/**
 * Evaluation class - static, stateless - evaluates player and npc throw according to the game logic
 * Returns the result of the game play (e.g. player won, npc won, tie)
 */
public class RpsEvaluation {

    /**
     * Enum describing game outcomes
     */
    public enum GameOutcomeEnum {
        PLAYER_WINS,
        NPC_WINS,
        TIE;
    }

    /**
     * Evaluates winner based on player and npc throws (player wins, npc wins, tie)
     * @param playerThrow - enum of Players choice - rock, paper or scissors
     * @param npcThrow - enum of NPC's choice - rock, paper or scissors
     * @return - returns enum with the game outcome (Player wins, npc wins or it's a tie
     */
    public static GameOutcomeEnum evaluateThrows(Throw.RpsEnum playerThrow, Throw.RpsEnum npcThrow) {
        return null;
    }
}  // end RpsEvaluation class
