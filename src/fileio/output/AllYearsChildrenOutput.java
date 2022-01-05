package fileio.output;

import entities.ChildAnnualData;

import java.util.ArrayList;
import java.util.List;

public class AllYearsChildrenOutput {
    /**
     * List of children from all years
     */
    private List<AnnualChildrenOutput> annualChildren;

    public AllYearsChildrenOutput() {
        this.annualChildren = new ArrayList<>();
    }

    public List<AnnualChildrenOutput> getAnnualChildren() {
        return annualChildren;
    }

    public void setAnnualChildren(List<AnnualChildrenOutput> annualChildren) {
        this.annualChildren = annualChildren;
    }
}
