package commands;

import fileio.input.AnnualChangesInput;
import fileio.input.SimulationDataInput;

public interface Command {
    public void execute(AnnualChangesInput annualChangesInput);
}
