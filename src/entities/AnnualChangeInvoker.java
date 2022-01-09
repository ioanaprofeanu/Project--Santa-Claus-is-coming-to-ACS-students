package entities;

import commands.Command;
import fileio.input.AnnualChangesInput;

/**
 * The invoker used to initiating the request commands for making the
 * annual changes
 */
public class AnnualChangeInvoker {
    /**
     * the to-be-executed command
     */
    private Command annualChangeCommand;

    public AnnualChangeInvoker(final Command annualChangeCommand) {
        this.annualChangeCommand = annualChangeCommand;
    }

    /**
     * Set off the command
     * @param annualChangesInput the input annual changes
     */
    public void makeChange(final AnnualChangesInput annualChangesInput) {
        annualChangeCommand.execute(annualChangesInput);
    }
}
