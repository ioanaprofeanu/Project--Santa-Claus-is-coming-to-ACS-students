package averagescorestrategy;

import entities.Child;

/**
 * Implement the strategy for the teen age category
 */
public class TeenAverageScoreStrategy implements AverageScoreStrategy{
    @Override
    public double getAverageScore(Child child) {
        double weightFactors = 0;
        double weightSum = 0;
        for (int i = 1; i <= child.getNiceScoreHistory().size(); i++) {
            weightFactors += i;
            weightSum += child.getNiceScoreHistory().get(i - 1) * i;
        }
        double averageScore = (double) weightSum / weightFactors;
        return averageScore;
    }
}
