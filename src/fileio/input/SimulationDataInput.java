package fileio.input;

import fileio.input.AnnualChangesInput;
import fileio.input.InitialDataInput;

import java.util.List;

/**
 * Information about the current simulation, retrieved from parsing the input file
 */
public final class SimulationDataInput {
    /**
     * the number of years the simulation is run in
     */
    private int numberOfYears;
    /**
     * the initial budget
     */
    private double santaBudget;
    /**
     * the initial input data
     */
    private InitialDataInput initialData;
    /**
     * list of annual changes
     */
    private List<AnnualChangesInput> annualChanges;

    public int getNumberOfYears() {
        return numberOfYears;
    }

    public void setNumberOfYears(int numberOfYears) {
        this.numberOfYears = numberOfYears;
    }

    public double getSantaBudget() {
        return santaBudget;
    }

    public void setSantaBudget(double santaBudget) {
        this.santaBudget = santaBudget;
    }

    public InitialDataInput getInitialData() {
        return initialData;
    }

    public void setInitialData(InitialDataInput initialData) {
        this.initialData = initialData;
    }

    public List<AnnualChangesInput> getAnnualChanges() {
        return annualChanges;
    }

    public void setAnnualChanges(List<AnnualChangesInput> annualChanges) {
        this.annualChanges = annualChanges;
    }

    @Override
    public String toString() {
        return "SimulationDataInput{" +
                "numberOfYears=" + numberOfYears +
                ", santaBudget=" + santaBudget +
                ", initialData=" + initialData +
                ", annualChanges=" + annualChanges +
                '}';
    }
}
