package strategy.giftassigment;

import database.SantaDatabase;
import entities.Child;

import java.util.List;

public interface GiftsAssigmentStrategy {
    public List<Child> getOrderedChildren(SantaDatabase santaDatabase);
}
