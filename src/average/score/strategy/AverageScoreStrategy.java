package average.score.strategy;

import entities.ChildAnnualData;

import java.util.List;

/**
 * Interface for the strategy pattern which calculates the average score
 * depending on the child's age
 */
public interface AverageScoreStrategy {
    public double getAverageScore(ChildAnnualData child);
}
