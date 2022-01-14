package entities.Elves;

import database.GiftsDatabase;
import entities.Child;
import entities.Gift;

import java.util.ArrayList;
import java.util.List;

/**
 * Actions performed by the yellow elf
 */
public class YellowElf extends Elf {
    /**
     * The yellow elf does not change the budget in any way
     * @param childBudget the child's budget
     * @return it will return 0, which will not affect the child's budget
     */
    @Override
    public double budgetChange(final double childBudget) {
        return 0;
    }

    /**
     * If a child has not received any gifts, the yellow elf will give him
     * the cheapest gift within his favourite category
     * @param child the current child
     * @param giftsDatabase the gifts database
     */
    @Override
    public void giveBonusGift(final Child child, final GiftsDatabase giftsDatabase) {
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
                    // decrease the gift's quantity
                    cheapestGift.decreaseQuantity();
                    child.setReceivedGifts(newReceivedGift);
                }
            }
        }
    }
}
