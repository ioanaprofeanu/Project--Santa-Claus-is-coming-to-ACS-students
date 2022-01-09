package fileio.output;

import entities.Child;

import java.util.ArrayList;
import java.util.List;

/**
 * Class which contains a list of children from a certain year
 */
public final class AnnualChildrenOutput {
    /**
     * List of children from one year of the simulation
     */
    private List<Child> children;

    public AnnualChildrenOutput(final List<Child> children) {
        // create the new list of children
        this.children = new ArrayList<>();
        // add each child from the initial list to the new one
        for (Child child : children) {
            Child newChild = new Child(child);
            this.children.add(newChild);
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
        return "AnnualChildrenOutput{"
                + "children=" + children
                + '}';
    }
}
