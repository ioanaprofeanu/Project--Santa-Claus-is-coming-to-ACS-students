package command;

import database.ChildrenDatabase;
import database.SantaDatabase;
import fileio.input.AnnualChangesInput;

/**
 * The class which contains the concrete command which adds new children
 * to the list of all children and the list of children from certain
 * cities within the database
 */
public class AddNewChildrenCommand implements Command {
    /**
     * instance of the object the command will be performed on
     */
    private final ChildrenDatabase childrenDatabase;

    public AddNewChildrenCommand(final ChildrenDatabase childrenDatabase) {
        this.childrenDatabase = childrenDatabase;
    }

    /**
     * Execute the command which adds children to the lists of children and
     * children from cities within the database
     * @param annualChangesInput the input annual changes
     * @param santaDatabase Santa's database
     */
    @Override
    public void execute(final AnnualChangesInput annualChangesInput,
                        final SantaDatabase santaDatabase) {
        childrenDatabase.addChildren(annualChangesInput.getNewChildren(),
                santaDatabase.getCitiesDatabase());
    }
}
