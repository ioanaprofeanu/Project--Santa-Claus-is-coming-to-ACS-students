package command;

import database.ChildrenDatabase;
import database.CitiesDatabase;
import database.SantaDatabase;
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
    /**
     * instance of the object the command will be performed on
     */
    private final CitiesDatabase citiesDatabase;

    public RemoveYoungAdultsCommand(final ChildrenDatabase childrenDatabase, final CitiesDatabase citiesDatabase) {
        this.childrenDatabase = childrenDatabase;
        this.citiesDatabase = citiesDatabase;
    }

    /**
     * Execute the command which removes children from list within the database
     * @param annualChangesInput the input annual changes
     */
    @Override
    public void execute(final AnnualChangesInput annualChangesInput,
                        SantaDatabase santaDatabase) {
        childrenDatabase.removeYoungAdults();
        citiesDatabase.removeCitiesYoungAdults();
    }
}
