package entities;

import commands.Command;
import fileio.input.AnnualChangesInput;
import fileio.input.SimulationDataInput;

public class AnnualChangeInvoker {
    /**
     * the to-be-executed command
     */
    Command annualChangeCommand;

    public AnnualChangeInvoker(Command annualChangeCommand) {
        this.annualChangeCommand = annualChangeCommand;
    }

    public void makeChange(AnnualChangesInput annualChangesInput) {
        annualChangeCommand.execute(annualChangesInput);
    }
}
