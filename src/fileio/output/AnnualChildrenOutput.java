package fileio.output;

import entities.ChildAnnualData;

import java.util.List;

public class AnnualChildrenOutput {
    /**
     * List of children from one year of the simulation
     */
    private List<ChildAnnualData> children;

    public AnnualChildrenOutput(List<ChildAnnualData> children) {
        this.children = children;
    }

    public List<ChildAnnualData> getChildren() {
        return children;
    }

    public void setChildren(List<ChildAnnualData> children) {
        this.children = children;
    }
}
