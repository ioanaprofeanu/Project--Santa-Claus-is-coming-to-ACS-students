package fileio.input;

import java.util.List;

/**
 * Information about the changes made in one year retrieved from parsing
 * the input file
 */
public class AnnualChangesInput {
    /**
     * the new budget
     */
    private double newSantaBudget;
    /**
     * list of to-be-added new gifts
     */
    private List<GiftInput> newGifts;
    /**
     * list of to-be-added new children
     */
    private List<ChildInput> newChildren;
    /**
     * list of updates to be made for certain children
     */
    private List<ChildUpdatesInput> childrenUpdates;

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

    @Override
    public String toString() {
        return "AnnualChangesInput{" +
                "newSantaBudget=" + newSantaBudget +
                ", newGifts=" + newGifts +
                ", newChildren=" + newChildren +
                ", childrenUpdates=" + childrenUpdates +
                '}';
    }
}
