package fileio.input;

import fileio.input.ChildInput;
import fileio.input.GiftInput;

import java.util.List;

/**
 * The initial data retrieved from parsing the input file
 */
public class InitialDataInput {
    /**
     * list of children received at input
     */
    private List<ChildInput> children;
    /**
     * list of gifts received at input
     */
    private List<GiftInput> santaGiftsList;

    public List<ChildInput> getChildren() {
        return children;
    }

    public void setChildren(List<ChildInput> children) {
        this.children = children;
    }

    public List<GiftInput> getSantaGiftsList() {
        return santaGiftsList;
    }

    public void setSantaGiftsList(List<GiftInput> santaGiftsList) {
        this.santaGiftsList = santaGiftsList;
    }

    @Override
    public String toString() {
        return "InitialDataInput{" +
                "children=" + children +
                ", santaGiftsList=" + santaGiftsList +
                '}';
    }
}
