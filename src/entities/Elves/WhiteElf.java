package entities.Elves;

/**
 * Actions performed by the white elf
 */
public class WhiteElf extends Elf {
    /**
     * The white elf does not change the budget in any way
     * @param childBudget the child's budget
     * @return it will return 0, which will not affect the child's budget
     */
    @Override
    public double budgetChange(final double childBudget) {
        return 0;
    }
}
