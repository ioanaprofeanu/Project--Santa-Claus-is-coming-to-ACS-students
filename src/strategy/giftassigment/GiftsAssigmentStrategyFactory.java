package strategy.giftassigment;

import common.Constants;

/**
 * Implementation of the factory design pattern for creating the gift assigment strategies,
 * depending on the received type of strategy
 */
public final class GiftsAssigmentStrategyFactory {
    /**
     * the factory instance of the strategy will be created using the
     * lazy singleton design pattern
     */
    private static GiftsAssigmentStrategyFactory instance = null;

    /**
     * The private constructor, essential for the singleton pattern
     */
    private GiftsAssigmentStrategyFactory() { }

    /**
     * Create if not already existing and return the instance of the factory
     * @return the factory instance
     */
    public static GiftsAssigmentStrategyFactory getInstance() {
        if (instance == null) {
            instance = new GiftsAssigmentStrategyFactory();
        }
        return instance;
    }

    /**
     * Returns the strategy which will be used for distributing the gifts
     * @param strategyType the strategy type
     * @return new instance of the wanted strategy
     */
    public GiftsAssigmentStrategy createGiftsAssigmentStrategy(final String strategyType) {
        switch (strategyType) {
            case Constants.ID: return new IdGiftsAssigmentStrategy();
            case Constants.NICE_SCORE: return new NiceScoreGiftsAssigmentStrategy();
            case Constants.NICE_SCORE_CITY: return new NiceScoreCityGiftAssigmentStrategy();
            default: return null;
        }
    }
}
