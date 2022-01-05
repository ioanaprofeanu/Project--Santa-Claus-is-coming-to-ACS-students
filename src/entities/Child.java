package entities;

import averagescorestrategy.AverageScoreStrategy;
import fileio.input.ChildInput;

import java.util.ArrayList;
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
        this.giftsPreferences = child.getGiftsPreferences();
        this.averageScore = child.getAverageScore();
        this.niceScoreHistory = child.getNiceScoreHistory();
        this.niceScoreHistory = child.getNiceScoreHistory();
        this.assignedBudget = child.getAssignedBudget();
        this.receivedGifts = child.getReceivedGifts();
    }

    /**
     * Use average score strategy to get the average score depending on the
     * child's age
     * @param averageScoreStrategy the strategy which calculates the average score
     */
    public void calculateAverageScore(AverageScoreStrategy averageScoreStrategy) {
        this.averageScore = averageScoreStrategy.getAverageScore(this);
    }

    public void getOlder() {
        this.age++;
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
