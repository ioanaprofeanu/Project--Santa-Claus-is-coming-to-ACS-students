package database;

import common.Constants;
import entities.Child;
import fileio.input.ChildInput;
import fileio.input.ChildUpdatesInput;
import fileio.input.SimulationDataInput;
import strategy.averagescore.AverageScoreStrategyFactory;
import utils.Comparators;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * Database which contains a list of all children and methods regarding changes to the list
 */
public final class ChildrenDatabase {
    /**
     * List of all children
     */
    private List<Child> children;

    public ChildrenDatabase(final SimulationDataInput simulationDataInput,
                            CitiesDatabase citiesDatabase) {
        this.children = new ArrayList<>();
        addChildren(simulationDataInput.getInitialData().getChildren(), citiesDatabase);
    }

    /**
     * Adds an input list of children to the list of all children
     * used both for the initial simulation and the year simulation
     * @param childrenInput the input list of children
     */
    public void addChildren(final List<ChildInput> childrenInput,
                            CitiesDatabase citiesDatabase) {
        if (childrenInput == null) {
            return;
        }
        for (ChildInput childInput : childrenInput) {
            if (childInput.getAge() <= Constants.TEEN_UPPER_VALUE) {
                Child child;
                if (childInput.getNiceScoreBonus() == 0) {
                    child = new Child.ChildBuilder(childInput.getId(), childInput.getLastName(),
                            childInput.getFirstName(), childInput.getCity(), childInput.getAge(),
                            childInput.getGiftsPreferences(), childInput.getNiceScore(),
                            childInput.getElf()).buildChild();
                } else {
                    child = new Child.ChildBuilder(childInput.getId(), childInput.getLastName(),
                            childInput.getFirstName(), childInput.getCity(), childInput.getAge(),
                            childInput.getGiftsPreferences(), childInput.getNiceScore(),
                            childInput.getElf()).addNiceScoreBonus(childInput.getNiceScoreBonus())
                            .buildChild();
                }
                children.add(child);
                citiesDatabase.addToCitiesList(child);
            }
        }
        // sort the list in ascending order by id
        Collections.sort(this.children, new Comparators.SortChildrenByIdAsc());
    }

    /**
     * Remove all young adults from the list of children
     */
    public void removeYoungAdults() {
        children.removeIf(child -> child.getAge() > Constants.TEEN_UPPER_VALUE);
    }

    /**
     * Increase the age of all children from the list of children
     */
    public void increaseChildrenAge() {
        for (Child child : children) {
            child.getOlder();
        }
    }

    /**
     * For each child, calculate the average nice score using the factory and strategy patterns
     */
    public void calculateAverageScores() {
        for (Child child : children) {
            child.calculateAverageScore(Objects.requireNonNull(AverageScoreStrategyFactory
                    .getInstance().createAverageScoreStrategy(child)));
        }
    }

    /**
     * Retrieve the child which has a given id
     * @param id the given id
     * @return the found child
     */
    private Child getChildById(final int id) {
        for (Child child : children) {
            if (child.getId() == id) {
                return child;
            }
        }
        return null;
    }

    /**
     * Update all children from the list of children updates
     * @param childrenUpdates list of to-be-updated children
     */
    public void updateChildrenById(final List<ChildUpdatesInput> childrenUpdates) {
        if (childrenUpdates == null) {
            return;
        }
        for (ChildUpdatesInput childUpdatesInput : childrenUpdates) {
            if (getChildById(childUpdatesInput.getId()) != null) {
                Objects.requireNonNull(getChildById(childUpdatesInput.getId())).
                        updateChild(childUpdatesInput.getNiceScore(),
                                childUpdatesInput.getGiftsPreferences(),
                                childUpdatesInput.getElf());
            }
        }
    }

    public List<Child> getChildren() {
        return children;
    }

    public void setChildren(final List<Child> children) {
        this.children = children;
    }
}
