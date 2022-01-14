package command;

import database.ChildrenDatabase;
import database.CitiesDatabase;
import database.SantaDatabase;
import fileio.input.AnnualChangesInput;

/**
 * The class which contains the concrete command which removes the young
 * adults from the list of children and the list of children from certain
 * cities within the database
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

    public RemoveYoungAdultsCommand(final ChildrenDatabase childrenDatabase,
                                    final CitiesDatabase citiesDatabase) {
        this.childrenDatabase = childrenDatabase;
        this.citiesDatabase = citiesDatabase;
    }

    /**
     * Execute the commands which remove young adults from list of children
     * and the list of children from cities within the database
     * @param annualChangesInput the input annual changes
     * @param santaDatabase Santa's database
     */
    @Override
    public void execute(final AnnualChangesInput annualChangesInput,
                        final SantaDatabase santaDatabase) {
        childrenDatabase.removeYoungAdults();
        citiesDatabase.removeCitiesYoungAdults();
    }
}
