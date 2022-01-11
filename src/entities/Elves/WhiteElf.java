package entities.Elves;

public class WhiteElf extends Elf {
    public WhiteElf(String color) {
        super(color);
    }

    @Override
    public double budgetChange(double childBudget) {
        return 0;
    }
}
