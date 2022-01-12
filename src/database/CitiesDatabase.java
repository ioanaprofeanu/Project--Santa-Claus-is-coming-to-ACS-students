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
        // add the child to the list of children within its city
        for (City city : cities) {
            if (city.getName().equals(child.getCity())) {
                city.addChild(child);
                return;
            }
        }
        // if the city is not found within the list
        cities.add(new City(child.getCity()));
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

    public void removeCitiesYoungAdults() {
        if (cities == null) {
            return;
        }
        for (City city : cities) {
            city.removeCityYoungAdults();
        }
    }

    public List<City> getCities() {
        return cities;
    }

    @Override
    public String toString() {
        return "CitiesDatabase{" +
                "cities=" + cities +
                '}';
    }
}
