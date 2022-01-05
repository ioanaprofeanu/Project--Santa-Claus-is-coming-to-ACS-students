package simulation;

import average.score.strategy.AverageScoreStrategyFactory;
import database.SantaDatabase;
import fileio.output.AllYearsChildrenOutput;
import fileio.output.AnnualChildrenOutput;

public class InitialSimulation extends GiftAssigmentSimulation implements Simulation {
    @Override
    public void makeSimulation(SantaDatabase santaDatabase, AllYearsChildrenOutput allYearsChildrenOutput) {
        calculateAverageScores(santaDatabase);
        setBudgetUnit(santaDatabase);
        setChildrenBudget(santaDatabase);
        assignGifts(santaDatabase);
        AnnualChildrenOutput initialChildrenOutput = new AnnualChildrenOutput(santaDatabase.getChildren());
        allYearsChildrenOutput.getAnnualChildren().add(initialChildrenOutput);
    }
}
