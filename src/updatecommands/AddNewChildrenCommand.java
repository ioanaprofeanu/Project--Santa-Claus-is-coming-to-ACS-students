package updatecommands;

import database.ChildrenDatabase;
import fileio.input.AnnualChangesInput;

/**
 * The class which contains the concrete command which adds new children
 * to the list of children within the database
 */
public class AddNewChildrenCommand implements Command {
    /**
     * Instance of the object the command will be performed on
     */
    private final ChildrenDatabase childrenDatabase;

    public AddNewChildrenCommand(final ChildrenDatabase childrenDatabase) {
        this.childrenDatabase = childrenDatabase;
    }

    /**
     * Execute the command which adds children to the list within the database
     * @param annualChangesInput the input annual changes
     */
    @Override
    public void execute(final AnnualChangesInput annualChangesInput) {
        childrenDatabase.addChildren(annualChangesInput.getNewChildren());
    }
}
