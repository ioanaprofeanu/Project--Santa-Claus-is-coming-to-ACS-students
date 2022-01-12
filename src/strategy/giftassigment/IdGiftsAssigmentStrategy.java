package strategy.giftassigment;

import database.SantaDatabase;
import entities.Child;

import java.util.List;

public class IdGiftsAssigmentStrategy implements GiftsAssigmentStrategy {
    @Override
    public List<Child> getOrderedChildren(SantaDatabase santaDatabase) {
        return santaDatabase.getChildrenDatabase().getChildren();
    }
}
