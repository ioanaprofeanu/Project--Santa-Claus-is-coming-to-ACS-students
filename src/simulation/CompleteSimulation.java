package simulation;

import database.SantaDatabase;
import entities.Child;
import fileio.input.SimulationDataInput;
import fileio.output.AllYearsChildrenOutput;
import fileio.output.AnnualChildrenOutput;

/**
 * Class which provides the implementation of a complete simulation cycle
 */
public class CompleteSimulation implements Simulation {
    /**
     * the number of years the simulation is run in
     */
    private int numberOfYears;
    /**
     * the number of years the simulation is run in
     */
    private int currentSimulationYear;
    /**
     *  The database with the values about children and gifts
     *  retrieved from the input file
     */
    private SantaDatabase santaDatabase;

    public CompleteSimulation(SimulationDataInput simulationDataInput) {
        this.numberOfYears = simulationDataInput.getNumberOfYears();
        this.santaDatabase = new SantaDatabase(simulationDataInput);
        this.currentSimulationYear = 0;
    }

    @Override
    public void makeSimulation(SimulationDataInput simulationDataInput, AllYearsChildrenOutput allYearsChildrenOutput) {
        // make the initial part of the simulation
        InitialSimulation initialSimulation = new InitialSimulation();
        initialSimulation.makeSimulation(simulationDataInput, allYearsChildrenOutput);

        // iterate through the years and simulate them
        YearSimulation yearSimulation = new YearSimulation();
        for (int i = 0; i < this.numberOfYears; i++) {
            this.currentSimulationYear = i;
            yearSimulation.makeSimulation(simulationDataInput, allYearsChildrenOutput);
        }
    }

    /**
     * Class which provides the implementation of the initial simulation
     */
    private class InitialSimulation extends GiftAssigmentSimulation implements Simulation {
        @Override
        public void makeSimulation(SimulationDataInput simulationDataInput, AllYearsChildrenOutput allYearsChildrenOutput) {
            makeGiftAssigment(santaDatabase);
            AnnualChildrenOutput initialChildrenOutput = new AnnualChildrenOutput(santaDatabase.getChildren());
            allYearsChildrenOutput.getAnnualChildren().add(initialChildrenOutput);
        }
    }

    /**
     * Class which provides the implementation of a yearly simulation
     */
    private class YearSimulation extends GiftAssigmentSimulation implements Simulation{
        @Override
        public void makeSimulation(SimulationDataInput simulationDataInput, AllYearsChildrenOutput allYearsChildrenOutput) {
//            santaDatabase.setSantaBudget(simulationDataInput.getAnnualChanges().get(currentSimulationYear).getNewSantaBudget());
//            makeGiftAssigment(santaDatabase);
//
//            for (ChildAnnualData child : santaDatabase.getChildren()) {
//                child.getOlder();
//            }
//
//            AnnualChildrenOutput yearlyChildrenOutput = new AnnualChildrenOutput(santaDatabase.getChildren());
//            allYearsChildrenOutput.getAnnualChildren().add(yearlyChildrenOutput);
        }
    }
}
