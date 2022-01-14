package strategy.giftassigment;

import database.SantaDatabase;
import entities.Child;

import java.util.List;

/**
 * Interface for the strategy pattern which sorts the list of children
 * depending on the type of gift assigment strategy
 */
public interface GiftsAssigmentStrategy {
    /**
     * Get the ordered list of children
     * @param santaDatabase Santa's database
     * @return the list of ordered children
     */
    List<Child> getOrderedChildren(final SantaDatabase santaDatabase);
}
