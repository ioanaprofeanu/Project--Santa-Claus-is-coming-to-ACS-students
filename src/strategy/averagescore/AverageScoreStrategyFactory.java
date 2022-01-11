package strategy.averagescore;

import common.Constants;
import entities.Child;

/**
 * Implementation of the factory design pattern for creating the average score strategies,
 * depending on the age group of the child
 */
public final class AverageScoreStrategyFactory {
    /**
     * the factory instance of the strategy will be created using the
     * lazy singleton design pattern
     */
    private static AverageScoreStrategyFactory instance = null;

    /**
     * The private constructor, essential for the singleton pattern
     */
    private AverageScoreStrategyFactory() { }

    /**
     * Create if not already existing and return the instance of the factory
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
    public static boolean isBetween(final int number, final int lowerLimit, final int upperLimit) {
        return lowerLimit <= number && number <= upperLimit;
    }

    /**
     * Returns the strategy which should be used for a given child,
     * depending on its age group
     * @param child the to-be-tested child
     * @return the strategy suited for the child's age
     */
    public AverageScoreStrategy createAverageScoreStrategy(final Child child) {
        if (isBetween(child.getAge(), Constants.BABY_LOWER_VALUE, Constants.BABY_UPPER_VALUE)) {
            return new BabyAverageScoreStrategy();
        }
        if (isBetween(child.getAge(), Constants.CHILD_LOWER_VALUE, Constants.CHILD_UPPER_VALUE)) {
            return new KidAverageScoreStrategy();
        }
        if (isBetween(child.getAge(), Constants.TEEN_LOWER_VALUE, Constants.TEEN_UPPER_VALUE)) {
            return new TeenAverageScoreStrategy();
        }
        return null;
    }
}
