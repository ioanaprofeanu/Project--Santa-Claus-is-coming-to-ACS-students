package strategy.averagescore;

import common.Constants;
import entities.Child;

/**
 * Implement the strategy for the baby age category
 */
public class BabyAverageScoreStrategy implements AverageScoreStrategy {
    /**
     * Return the nice score of the baby
     * @param child the current child
     * @return the score value
     */
    @Override
    public double getAverageScore(final Child child) {
        return Constants.MAXIMUM_AVERAGE_SCORE;
    }
}
