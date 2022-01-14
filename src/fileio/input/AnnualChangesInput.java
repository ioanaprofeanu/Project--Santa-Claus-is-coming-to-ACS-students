package fileio.input;

import java.util.List;

/**
 * Information about the changes made in one year retrieved from parsing
 * the input file
 */
public final class AnnualChangesInput {
    /**
     * The new budget
     */
    private double newSantaBudget;
    /**
     * List of to-be-added new gifts
     */
    private List<GiftInput> newGifts;
    /**
     * List of to-be-added new children
     */
    private List<ChildInput> newChildren;
    /**
     * List of updates to be made for certain children
     */
    private List<ChildUpdatesInput> childrenUpdates;
    /**
     * The gift assigment strategy
     */
    private String strategy;

    public double getNewSantaBudget() {
        return newSantaBudget;
    }

    public void setNewSantaBudget(double newSantaBudget) {
        this.newSantaBudget = newSantaBudget;
    }

    public List<GiftInput> getNewGifts() {
        return newGifts;
    }

    public void setNewGifts(List<GiftInput> newGifts) {
        this.newGifts = newGifts;
    }

    public List<ChildInput> getNewChildren() {
        return newChildren;
    }

    public void setNewChildren(List<ChildInput> newChildren) {
        this.newChildren = newChildren;
    }

    public List<ChildUpdatesInput> getChildrenUpdates() {
        return childrenUpdates;
    }

    public void setChildrenUpdates(List<ChildUpdatesInput> childrenUpdates) {
        this.childrenUpdates = childrenUpdates;
    }

    public String getStrategy() {
        return strategy;
    }

    public void setStrategy(String strategy) {
        this.strategy = strategy;
    }
}
