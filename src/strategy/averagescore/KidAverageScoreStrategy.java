package strategy.averagescore;

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
        return sumOfScores / child.getNiceScoreHistory().size();
    }
}
