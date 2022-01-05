package simulation;

import fileio.input.SimulationDataInput;
import fileio.output.AllYearsChildrenOutput;

public interface Simulation {
    public void makeSimulation(SimulationDataInput simulationDataInput,
                               AllYearsChildrenOutput allYearsChildrenOutput);
}
