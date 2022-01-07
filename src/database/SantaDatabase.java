package database;

import fileio.input.SimulationDataInput;

public class SantaDatabase {
    /**
     * santa's budget
     */
    private double santaBudget;
    /**
     * list of all children
     */
    private ChildrenDatabase childrenDatabase;
    /**
     * map of gifts with category as key and the list of
     * gifts sorted in ascending order by price as value
     */
    private GiftsDatabase giftsDatabase;

    public SantaDatabase(SimulationDataInput simulationDataInput) {
        this.santaBudget = simulationDataInput.getSantaBudget();
        this.childrenDatabase = new ChildrenDatabase(simulationDataInput);
        this.giftsDatabase = new GiftsDatabase(simulationDataInput);
    }

    public double getSantaBudget() {
        return santaBudget;
    }

    public void setSantaBudget(double santaBudget) {
        this.santaBudget = santaBudget;
    }

    public ChildrenDatabase getChildrenDatabase() {
        return childrenDatabase;
    }

    public void setChildrenDatabase(ChildrenDatabase childrenDatabase) {
        this.childrenDatabase = childrenDatabase;
    }

    public GiftsDatabase getGiftsDatabase() {
        return giftsDatabase;
    }

    public void setGiftsDatabase(GiftsDatabase giftsDatabase) {
        this.giftsDatabase = giftsDatabase;
    }

    @Override
    public String toString() {
        return "SantaDatabase{" +
                "santaBudget=" + santaBudget +
                ", childrenDatabase=" + childrenDatabase +
                ", giftsDatabase=" + giftsDatabase +
                '}';
    }
}
