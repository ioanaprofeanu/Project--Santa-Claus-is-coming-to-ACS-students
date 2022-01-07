package commands;

import database.ChildrenDatabase;
import fileio.input.AnnualChangesInput;

public class UpdateChildrenCommand implements Command {
    /**
     * instance of the object the command will be performed on
     */

    private ChildrenDatabase childrenDatabase;

    public UpdateChildrenCommand(ChildrenDatabase childrenDatabase) {
        this.childrenDatabase = childrenDatabase;
    }

    @Override
    public void execute(AnnualChangesInput annualChangesInput) {
        childrenDatabase.updateChildrenById(annualChangesInput.getChildrenUpdates());
    }
}
