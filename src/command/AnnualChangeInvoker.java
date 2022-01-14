package command;

import database.SantaDatabase;
import fileio.input.AnnualChangesInput;

/**
 * The invoker used to initiating the request commands for making the
 * annual changes
 */
public class AnnualChangeInvoker {
    /**
     * the to-be-executed command
     */
    private final Command annualChangeCommand;

    public AnnualChangeInvoker(final Command annualChangeCommand) {
        this.annualChangeCommand = annualChangeCommand;
    }

    /**
     * Set off the command
     * @param annualChangesInput the input annual changes
     * @param santaDatabase Santa's database
     */
    public void makeChange(final AnnualChangesInput annualChangesInput,
                           final SantaDatabase santaDatabase) {
        annualChangeCommand.execute(annualChangesInput, santaDatabase);
    }
}
