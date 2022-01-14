package fileio.input;

import java.util.List;

/**
 * The initial data retrieved from parsing the input file
 */
public final class InitialDataInput {
    /**
     * List of children received at input
     */
    private List<ChildInput> children;
    /**
     * List of gifts received at input
     */
    private List<GiftInput> santaGiftsList;

    public List<ChildInput> getChildren() {
        return children;
    }

    public void setChildren(final List<ChildInput> children) {
        this.children = children;
    }

    public List<GiftInput> getSantaGiftsList() {
        return santaGiftsList;
    }

    public void setSantaGiftsList(final List<GiftInput> santaGiftsList) {
        this.santaGiftsList = santaGiftsList;
    }
}
