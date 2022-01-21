package strategy.giftassigment;

import database.SantaDatabase;
import entities.Child;
import utils.Comparators;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Implement the strategy for the nice score type of gift assigment
 */
public class NiceScoreGiftsAssigmentStrategy implements GiftsAssigmentStrategy {
    /**
     * Get the ordered list of children by nice score
     * @param santaDatabase Santa's database
     * @return the ordered list of children
     */
    @Override
    public List<Child> getOrderedChildren(final SantaDatabase santaDatabase) {
        // create a new list of children using the already existing
        // children within Santa's database
        List<Child> orderedList = new ArrayList<>(santaDatabase.
                getChildrenDatabase().getChildren());
        // order the new list by nice score in descending order
        Collections.sort(orderedList, new Comparators.SortChildrenByNiceScoreDesc());
        return orderedList;
    }
}
