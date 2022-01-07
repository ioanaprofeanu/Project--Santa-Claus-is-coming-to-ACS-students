package commands;

import database.ChildrenDatabase;
import database.SantaDatabase;
import fileio.input.AnnualChangesInput;
import fileio.input.SimulationDataInput;

public class IncreaseChildrenAgeCommand implements Command {
    /**
     * instance of the object the command will be performed on
     */

    private ChildrenDatabase childrenDatabase;

    public IncreaseChildrenAgeCommand(ChildrenDatabase childrenDatabase) {
        this.childrenDatabase = childrenDatabase;
    }

    @Override
    public void execute(AnnualChangesInput annualChangesInput) {
        childrenDatabase.increaseChildrenAge();
    }
}
