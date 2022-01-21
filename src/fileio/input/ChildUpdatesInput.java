package fileio.input;

import java.util.List;

/**
 * Information about the data that needs to be changed for a certain child,
 * retrieved from parsing the input file
 */
public final class ChildUpdatesInput {
    /**
     * The child's id
     */
    private int id;
    /**
     * The child's new nice score
     */
    private Double niceScore;
    /**
     * The child's new list of gift preferences
     */
    private List<String> giftsPreferences;
    /**
     * The new elf assigned to the child
     */
    private String elf;

    public int getId() {
        return id;
    }

    public void setId(final int id) {
        this.id = id;
    }

    public Double getNiceScore() {
        return niceScore;
    }

    public void setNiceScore(final Double niceScore) {
        this.niceScore = niceScore;
    }

    public List<String> getGiftsPreferences() {
        return giftsPreferences;
    }

    public void setGiftsPreferences(final List<String> giftsPreferences) {
        this.giftsPreferences = giftsPreferences;
    }

    public String getElf() {
        return elf;
    }

    public void setElf(final String elf) {
        this.elf = elf;
    }
}
