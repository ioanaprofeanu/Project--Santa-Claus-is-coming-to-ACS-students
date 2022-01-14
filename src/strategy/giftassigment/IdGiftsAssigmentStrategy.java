package strategy.giftassigment;

import database.SantaDatabase;
import entities.Child;

import java.util.List;

/**
 * Implement the strategy for the id type of gift assigment
 */
public class IdGiftsAssigmentStrategy implements GiftsAssigmentStrategy {
    /**
     * Get the ordered list of children by id
     * @param santaDatabase Santa's database
     * @return the ordered list of children
     */
    @Override
    public List<Child> getOrderedChildren(final SantaDatabase santaDatabase) {
        // return the list of children within the database, since it is
        // already ordered by id
        return santaDatabase.getChildrenDatabase().getChildren();
    }
}
