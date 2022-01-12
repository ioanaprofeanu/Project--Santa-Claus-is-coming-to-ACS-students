package strategy.giftassigment;

import database.SantaDatabase;
import entities.Child;
import utils.Comparators;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NiceScoreGiftsAssigmentStrategy implements GiftsAssigmentStrategy {
    @Override
    public List<Child> getOrderedChildren(SantaDatabase santaDatabase) {
        List<Child> orderedList = new ArrayList<>(santaDatabase.getChildrenDatabase().getChildren());
        Collections.sort(orderedList, new Comparators.SortChildrenByNiceScoreDesc());
        return orderedList;
    }
}
