package entities;

import averagescorestrategy.AverageScoreStrategy;
import fileio.input.ChildInput;

import java.util.ArrayList;
import java.util.List;

/**
 * Information about a child and operations regarding its characteristics
 */
public final class Child {
    /**
     * Child's ID
     */
    private final int id;
    /**
     * Child's last name
     */
    private final String lastName;
    /**
     * Child's first name
     */
    private final String firstName;
    /**
     * The city the child lives in
     */
    private final String city;
    /**
     * Child's age
     */
    private int age;
    /**
     * The list of gift preferences
     */
    private List<String> giftsPreferences;
    /**
     * Child's average score
     */
    private double averageScore;
    /**
     * List of all scores
     */
    private List<Double> niceScoreHistory;
    /**
     * Assigned budget
     */
    private double assignedBudget;
    /**
     * List of received gifts
     */
    private List<Gift> receivedGifts;

    public Child(final ChildInput childInput) {
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

    public Child(final Child child) {
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
    public void calculateAverageScore(final AverageScoreStrategy averageScoreStrategy) {
        this.averageScore = averageScoreStrategy.getAverageScore(this);
    }

    /**
     * Increase the age of the child by one year
     */
    public void getOlder() {
        this.age++;
    }

    /**
     * Update the child
     * @param newNiceScore the new to-be-added score
     * @param newPreferences the new to-be-added preferences
     */
    public void updateChild(final Double newNiceScore, final List<String> newPreferences) {
        addNiceScore(newNiceScore);
        addPreferences(newPreferences);
    }

    /**
     * Add new score to the nice score list
     * @param newNiceScore the new nice score
     */
    private void addNiceScore(final Double newNiceScore) {
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
    private void addPreferences(final List<String> newPreferences) {
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
        // the actual list will be equal to the newly created one
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

    public void setGiftsPreferences(final List<String> giftsPreferences) {
        this.giftsPreferences = giftsPreferences;
    }

    public double getAverageScore() {
        return averageScore;
    }

    public void setAverageScore(final double averageScore) {
        this.averageScore = averageScore;
    }

    public List<Double> getNiceScoreHistory() {
        return niceScoreHistory;
    }

    public void setNiceScoreHistory(final List<Double> niceScoreHistory) {
        this.niceScoreHistory = niceScoreHistory;
    }

    public double getAssignedBudget() {
        return assignedBudget;
    }

    public void setAssignedBudget(final double assignedBudget) {
        this.assignedBudget = assignedBudget;
    }

    public List<Gift> getReceivedGifts() {
        return receivedGifts;
    }

    public void setReceivedGifts(final List<Gift> receivedGifts) {
        this.receivedGifts = receivedGifts;
    }

    @Override
    public String toString() {
        return "ChildSantaData{"
                + "giftsPreferences=" + giftsPreferences
                + ", averageScore=" + averageScore
                + ", niceScoreHistory=" + niceScoreHistory
                + ", assignedBudget=" + assignedBudget
                + ", receivedGifts=" + receivedGifts
                + '}';
    }
}
