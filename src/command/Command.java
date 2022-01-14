package command;

import database.SantaDatabase;
import fileio.input.AnnualChangesInput;

/**
 * The command interface
 */
public interface Command {
    /**
     * Method which executes the command
     * @param annualChangesInput the input annual changes
     * @param santaDatabase Santa's database
     */
    void execute(AnnualChangesInput annualChangesInput, SantaDatabase santaDatabase);
}
