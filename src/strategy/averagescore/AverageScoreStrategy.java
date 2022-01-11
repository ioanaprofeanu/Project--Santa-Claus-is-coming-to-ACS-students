package strategy.averagescore;

import entities.Child;

/**
 * Interface for the strategy pattern which calculates the average score
 * depending on the child's age
 */
public interface AverageScoreStrategy {
    /**
     * The method which retrieves the average score of a child
     * @param child the current child
     * @return the average score value
     */
    double getAverageScore(Child child);
}
