package command;

import database.GiftsDatabase;
import database.SantaDatabase;
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
     * @param santaDatabase Santa's database
     */
    @Override
    public void execute(final AnnualChangesInput annualChangesInput,
                        final SantaDatabase santaDatabase) {
        giftsDatabase.addGifts(annualChangesInput.getNewGifts());
    }
}
