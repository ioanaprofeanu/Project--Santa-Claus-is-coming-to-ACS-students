package commands;

import database.ChildrenDatabase;
import fileio.input.AnnualChangesInput;
import fileio.input.SimulationDataInput;

public class AddNewChildrenCommand implements Command {
    /**
     * instance of the object the command will be performed on
     */

    private ChildrenDatabase childrenDatabase;

    public AddNewChildrenCommand(ChildrenDatabase childrenDatabase) {
        this.childrenDatabase = childrenDatabase;
    }

    @Override
    public void execute(AnnualChangesInput annualChangesInput) {
        childrenDatabase.addChildren(annualChangesInput.getNewChildren());
    }
}
