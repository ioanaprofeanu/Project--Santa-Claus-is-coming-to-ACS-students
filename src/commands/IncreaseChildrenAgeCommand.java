package commands;

import database.ChildrenDatabase;
import fileio.input.AnnualChangesInput;

/**
 * The class which contains the concrete command which increases the age of
 * all children within the database
 */
public class IncreaseChildrenAgeCommand implements Command {
    /**
     * instance of the object the command will be performed on
     */
    private ChildrenDatabase childrenDatabase;

    public IncreaseChildrenAgeCommand(final ChildrenDatabase childrenDatabase) {
        this.childrenDatabase = childrenDatabase;
    }

    /**
     * Execute the command which increases the age of all children
     * from the list within the database
     * @param annualChangesInput the input annual changes
     */
    @Override
    public void execute(final AnnualChangesInput annualChangesInput) {
        childrenDatabase.increaseChildrenAge();
    }
}
