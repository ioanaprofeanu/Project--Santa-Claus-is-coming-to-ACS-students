package updatecommands;

import database.ChildrenDatabase;
import fileio.input.AnnualChangesInput;

/**
 * The class which contains the concrete command which updates given children
 * from the list of children within the database
 */
public class UpdateChildrenCommand implements Command {
    /**
     * instance of the object the command will be performed on
     */
    private final ChildrenDatabase childrenDatabase;

    public UpdateChildrenCommand(final ChildrenDatabase childrenDatabase) {
        this.childrenDatabase = childrenDatabase;
    }

    /**
     * Execute the command which updates information about certain
     * children from list within the database
     * @param annualChangesInput the input annual changes
     */
    @Override
    public void execute(final AnnualChangesInput annualChangesInput) {
        childrenDatabase.updateChildrenById(annualChangesInput.getChildrenUpdates());
    }
}
