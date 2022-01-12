package simulation;

import strategy.averagescore.AverageScoreStrategyFactory;
import database.SantaDatabase;
import entities.Child;
import entities.Gift;
import strategy.giftassigment.GiftsAssigmentStrategyFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Abstract class which handles the gift assigment part of the simulation
 */
public abstract class GiftAssigmentSimulation implements Simulation {
    /**
     * Santa's budget unit in the current simulation session
     */
    private double budgetUnit;

    protected GiftAssigmentSimulation() {
        this.budgetUnit = 0;
    }

    /**
     * Function which executes all operations in order to assign gifts
     * @param santaDatabase the main database
     */
    public void makeSimulation(final SantaDatabase santaDatabase,
                               final String strategyType) {
        calculateAverageScores(santaDatabase);
        setBudgetUnit(santaDatabase);
        setChildrenBudget(santaDatabase);
        assignGifts(santaDatabase, strategyType);
    }

    /**
     * For each child, calculate the average nice score using the factory and strategy patterns
     * @param santaDatabase the main database
     */
    private void calculateAverageScores(final SantaDatabase santaDatabase) {
        if (santaDatabase == null) {
            return;
        }
        for (Child child : santaDatabase.getChildrenDatabase().getChildren()) {
            child.calculateAverageScore(Objects.requireNonNull(AverageScoreStrategyFactory
                    .getInstance().createAverageScoreStrategy(child)));
        }
    }

    /**
     * Calculate the budget unit of the current simulation session
     * @param santaDatabase the main database
     */
    private void setBudgetUnit(final SantaDatabase santaDatabase) {
        if (santaDatabase == null) {
            return;
        }
        double sumOfAverageScores = 0;
        for (Child child : santaDatabase.getChildrenDatabase().getChildren()) {
            sumOfAverageScores += child.getAverageScore();
        }
        this.budgetUnit = santaDatabase.getSantaBudget() / sumOfAverageScores;
    }

    /**
     * Calculate the assigned Budget for each child
     * @param santaDatabase the main database
     */
    private void setChildrenBudget(final SantaDatabase santaDatabase) {
        if (santaDatabase == null) {
            return;
        }
        for (Child child : santaDatabase.getChildrenDatabase().getChildren()) {
            double newBudget = child.getAverageScore() * this.budgetUnit;
            newBudget += child.getElf().budgetChange(newBudget);
            child.setAssignedBudget(newBudget);
        }
    }

    /**
     * Assign gifts for each child
     * @param santaDatabase the main database
     */
    private void assignGifts(final SantaDatabase santaDatabase,
                             final String strategyType) {
        if (santaDatabase == null) {
            return;
        }
        List<Child> childrenList = Objects.requireNonNull(GiftsAssigmentStrategyFactory.getInstance().
                createGiftsAssigmentStrategy(strategyType)).getOrderedChildren(santaDatabase);
        for (Child child : childrenList) {
            double childAssignedBudget = child.getAssignedBudget();
            List<Gift> newReceivedGifts = new ArrayList<>();
            for (String giftPreferences : child.getGiftsPreferences()) {
                // if the current gift preference exists in santa's gifts hashmap
                if (santaDatabase.getGiftsDatabase().getGifts().containsKey(giftPreferences)) {
                    // iterate through the list of gifts ordered in ascending order by price
                    for (Gift currentGift : santaDatabase.getGiftsDatabase().getGifts().get(giftPreferences)) {
                        // if the gift still exists and is within the child's budget
                        if (currentGift.getQuantity() > 0 && currentGift.getPrice() <= childAssignedBudget) {
                            // add the gift in the child's received gifts list
                            newReceivedGifts.add(currentGift);
                            // from the child's assigned budget, subtract the price of the given gift
                            childAssignedBudget -= currentGift.getPrice();
                            // decrease the quantity of the gift
                            currentGift.decreaseQuantity();
                            break;
                        }
                    }
                }
            }
            // set the child's list of received gifts
            child.setReceivedGifts(newReceivedGifts);
            child.getElf().giveBonusGift(child, santaDatabase.getGiftsDatabase());
        }
    }
}
