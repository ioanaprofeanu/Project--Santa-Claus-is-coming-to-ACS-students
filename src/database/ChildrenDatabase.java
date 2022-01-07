package database;

import entities.Child;
import fileio.input.ChildInput;
import fileio.input.ChildUpdatesInput;
import fileio.input.SimulationDataInput;
import utils.Comparators;

import java.util.*;

public class ChildrenDatabase {
    /**
     * list of all children
     */
    private List<Child> children;

    public ChildrenDatabase(SimulationDataInput simulationDataInput) {
        this.children = new ArrayList<>();
        addChildren(simulationDataInput.getInitialData().getChildren());
    }

    /**
     * Adds an input list of children to the list of all children
     * used both for the initial simulation and the year simulation
     * @param childrenInput the input list of children
     */
    public void addChildren(List<ChildInput> childrenInput) {
        if (childrenInput == null) {
            return;
        }
        for (ChildInput childInput : childrenInput) {
            if (childInput.getAge() <= 18) {
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
        children.removeIf(child -> child.getAge() > 18);
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
    private Child getChildById(int id) {
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
    public void updateChildrenById(List<ChildUpdatesInput> childrenUpdates) {
        if (childrenUpdates == null) {
            return;
        }
        for (ChildUpdatesInput childUpdatesInput : childrenUpdates) {
            if (getChildById(childUpdatesInput.getId()) != null) {
                getChildById(childUpdatesInput.getId()).updateChild(childUpdatesInput.getNiceScore(), childUpdatesInput.getGiftsPreferences());
            }
        }
    }

    public List<Child> getChildren() {
        return children;
    }

    public void setChildren(List<Child> children) {
        this.children = children;
    }

    @Override
    public String toString() {
        return "ChildrenDatabase{" +
                "children=" + children +
                '}';
    }
}
