package average.score.strategy;

import entities.ChildAnnualData;

/**
 * Implement the strategy for the teen age category
 */
public class TeenAverageScoreStrategy implements AverageScoreStrategy{
    @Override
    public double getAverageScore(ChildAnnualData child) {
        double weightFactors = 0;
        double weightSum = 0;
        for (int i = 1; i <= child.getNiceScoreHistory().size(); i++) {
            weightFactors += i;
            weightSum += child.getNiceScoreHistory().get(i) * i;
        }
        double averageScore = (double) weightSum / weightFactors;
        return averageScore;
    }
}
