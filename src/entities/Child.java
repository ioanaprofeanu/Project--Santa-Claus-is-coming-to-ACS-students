package entities;

import averagescorestrategy.AverageScoreStrategy;
import fileio.input.ChildInput;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * General information about a child
 */
public class Child {
    /**
     * child ID
     */
    private int id;
    /**
     * child last name
     */
    private String lastName;
    /**
     * child first name
     */
    private String firstName;
    /**
     * the city the child lives in
     */
    private String city;
    /**
     * child age
     */
    private int age;
    /**
     * the list of gift preferences
     */
    private List<String> giftsPreferences;
    /**
     * child's average score
     */
    private double averageScore;
    /**
     * list of all scores
     */
    private List<Double> niceScoreHistory;
    /**
     * assigned budget
     */
    private double assignedBudget;
    /**
     * list of received gifts
     */
    private List<Gift> receivedGifts;

    public Child(ChildInput childInput) {
        this.id = childInput.getId();
        this.lastName = childInput.getLastName();
        this.firstName = childInput.getFirstName();
        this.city = childInput.getCity();
        this.age = childInput.getAge();
        this.giftsPreferences = childInput.getGiftsPreferences();
        this.averageScore = 0;
        this.niceScoreHistory = new ArrayList<>();
        this.niceScoreHistory.add(childInput.getNiceScore());
        this.assignedBudget = 0;
        this.receivedGifts = new ArrayList<>();
    }

    public Child(Child child) {
        this.id = child.getId();
        this.lastName = child.getLastName();
        this.firstName = child.getFirstName();
        this.city = child.getCity();
        this.age = child.getAge();
        this.giftsPreferences = new ArrayList<>();
        this.giftsPreferences.addAll(child.getGiftsPreferences());
        this.averageScore = child.getAverageScore();
        this.niceScoreHistory = new ArrayList<>();
        this.niceScoreHistory.addAll(child.getNiceScoreHistory());
        this.assignedBudget = child.getAssignedBudget();
        this.receivedGifts = new ArrayList<>();
        this.receivedGifts.addAll(child.getReceivedGifts());
    }

    /**
     * Use average score strategy to get the average score depending on the
     * child's age
     * @param averageScoreStrategy the strategy which calculates the average score
     */
    public void calculateAverageScore(AverageScoreStrategy averageScoreStrategy) {
        this.averageScore = averageScoreStrategy.getAverageScore(this);
    }

    /**
     * increase the age of the child by one year
     */
    public void getOlder() {
        this.age++;
    }

    /**
     * Update the child
     * @param newNiceScore the new to-be-added score
     * @param newPreferences the new to-be-added preferences
     */
    public void updateChild(Double newNiceScore, List<String> newPreferences) {
        addNiceScore(newNiceScore);
        addPreferences(newPreferences);
    }

    /**
     * Add new score to the nice score list
     * @param newNiceScore the new nice score
     */
    private void addNiceScore(Double newNiceScore) {
        if (newNiceScore == null) {
            return;
        }
        niceScoreHistory.add(newNiceScore);
    }

    /**
     * Add a new list of preferences at the beginning of the already
     * existing one
     * @param newPreferences the new list of preferences
     */
    private void addPreferences(List<String> newPreferences) {
        if (newPreferences == null) {
            return;
        }
        // append the initial list of preferences to the new list
        newPreferences.addAll(this.giftsPreferences);
        // create a new auxiliary list
        List<String> auxListPreferences = new ArrayList<>();
        for (String preference : newPreferences) {
            if (!auxListPreferences.contains(preference)) {
                auxListPreferences.add(preference);
            }
        }

        this.giftsPreferences = auxListPreferences;
    }

    public int getId() {
        return id;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getCity() {
        return city;
    }

    public int getAge() {
        return age;
    }

    public List<String> getGiftsPreferences() {
        return giftsPreferences;
    }

    public void setGiftsPreferences(List<String> giftsPreferences) {
        this.giftsPreferences = giftsPreferences;
    }

    public double getAverageScore() {
        return averageScore;
    }

    public void setAverageScore(double averageScore) {
        this.averageScore = averageScore;
    }

    public List<Double> getNiceScoreHistory() {
        return niceScoreHistory;
    }

    public void setNiceScoreHistory(List<Double> niceScoreHistory) {
        this.niceScoreHistory = niceScoreHistory;
    }

    public double getAssignedBudget() {
        return assignedBudget;
    }

    public void setAssignedBudget(double assignedBudget) {
        this.assignedBudget = assignedBudget;
    }

    public List<Gift> getReceivedGifts() {
        return receivedGifts;
    }

    public void setReceivedGifts(List<Gift> receivedGifts) {
        this.receivedGifts = receivedGifts;
    }

    @Override
    public String toString() {
        return "ChildSantaData{" +
                "giftsPreferences=" + giftsPreferences +
                ", averageScore=" + averageScore +
                ", niceScoreHistory=" + niceScoreHistory +
                ", assignedBudget=" + assignedBudget +
                ", receivedGifts=" + receivedGifts +
                '}';
    }
}
