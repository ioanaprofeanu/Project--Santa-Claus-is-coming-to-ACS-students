package entities;

import averagescorestrategy.AverageScoreStrategy;
import com.fasterxml.jackson.annotation.JsonIgnore;
import entities.Elves.Elf;
import fileio.input.ChildInput;

import java.nio.channels.AsynchronousChannelGroup;
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
    /**
     * The elf assigned to the child
     */
    @JsonIgnore
    private Elf elf;
    /**
     * The child's nice score bonus
     */
    @JsonIgnore
    private int niceScoreBonus;

    public Child(ChildBuilder childBuilder) {
        this.id = childBuilder.id;
        this.lastName = childBuilder.lastName;
        this.firstName = childBuilder.firstName;
        this.city = childBuilder.city;
        this.age = childBuilder.age;
        this.giftsPreferences = childBuilder.giftsPreferences;
        this.averageScore = childBuilder.averageScore;
        this.niceScoreHistory = childBuilder.niceScoreHistory;
        this.assignedBudget = childBuilder.assignedBudget;
        this.receivedGifts = childBuilder.receivedGifts;
        this.elf = childBuilder.elf;
        this.niceScoreBonus = childBuilder.niceScoreBonus;
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

    static public class ChildBuilder {
        private int id;
        private String lastName;
        private String firstName;
        private String city;
        private int age;
        private List<String> giftsPreferences;
        private double averageScore = 0;
        private List<Double> niceScoreHistory = new ArrayList<>();
        private double assignedBudget = 0;
        private List<Gift> receivedGifts = new ArrayList<>();
        private Elf elf;
        private int niceScoreBonus = 0;

        public ChildBuilder(int id, String lastName, String firstName,
                            String city, int age, List<String> giftsPreferences,
                            double niceScore, Elf elf) {
            this.id = id;
            this.lastName = lastName;
            this.firstName = firstName;
            this.city = city;
            this.age = age;
            this.giftsPreferences = giftsPreferences;
            this.niceScoreHistory.add(niceScore);
            this.elf = elf;
        }

        public ChildBuilder addNiceScoreBonus(int niceScoreBonus) {
            this.niceScoreBonus = niceScoreBonus;
            return this;
        }

        public Child buildChild() {
            return new Child(this);
        }
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

    public double getAverageScore() {
        return averageScore;
    }

    public List<Double> getNiceScoreHistory() {
        return niceScoreHistory;
    }

    public double getAssignedBudget() {
        return assignedBudget;
    }

    public List<Gift> getReceivedGifts() {
        return receivedGifts;
    }

    public Elf getElf() {
        return elf;
    }

    public int getNiceScoreBonus() {
        return niceScoreBonus;
    }
}
