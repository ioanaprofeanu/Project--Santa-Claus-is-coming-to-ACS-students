package entities.Elves;

import common.Constants;

public class PinkElf extends Elf {
    public PinkElf(String color) {
        super(color);
    }

    @Override
    public double budgetChange(double childBudget) {
        return childBudget * Constants.THIRTY / Constants.ONE_HUNDRED;
    }
}
