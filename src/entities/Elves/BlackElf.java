package entities.Elves;

import common.Constants;

public class BlackElf extends Elf {
    public BlackElf(String color) {
        super(color);
    }

    @Override
    public double budgetChange(double childBudget) {
        return - childBudget * Constants.THIRTY / Constants.ONE_HUNDRED;
    }
}
