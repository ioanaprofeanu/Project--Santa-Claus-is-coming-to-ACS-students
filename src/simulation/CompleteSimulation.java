package simulation;

import average.score.strategy.AverageScoreStrategyFactory;
import database.SantaDatabase;
import fileio.input.SimulationDataInput;
import fileio.output.AllYearsChildrenOutput;

public class CompleteSimulation implements Simulation {
    /**
     * the number of years the simulation is run in
     */
    private int numberOfYears;

    public CompleteSimulation(SimulationDataInput simulationDataInput) {
        this.numberOfYears = simulationDataInput.getNumberOfYears();
    }

    @Override
    public void makeSimulation(SantaDatabase santaDatabase, AllYearsChildrenOutput allYearsChildrenOutput) {
        // make the initial part of the simulation
        InitialSimulation initialSimulation = new InitialSimulation();
        initialSimulation.makeSimulation(santaDatabase, allYearsChildrenOutput);
    }
}
