package command;

import database.ChildrenDatabase;
import database.SantaDatabase;
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
     * @param santaDatabase Santa's database
     */
    @Override
    public void execute(final AnnualChangesInput annualChangesInput,
                        final SantaDatabase santaDatabase) {
        childrenDatabase.updateChildrenById(annualChangesInput.getChildrenUpdates());
    }
}
