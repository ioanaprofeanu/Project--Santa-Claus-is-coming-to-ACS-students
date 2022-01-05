package averagescorestrategy;

import entities.Child;

/**
 * Implement the strategy for the kid age category
 */
public class KidAverageScoreStrategy implements AverageScoreStrategy{
    @Override
    public double getAverageScore(Child child) {
        double sumOfScores = 0;
        for (Double score : child.getNiceScoreHistory()) {
            sumOfScores += score;
        }

        double averageScore = (double) sumOfScores / child.getNiceScoreHistory().size();
        return averageScore;
    }
}
