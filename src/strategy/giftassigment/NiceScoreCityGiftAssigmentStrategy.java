package strategy.giftassigment;

import database.SantaDatabase;
import entities.Child;
import entities.City;
import utils.Comparators;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Implement the strategy for the nice score city type of gift assigment
 */
public class NiceScoreCityGiftAssigmentStrategy implements GiftsAssigmentStrategy {
    /**
     * Get the ordered list of children by nice score city
     * @param santaDatabase Santa's database
     * @return the ordered list of children
     */
    @Override
    public List<Child> getOrderedChildren(SantaDatabase santaDatabase) {
        // order the list of cities within Santa's database by nice score city
        // in ascending order
        Collections.sort(santaDatabase.getCitiesDatabase().getCities(),
                new Comparators.SortCitiesByNiceScoreDesc());
        // create a new list of children
        List<Child> orderedList = new ArrayList<>();
        // for each city in Santa's database, add its children in the
        // new children list; this way, the list will be ordered by
        // nice score city
        for (City city : santaDatabase.getCitiesDatabase().getCities()) {
            orderedList.addAll(city.getChildrenList());
        }
        return orderedList;
    }
}
