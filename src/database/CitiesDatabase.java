package database;

import entities.Child;
import entities.City;
import utils.Comparators;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Database which contains a list of all cities the children live in and
 * methods regarding changes to the list
 */
public final class CitiesDatabase {
    /**
     * list of all cities the children live in
     */
    private final List<City> cities;

    public CitiesDatabase() {
        this.cities = new ArrayList<>();
    }

    /**
     * Add a new child to the list of children within the city
     * he lives in
     * @param child the new to-be-added child
     */
    public void addToCitiesList(final Child child) {
        // add the child to the list of children within its city
        for (City city : cities) {
            // if the city is already in the cities list,
            // add the child
            if (city.getName().equals(child.getCity())) {
                city.addChild(child);
                return;
            }
        }
        // if the city is not found within the list, create a new city object
        // and then add the child to the list
        cities.add(new City(child.getCity()));
        cities.get(cities.size() - 1).addChild(child);
    }

    /**
     * Calculate the nice scores of all cities
     */
    public void calculateCitiesNiceScores() {
        for (City city : cities) {
            // sort the city's children by id
            Collections.sort(city.getChildrenList(), new Comparators.SortChildrenByIdAsc());
            // calculate the city's nice score
            city.calculateNiceScoreCity();
        }
    }

    /**
     * Remove young adults from the list of children within
     * each city
     */
    public void removeCitiesYoungAdults() {
        for (City city : cities) {
            city.removeCityYoungAdults();
        }
    }

    public List<City> getCities() {
        return cities;
    }
}
