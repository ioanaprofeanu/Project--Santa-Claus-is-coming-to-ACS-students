package strategy.averagescore;

import common.Constants;
import entities.Child;

/**
 * Implement the strategy for the teen age category
 */
public class TeenAverageScoreStrategy implements AverageScoreStrategy {
    /**
     * Calculate the score of the teen according to the given formula
     * @param child the current child
     * @return the score value
     */
    @Override
    public double getAverageScore(final Child child) {
        double weightFactors = 0;
        double weightSum = 0;
        for (int i = 1; i <= child.getNiceScoreHistory().size(); i++) {
            weightFactors += i;
            weightSum += child.getNiceScoreHistory().get(i - 1) * i;
        }
        double averageScore = weightSum / weightFactors;
        // add the nice score bonus
        averageScore += averageScore * child.getNiceScoreBonus() / Constants.ONE_HUNDRED;
        // if the average score is above the maximum average score permitted, return 10
        if (averageScore > Constants.MAXIMUM_AVERAGE_SCORE) {
            return Constants.MAXIMUM_AVERAGE_SCORE;
        }
        return averageScore;
    }
}
