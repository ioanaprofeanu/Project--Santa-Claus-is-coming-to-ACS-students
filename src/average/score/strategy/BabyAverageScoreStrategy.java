package average.score.strategy;

import entities.ChildAnnualData;
import fileio.input.ChildInput;

import java.util.List;

/**
 * Implement the strategy for the baby age category
 */
public class BabyAverageScoreStrategy implements AverageScoreStrategy{
    @Override
    public double getAverageScore(ChildAnnualData child) {
        return 10;
    }
}
