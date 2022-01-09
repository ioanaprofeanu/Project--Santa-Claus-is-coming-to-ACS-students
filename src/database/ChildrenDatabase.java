package database;

import common.Constants;
import entities.Child;
import fileio.input.ChildInput;
import fileio.input.ChildUpdatesInput;
import fileio.input.SimulationDataInput;
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

    public ChildrenDatabase(final SimulationDataInput simulationDataInput) {
        this.children = new ArrayList<>();
        addChildren(simulationDataInput.getInitialData().getChildren());
    }

    /**
     * Adds an input list of children to the list of all children
     * used both for the initial simulation and the year simulation
     * @param childrenInput the input list of children
     */
    public void addChildren(final List<ChildInput> childrenInput) {
        if (childrenInput == null) {
            return;
        }
        for (ChildInput childInput : childrenInput) {
            if (childInput.getAge() <= Constants.TEEN_UPPER_VALUE) {
                Child child = new Child(childInput);
                children.add(child);
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
                                childUpdatesInput.getGiftsPreferences());
            }
        }
    }

    public List<Child> getChildren() {
        return children;
    }

    public void setChildren(final List<Child> children) {
        this.children = children;
    }

    @Override
    public String toString() {
        return "ChildrenDatabase{"
                + "children=" + children
                + '}';
    }
}