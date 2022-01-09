package simulation;

import fileio.input.SimulationDataInput;
import fileio.output.AllYearsChildrenOutput;

/**
 * Interface for the program's simulations
 */
public interface Simulation {
    /**
     * Perform the simulation
     * @param simulationDataInput the input data
     * @param allYearsChildrenOutput the output data
     */
    void makeSimulation(SimulationDataInput simulationDataInput,
                        AllYearsChildrenOutput allYearsChildrenOutput);
}
