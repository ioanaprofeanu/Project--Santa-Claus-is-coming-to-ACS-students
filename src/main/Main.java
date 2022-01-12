package main;

import checker.Checker;
import common.Constants;
import fileio.input.InputLoader;
import fileio.input.SimulationDataInput;
import fileio.output.AllYearsChildrenOutput;
import fileio.output.OutputLoader;
import simulation.CompleteSimulation;

import java.io.File;

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
    public static void main(final String[] args) {
        // create the output directory
        new File(Constants.OUTPUT).mkdirs();

        // iterate through the input tests
        for (int i = 1; i <= Constants.TESTS_NUMBER; i++) {
            // load the input data
            String testPath = Constants.TEST + i + Constants.FILE_EXTENSION;
            InputLoader inputLoader = new InputLoader(testPath);
            // initialise the input object
            SimulationDataInput simulationDataInput = inputLoader.readDataInput();
            // initialise the output object with all children from all the simulation's years
            AllYearsChildrenOutput allYearsChildrenOutput = new AllYearsChildrenOutput();

            // make the simulation
            assert simulationDataInput != null;
            CompleteSimulation completeSimulation = new CompleteSimulation(simulationDataInput);
            completeSimulation.makeSimulation(simulationDataInput, allYearsChildrenOutput);

            // write the output
            String outputPath = Constants.OUTPUT_PATH + i + Constants.FILE_EXTENSION;
            OutputLoader outputLoader = new OutputLoader(outputPath, allYearsChildrenOutput);
            outputLoader.writeDataOutput();
        }
        Checker.calculateScore();
    }
}
