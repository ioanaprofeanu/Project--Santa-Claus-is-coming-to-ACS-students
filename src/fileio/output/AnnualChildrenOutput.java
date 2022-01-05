package fileio.output;

import entities.Child;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class AnnualChildrenOutput {
    /**
     * List of children from one year of the simulation
     */
    private List<Child> children;

    public AnnualChildrenOutput(List<Child> children) {
        this.children = new ArrayList<>();
        for (Child child : children) {
            Child newChild = new Child(child);
            this.children.add(newChild);
        }
    }

    public List<Child> getChildren() {
        return children;
    }

    public void setChildren(List<Child> children) {
        this.children = children;
    }
}
