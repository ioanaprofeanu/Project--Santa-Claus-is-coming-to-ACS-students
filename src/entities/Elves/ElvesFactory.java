package entities.Elves;

import common.Constants;

/**
 * Implementation of the factory design pattern for creating the instances of elves,
 * depending on the given elf color
 */
public final class ElvesFactory {
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
    public Elf createElf(final String color) {
        return switch (color) {
            case Constants.WHITE -> new WhiteElf();
            case Constants.BLACK -> new BlackElf();
            case Constants.PINK -> new PinkElf();
            case Constants.YELLOW -> new YellowElf();
            default -> null;
        };
    }
}
