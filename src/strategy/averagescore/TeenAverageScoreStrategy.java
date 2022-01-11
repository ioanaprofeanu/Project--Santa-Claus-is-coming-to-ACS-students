package strategy.averagescore;

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
        return weightSum / weightFactors;
    }
}
