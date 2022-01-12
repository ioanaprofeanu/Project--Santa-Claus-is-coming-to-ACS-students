package database;

import entities.Child;
import entities.City;
import utils.Comparators;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CitiesDatabase {
    /**
     * list of all cities the children live in
     */
    private List<City> cities;

    public CitiesDatabase() {
        this.cities = new ArrayList<>();
    }

    public void addToCitiesList(Child child) {
        // if the city doesn't exist in the list
        if (!cities.contains(child.getCity())) {
            cities.add(new City(child.getCity()));
        }
        // add the child to the list of children within its city
        cities.get(cities.size() - 1).addChild(child);
    }

    public void calculateCitiesNiceScores() {
        if (cities == null) {
            return;
        }
        for (City city : cities) {
            // sort the city's children by id
            Collections.sort(city.getChildrenList(), new Comparators.SortChildrenByIdAsc());
            // calculate the city's nice score
            city.calculateNiceScoreCity();
        }
    }

    public List<City> getCities() {
        return cities;
    }

    public void setCities(List<City> cities) {
        this.cities = cities;
    }
}
