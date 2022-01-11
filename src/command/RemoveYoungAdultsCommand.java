package command;

import database.ChildrenDatabase;
import fileio.input.AnnualChangesInput;

/**
 * The class which contains the concrete command which removes the young
 * adults from the list of children within the database
 */
public class RemoveYoungAdultsCommand implements Command {
    /**
     * instance of the object the command will be performed on
     */
    private final ChildrenDatabase childrenDatabase;

    public RemoveYoungAdultsCommand(final ChildrenDatabase childrenDatabase) {
        this.childrenDatabase = childrenDatabase;
    }

    /**
     * Execute the command which removes children from list within the database
     * @param annualChangesInput the input annual changes
     */
    @Override
    public void execute(final AnnualChangesInput annualChangesInput) {
        childrenDatabase.removeYoungAdults();
    }
}
