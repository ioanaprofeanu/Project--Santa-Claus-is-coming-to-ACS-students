package entities;

import common.Constants;

import java.util.ArrayList;
import java.util.List;

/**
 * Information about a city
 */
public final class City {
    /**
     * The city's name
     */
    private final String name;
    /**
     * The city's nice score
     */
    private double niceScoreCity;
    /**
     * The city's list of children
     */
    private final List<Child> childrenList;

    public City(final String name) {
        this.name = name;
        this.niceScoreCity = 0;
        this.childrenList = new ArrayList<>();
    }

    /**
     * Add a new child to the children list
     * @param child new to-be-added child
     */
    public void addChild(final Child child) {
        this.childrenList.add(child);
    }

    /**
     * Calculate the nice score of the city
     */
    public void calculateNiceScoreCity() {
        double sumOfScores = 0;
        for (Child child : childrenList) {
            sumOfScores += child.getAverageScore();
        }
        // the nice score city will be the arithmetical average of
        // the children's nice scores
        this.niceScoreCity = sumOfScores / childrenList.size();
    }

    /**
     * Remove young adults from the city's list of children
     */
    public void removeCityYoungAdults() {
        childrenList.removeIf(child -> child.getAge() > Constants.TEEN_UPPER_VALUE);
    }

    public String getName() {
        return name;
    }

    public double getNiceScoreCity() {
        return niceScoreCity;
    }

    public List<Child> getChildrenList() {
        return childrenList;
    }
}
