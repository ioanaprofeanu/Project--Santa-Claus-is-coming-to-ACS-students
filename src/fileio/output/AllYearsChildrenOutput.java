package fileio.output;

import java.util.ArrayList;
import java.util.List;

/**
 * Class which contains the list of annual children
 */
public final class AllYearsChildrenOutput {
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

    public void setAnnualChildren(final List<AnnualChildrenOutput> annualChildren) {
        this.annualChildren = annualChildren;
    }
}
