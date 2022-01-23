package entities.Elves;

import common.Constants;

/**
 * Actions performed by the black elf
 */
public final class BlackElf extends Elf {
    /**
     * Get the budget change made by the black elf
     * @param childBudget the child's budget
     * @return the amount which will be subtracted from the child's budget
     */
    @Override
    public double budgetChange(final double childBudget) {
        return -childBudget * Constants.THIRTY / Constants.ONE_HUNDRED;
    }
}
