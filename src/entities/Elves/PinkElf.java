package entities.Elves;

import common.Constants;

public class PinkElf extends Elf {
    public PinkElf(String color) {
        super(color);
    }

    @Override
    public double budgetChange(double childBudget) {
        double percentage = (double) Constants.THIRTY / Constants.ONE_HUNDRED;
        return percentage * childBudget;
    }
}
