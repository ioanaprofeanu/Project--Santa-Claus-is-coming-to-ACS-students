package commands;

import database.ChildrenDatabase;
import database.GiftsDatabase;
import fileio.input.AnnualChangesInput;

public class AddNewGiftsCommand implements Command {
    /**
     * instance of the object the command will be performed on
     */

    private GiftsDatabase giftsDatabase;

    public AddNewGiftsCommand(GiftsDatabase giftsDatabase) {
        this.giftsDatabase = giftsDatabase;
    }

    @Override
    public void execute(AnnualChangesInput annualChangesInput) {
        giftsDatabase.addGifts(annualChangesInput.getNewGifts());
    }
}
