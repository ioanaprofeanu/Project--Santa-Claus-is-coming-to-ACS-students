package strategy.averagescore;

import common.Constants;
import entities.Child;

/**
 * Implement the strategy for the kid age category
 */
public class KidAverageScoreStrategy implements AverageScoreStrategy {
    /**
     * Calculate the score of the kid according to the given formula
     * @param child the current child
     * @return the score value
     */
    @Override
    public double getAverageScore(final Child child) {
        double sumOfScores = 0;
        for (Double score : child.getNiceScoreHistory()) {
            sumOfScores += score;
        }
        double averageScore = sumOfScores / child.getNiceScoreHistory().size();
        // add the nice score bonus
        averageScore += averageScore * child.getNiceScoreBonus() / Constants.ONE_HUNDRED;
        // if the average score is above the maximum average score permitted, return 10
        if (averageScore > Constants.MAXIMUM_AVERAGE_SCORE) {
            return Constants.MAXIMUM_AVERAGE_SCORE;
        }
        return averageScore;
    }
}
