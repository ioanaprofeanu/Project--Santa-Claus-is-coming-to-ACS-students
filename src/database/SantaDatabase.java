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
     * database of children
     */
    private final ChildrenDatabase childrenDatabase;
    /**
     * database of gifts
     */
    private final GiftsDatabase giftsDatabase;
    /**
     * database of cities
     */
    private final CitiesDatabase citiesDatabase;

    public SantaDatabase(final SimulationDataInput simulationDataInput) {
        this.santaBudget = simulationDataInput.getSantaBudget();
        this.citiesDatabase = new CitiesDatabase();
        this.childrenDatabase = new ChildrenDatabase(simulationDataInput,
                citiesDatabase);
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

    public CitiesDatabase getCitiesDatabase() {
        return citiesDatabase;
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
