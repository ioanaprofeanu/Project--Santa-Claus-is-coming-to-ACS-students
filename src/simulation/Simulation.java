package simulation;

import average.score.strategy.AverageScoreStrategyFactory;
import database.SantaDatabase;
import fileio.output.AllYearsChildrenOutput;

public interface Simulation {
    public void makeSimulation(SantaDatabase santaDatabase, AllYearsChildrenOutput allYearsChildrenOutput);
}
