package main;

import average.score.strategy.AverageScoreStrategyFactory;
import checker.Checker;
import common.Constants;
import database.SantaDatabase;
import fileio.input.InputLoader;
import fileio.input.SimulationDataInput;
import fileio.output.AllYearsChildrenOutput;
import fileio.output.OutputLoader;
import simulation.CompleteSimulation;

import java.io.File;
import java.io.IOException;

/**
 * Class used to run the code
 */
public final class Main {

    private Main() {
        ///constructor for checkstyle
    }
    /**
     * This method is used to call the checker which calculates the score
     * @param args
     *          the arguments used to call the main method
     */
    public static void main(final String[] args) throws IOException {
        new File(Constants.OUTPUT).mkdirs();
        for (int i = 1; i <= Constants.TESTS_NUMBER; i++) {
            String testPath = Constants.TEST + i + Constants.FILE_EXTENSION;
            InputLoader inputLoader = new InputLoader(testPath);
            // initialise the input object
            SimulationDataInput simulationDataInput = inputLoader.readDataInput();

            // initialise the output object with all children from all the simulation's years
            AllYearsChildrenOutput allYearsChildrenOutput =  new AllYearsChildrenOutput();

            // initialise the database with the values retrieved from the input file
            SantaDatabase santaDatabase = new SantaDatabase(simulationDataInput);

            // make the simulation
            CompleteSimulation completeSimulation = new CompleteSimulation(simulationDataInput);
            completeSimulation.makeSimulation(santaDatabase, allYearsChildrenOutput);
            String outputPath = Constants.OUTPUT_PATH + i + Constants.FILE_EXTENSION;
            OutputLoader outputLoader = new OutputLoader(outputPath ,allYearsChildrenOutput);
            outputLoader.writeDataOutput();
        }

        Checker.calculateScore();
    }
}
