package fileio.input;

import java.util.ArrayList;
import java.util.List;

/**
 * Information about the data that needs to be changed for a certain child,
 * retrieved from parting the input file
 */
public class ChildUpdatesInput {
    /**
     * the child's id
     */
    private int id;
    /**
     * the child's new nice score
     */
    private double niceScore;
    /**
     * the child's new list of gift preferences
     */
    private List<String> giftsPreferences;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getNiceScore() {
        return niceScore;
    }

    public void setNiceScore(double niceScore) {
        this.niceScore = niceScore;
    }

    public List<String> getGiftsPreferences() {
        return giftsPreferences;
    }

    public void setGiftsPreferences(ArrayList<String> giftsPreferences) {
        this.giftsPreferences = giftsPreferences;
    }

    @Override
    public String toString() {
        return "ChildrenUpdatesInput{" +
                "id=" + id +
                ", niceScore=" + niceScore +
                ", giftsPreferences=" + giftsPreferences +
                '}';
    }
}
