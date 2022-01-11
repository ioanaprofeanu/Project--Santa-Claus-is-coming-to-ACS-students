package entities.Elves;

import database.GiftsDatabase;
import entities.Child;

public abstract class Elf {
    /**
     * the color of the elf
     */
    private String color;

    public Elf(String color) {
        this.color = color;
    }

    /**
     * Abstract method which returns the change of budget according to
     * the elf's color
     * @param childBudget the child's budget
     */
    public abstract double budgetChange(double childBudget);

    /**
     * Gives a certain child a bonus gift, in case of not receiving
     * any from Santa; used by the yellow elf
     * @param child the current child
     * @param giftsDatabase the gifts database
     */
    public void giveBonusGift(Child child, GiftsDatabase giftsDatabase) {
    }
}
