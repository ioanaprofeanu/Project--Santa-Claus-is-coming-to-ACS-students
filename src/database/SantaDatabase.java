package database;

import fileio.input.SimulationDataInput;

/**
 * Class which contains Santa's databases of children and gifts
 */
public final class SantaDatabase {
    /**
     * santa's budget
     */
    private double santaBudget;
    /**
     * list of all children
     */
    private final ChildrenDatabase childrenDatabase;
    /**
     * map of gifts with category as key and the list of
     * gifts sorted in ascending order by price as value
     */
    private final GiftsDatabase giftsDatabase;

    public SantaDatabase(final SimulationDataInput simulationDataInput) {
        this.santaBudget = simulationDataInput.getSantaBudget();
        this.childrenDatabase = new ChildrenDatabase(simulationDataInput);
        this.giftsDatabase = new GiftsDatabase(simulationDataInput);
    }

    public double getSantaBudget() {
        return santaBudget;
    }

    public void setSantaBudget(final double santaBudget) {
        this.santaBudget = santaBudget;
    }

    public ChildrenDatabase getChildrenDatabase() {
        return childrenDatabase;
    }

    public GiftsDatabase getGiftsDatabase() {
        return giftsDatabase;
    }

    @Override
    public String toString() {
        return "SantaDatabase{"
                + "santaBudget=" + santaBudget
                + ", childrenDatabase=" + childrenDatabase
                + ", giftsDatabase=" + giftsDatabase
                + '}';
    }
}
