package strategy.giftassigment;

import database.SantaDatabase;
import entities.Child;
import entities.City;
import utils.Comparators;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NiceScoreCityGiftAssigmentStrategy implements GiftsAssigmentStrategy {
    @Override
    public List<Child> getOrderedChildren(SantaDatabase santaDatabase) {
        Collections.sort(santaDatabase.getCitiesDatabase().getCities(), new Comparators.SortCitiesByNiceScoreDesc());
        List<Child> orderedList = new ArrayList<>();
        for (City city : santaDatabase.getCitiesDatabase().getCities()) {
            orderedList.addAll(city.getChildrenList());
        }
        System.out.println(orderedList);
        return orderedList;
    }
}
