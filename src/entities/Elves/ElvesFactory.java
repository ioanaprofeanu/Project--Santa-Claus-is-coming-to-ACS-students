package entities.Elves;

import common.Constants;

public class ElvesFactory {
    /**
     * the factory instance of the strategy will be created using the
     * lazy singleton design pattern
     */
    private static ElvesFactory instance = null;

    /**
     * The private constructor, essential for the singleton pattern
     */
    private ElvesFactory() { }

    /**
     * Create if not already existing and return the instance of the factory
     * @return the factory instance
     */
    public static ElvesFactory getInstance() {
        if (instance == null) {
            instance = new ElvesFactory();
        }
        return instance;
    }

    /**
     * Returns an elf instance depending on the given color
     * @param color thew elf's color
     */
    public Elf createElf(String color) {
        switch (color) {
            case Constants.WHITE: return new WhiteElf(color);
            case Constants.BLACK: return new BlackElf(color);
            case Constants.PINK: return new PinkElf(color);
            case Constants.YELLOW: return new YellowElf(color);
            default: return null;
        }
    }
}
