package strategy.giftassigment;

import common.Constants;
import database.SantaDatabase;

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

    public GiftsAssigmentStrategy createGiftsAssigmentStrategy(String strategyType) {
        switch (strategyType) {
            case Constants.ID: return new IdGiftsAssigmentStrategy();
            case Constants.NICE_SCORE: return new NiceScoreGiftsAssigmentStrategy();
            case Constants.NICE_SCORE_CITY: return new NiceScoreCityGiftAssigmentStrategy();
            default: return null;
        }
    }
}
