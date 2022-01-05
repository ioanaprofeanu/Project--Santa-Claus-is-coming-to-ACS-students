package averagescorestrategy;

import entities.Child;

/**
 * Implementation of the
 */
public class AverageScoreStrategyFactory {
    /**
     * the factory instance of the strategy will be created using the
     * lazy singleton design pattern
     */
    private static AverageScoreStrategyFactory instance = null;

    private AverageScoreStrategyFactory() {}

    /**
     * Create if not existing and return the instance of the factory
     * @return the factory instance
     */
    public static AverageScoreStrategyFactory getInstance() {
        if (instance == null) {
            instance = new AverageScoreStrategyFactory();
        }
        return instance;
    }

    /**
     * Check if a number is between a given interval
     * @param number the to-be-tested number
     * @param lowerLimit the lower limit of the interval
     * @param upperLimit the upper limit of the interval
     * @return true if in the interval, false otherwise
     */
    public static boolean isBetween(int number, int lowerLimit, int upperLimit) {
        return lowerLimit <= number && number <= upperLimit;
    }

    /**
     * Returns the strategy which should be used for a given child,
     * depending on its age group
     * @param child the to-be-tested child
     * @return the strategy suited for the child's age
     */
    public AverageScoreStrategy createAverageScoreStrategy(Child child) {
        if (isBetween(child.getAge(), 0, 4)) {
            return new BabyAverageScoreStrategy();
        }
        if (isBetween(child.getAge(), 5, 11)) {
            return new KidAverageScoreStrategy();
        }
        if (isBetween(child.getAge(), 12, 18)) {
            return new TeenAverageScoreStrategy();
        }
        return null;
    }
}
