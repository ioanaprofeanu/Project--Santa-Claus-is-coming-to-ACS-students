package updatecommands;

import database.GiftsDatabase;
import fileio.input.AnnualChangesInput;

/**
 * The class which contains the concrete command which adds new gifts
 * to the list of gifts within the database
 */
public class AddNewGiftsCommand implements Command {
    /**
     * instance of the object the command will be performed on
     */
    private final GiftsDatabase giftsDatabase;

    public AddNewGiftsCommand(final GiftsDatabase giftsDatabase) {
        this.giftsDatabase = giftsDatabase;
    }

    /**
     * Execute the command which adds gifts to the list within the database
     * @param annualChangesInput the input annual changes
     */
    @Override
    public void execute(final AnnualChangesInput annualChangesInput) {
        giftsDatabase.addGifts(annualChangesInput.getNewGifts());
    }
}
