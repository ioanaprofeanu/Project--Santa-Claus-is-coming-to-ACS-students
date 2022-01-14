package entities.Elves;

import common.Constants;

/**
 * Actions performed by the pink elf
 */
public class PinkElf extends Elf {
    /**
     * Get the budget change made by the pink elf
     * @param childBudget the child's budget
     * @return the amount which will be added to the child's budget
     */
    @Override
    public double budgetChange(final double childBudget) {
        return childBudget * Constants.THIRTY / Constants.ONE_HUNDRED;
    }
}
