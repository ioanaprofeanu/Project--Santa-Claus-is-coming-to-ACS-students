package entities.Elves;

import database.GiftsDatabase;
import entities.Child;
import entities.Gift;

import java.util.ArrayList;
import java.util.List;

public class YellowElf extends Elf {
    public YellowElf(String color) {
        super(color);
    }

    @Override
    public double budgetChange(double childBudget) {
        return 0;
    }

    @Override
    public void giveBonusGift(Child child, GiftsDatabase giftsDatabase) {
        String childFavouriteCategory = child.getGiftsPreferences().get(0);
        List<Gift> newReceivedGift = new ArrayList<>();

        // if the child has not received any gifts
        if (child.getReceivedGifts().size() == 0) {
            // if the favourite category exists in Santa's gift database
            if (giftsDatabase.getGifts().containsKey(childFavouriteCategory)) {
                // get the cheapest gift
                Gift cheapestGift = giftsDatabase.getGifts().get(childFavouriteCategory).get(0);
                // if the gift is still available
                if (cheapestGift.getQuantity() > 0) {
                    // add the gift to the child's list of received gifts
                    newReceivedGift.add(cheapestGift);
                    cheapestGift.decreaseQuantity();
                    child.setReceivedGifts(newReceivedGift);
                }
            }
        }
    }
}
