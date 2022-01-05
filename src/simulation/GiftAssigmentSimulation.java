package simulation;

import average.score.strategy.AverageScoreStrategyFactory;
import database.SantaDatabase;
import entities.ChildAnnualData;
import entities.Gift;

/**
 * Abstract class which handles the gift assigment part of the simulation
 */
public abstract class GiftAssigmentSimulation {
    /**
     * Santa's budget unit in the current simulation session
     */
    private double budgetUnit;

    public GiftAssigmentSimulation() {
        this.budgetUnit = 0;
    }

    /**
     * For each child, calculate the average nice score using the factory and strategy patterns
     * @param santaDatabase the main database
     */
    public void calculateAverageScores(SantaDatabase santaDatabase) {
        if (santaDatabase == null) {
            return;
        }
        for (ChildAnnualData child : santaDatabase.getChildren()) {
            child.calculateAverageScore(AverageScoreStrategyFactory.getInstance().createAverageScoreStrategy(child));
        }
    }

    /**
     * Calculate the budget unit of the current simulation session
     * @param santaDatabase the main database
     * @return
     */
    public void setBudgetUnit(SantaDatabase santaDatabase) {
        if (santaDatabase == null) {
            return;
        }
        double sumOfAverageScores = 0;
        for (ChildAnnualData child : santaDatabase.getChildren()) {
            sumOfAverageScores += child.getAverageScore();
        }
        this.budgetUnit = (double) santaDatabase.getSantaBudget() / sumOfAverageScores;
    }

    /**
     * Calculate the assigned Budget for each child
     * @param santaDatabase the main database
     */
    public void setChildrenBudget(SantaDatabase santaDatabase) {
        if (santaDatabase == null) {
            return;
        }
        for (ChildAnnualData child : santaDatabase.getChildren()) {
            child.setAssignedBudget(child.getAverageScore() * this.budgetUnit);
        }
    }

    /**
     * Assign gifts for each child
     * @param santaDatabase the main database
     */
    public void assignGifts(SantaDatabase santaDatabase) {
        if (santaDatabase == null) {
            return;
        }
        for (ChildAnnualData child : santaDatabase.getChildren()) {
            double childAssignedBudget = child.getAssignedBudget();
            for (String giftPreferences : child.getGiftsPreferences()) {
                // if the current gift preference exists in santa's gifts hashmap
                if (santaDatabase.getGifts().containsKey(giftPreferences)) {
                    // the list of gifts is ordered in ascending order by price
                    // so the child may receive the first gift within the gifts list
                    Gift currentGift = santaDatabase.getGifts().get(giftPreferences).get(0);
                    // if the price of the gift is not higher than the remaining budget
                    if (currentGift.getPrice() <= childAssignedBudget) {
                        // add the gift in the child's received gifts list
                        child.getReceivedGifts().add(currentGift);
                        // from the child's assigned budget, subtract the price of the given gift
                        childAssignedBudget -= currentGift.getPrice();
                    }
                }
            }
        }
    }
}
