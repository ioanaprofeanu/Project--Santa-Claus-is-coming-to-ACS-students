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

    public void setNewSantaBudget(final double newSantaBudget) {
        this.newSantaBudget = newSantaBudget;
    }

    public List<GiftInput> getNewGifts() {
        return newGifts;
    }

    public void setNewGifts(final List<GiftInput> newGifts) {
        this.newGifts = newGifts;
    }

    public List<ChildInput> getNewChildren() {
        return newChildren;
    }

    public void setNewChildren(final List<ChildInput> newChildren) {
        this.newChildren = newChildren;
    }

    public List<ChildUpdatesInput> getChildrenUpdates() {
        return childrenUpdates;
    }

    public void setChildrenUpdates(final List<ChildUpdatesInput> childrenUpdates) {
        this.childrenUpdates = childrenUpdates;
    }

    public String getStrategy() {
        return strategy;
    }

    public void setStrategy(final String strategy) {
        this.strategy = strategy;
    }
}
