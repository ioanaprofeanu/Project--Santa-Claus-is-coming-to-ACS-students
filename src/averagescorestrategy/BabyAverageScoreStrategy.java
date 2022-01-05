package averagescorestrategy;

import entities.Child;

/**
 * Implement the strategy for the baby age category
 */
public class BabyAverageScoreStrategy implements AverageScoreStrategy{
    @Override
    public double getAverageScore(Child child) {
        return 10;
    }
}
