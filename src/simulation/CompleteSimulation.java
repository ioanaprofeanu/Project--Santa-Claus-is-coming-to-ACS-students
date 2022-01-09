package simulation;

import commands.AddNewChildrenCommand;
import commands.IncreaseChildrenAgeCommand;
import commands.RemoveYoungAdultsCommand;
import commands.UpdateChildrenCommand;
import commands.AddNewGiftsCommand;
import database.SantaDatabase;
import entities.AnnualChangeInvoker;
import fileio.input.AnnualChangesInput;
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
    private final int numberOfYears;
    /**
     * the number of years the simulation is run in
     */
    private int currentSimulationYear;
    /**
     *  The database with the values about children and gifts
     *  retrieved from the input file
     */
    private final SantaDatabase santaDatabase;

    public CompleteSimulation(final SimulationDataInput simulationDataInput) {
        this.numberOfYears = simulationDataInput.getNumberOfYears();
        this.santaDatabase = new SantaDatabase(simulationDataInput);
        this.currentSimulationYear = 0;
    }

    /**
     * Perform the simulation by binding together the two parts of it (the initial
     * and the yearly simulations)
     * @param simulationDataInput the input data
     * @param allYearsChildrenOutput the output data
     */
    @Override
    public void makeSimulation(final SimulationDataInput simulationDataInput,
                               final AllYearsChildrenOutput allYearsChildrenOutput) {
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
        /**
         * Perform the initial simulation
         * @param simulationDataInput the input data
         * @param allYearsChildrenOutput the output data
         */
        @Override
        public void makeSimulation(final SimulationDataInput simulationDataInput,
                                   final AllYearsChildrenOutput allYearsChildrenOutput) {
            // assign the gifts
            super.makeSimulation(santaDatabase);
            AnnualChildrenOutput initialChildrenOutput =
                    new AnnualChildrenOutput(santaDatabase.getChildrenDatabase().getChildren());
            allYearsChildrenOutput.getAnnualChildren().add(initialChildrenOutput);
        }
    }

    /**
     * Class which provides the implementation of a yearly simulation
     */
    private class YearSimulation extends GiftAssigmentSimulation implements Simulation {
        /**
         * Perform a yearly simulation
         * @param simulationDataInput the input data
         * @param allYearsChildrenOutput the output data
         */
        @Override
        public void makeSimulation(final SimulationDataInput simulationDataInput,
                                   final AllYearsChildrenOutput allYearsChildrenOutput) {
            AnnualChangesInput annualChangesInput =
                    simulationDataInput.getAnnualChanges().get(currentSimulationYear);
            // change Santa's budget
            santaDatabase.setSantaBudget(annualChangesInput.getNewSantaBudget());

            // increase all children's ages
            // IncreaseChildrenAgeCommand contains the command to increase the ages of all children
            // When execute() is called on this object,
            // it will execute the method increaseChildrenAge() in ChildrenDatabase
            IncreaseChildrenAgeCommand increaseAgeCommand =
                    new IncreaseChildrenAgeCommand(santaDatabase.getChildrenDatabase());
            // Instantiate the invoker and give the command as constructor parameter
            AnnualChangeInvoker annualChangeInvoker =
                    new AnnualChangeInvoker(increaseAgeCommand);
            // When makeChange() is called, the increaseAge.execute() is performed
            annualChangeInvoker.makeChange(annualChangesInput);

            // remove all young adults
            RemoveYoungAdultsCommand removeYoungAdultsCommand =
                    new RemoveYoungAdultsCommand(santaDatabase.getChildrenDatabase());
            annualChangeInvoker = new AnnualChangeInvoker(removeYoungAdultsCommand);
            annualChangeInvoker.makeChange(annualChangesInput);

            // add new children
            AddNewChildrenCommand addNewChildrenCommand =
                    new AddNewChildrenCommand(santaDatabase.getChildrenDatabase());
            annualChangeInvoker = new AnnualChangeInvoker(addNewChildrenCommand);
            annualChangeInvoker.makeChange(annualChangesInput);

            // update children
            UpdateChildrenCommand updateChildrenCommand =
                    new UpdateChildrenCommand(santaDatabase.getChildrenDatabase());
            annualChangeInvoker = new AnnualChangeInvoker(updateChildrenCommand);
            annualChangeInvoker.makeChange(annualChangesInput);

            // add new gifts
            AddNewGiftsCommand addNewGiftsCommand =
                    new AddNewGiftsCommand(santaDatabase.getGiftsDatabase());
            annualChangeInvoker = new AnnualChangeInvoker(addNewGiftsCommand);
            annualChangeInvoker.makeChange(annualChangesInput);

            // assign the gifts
            super.makeSimulation(santaDatabase);

            // add the children list to the output list of children from all years
            AnnualChildrenOutput yearlyChildrenOutput =
                    new AnnualChildrenOutput(santaDatabase.getChildrenDatabase().getChildren());
            allYearsChildrenOutput.getAnnualChildren().add(yearlyChildrenOutput);
        }
    }
}
