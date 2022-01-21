package entities.Elves;

import database.GiftsDatabase;
import entities.Child;

/**
 * Class which contains the actions made by a basic elf
 */
public abstract class Elf {
    /**
     * Abstract method which returns the change of budget according to
     * the elf's color
     * @param childBudget the child's budget
     */
    public abstract double budgetChange(double childBudget);

    /**
     * Gives a certain child a bonus gift, in case of not receiving
     * any from Santa; overridden by the yellow elf;
     * for the other elves, it has no effect over the child's assigned gifts
     * @param child the current child
     * @param giftsDatabase the gifts database
     */
    public void giveBonusGift(final Child child, final GiftsDatabase giftsDatabase) {
    }

}
