package entities;

import strategy.averagescore.AverageScoreStrategy;
import com.fasterxml.jackson.annotation.JsonIgnore;
import entities.Elves.Elf;
import entities.Elves.ElvesFactory;

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
    private final List<Double> niceScoreHistory;
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
    private final int niceScoreBonus;

    /**
     * Constructor used to build a child using the builder design pattern
     * @param childBuilder the builder object resembling the input child
     */
    public Child(final ChildBuilder childBuilder) {
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

    /**
     * Constructor used for creating a deep copy of a child,
     * used for creating the output child object
     * @param child the to-be-copied child object
     */
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
        this.elf = child.getElf();
        this.niceScoreBonus = child.getNiceScoreBonus();
    }

    /**
     * Builder class for creating a child
     */
    public static class ChildBuilder {
        // mandatory fields
        private final int id;
        private final String lastName;
        private final String firstName;
        private final String city;
        private final int age;
        private final List<String> giftsPreferences;
        private final double averageScore = 0;
        private final List<Double> niceScoreHistory = new ArrayList<>();
        private final double assignedBudget = 0;
        private final List<Gift> receivedGifts = new ArrayList<>();
        private final Elf elf;
        // optional field
        private int niceScoreBonus = 0;

        public ChildBuilder(final int id, final String lastName, final String firstName,
                            final String city, final int age, final List<String> giftsPreferences,
                            final double niceScore, final String elfColor) {
            this.id = id;
            this.lastName = lastName;
            this.firstName = firstName;
            this.city = city;
            this.age = age;
            this.giftsPreferences = giftsPreferences;
            this.niceScoreHistory.add(niceScore);
            this.elf = ElvesFactory.getInstance().createElf(elfColor);
        }

        /**
         * Attach the optional field to the already created ChildBuilder object
         * @param newNiceScoreBonus the bonus nice score
         * @return the child object
         */
        public ChildBuilder addNiceScoreBonus(final int newNiceScoreBonus) {
            this.niceScoreBonus = newNiceScoreBonus;
            return this;
        }

        /**
         * Build the child using the builder
         * @return the child builder object
         */
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
    public void updateChild(final Double newNiceScore, final List<String> newPreferences,
                            final String elfColor) {
        addNiceScore(newNiceScore);
        addPreferences(newPreferences);
        updateElf(elfColor);
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

    /**
     * Update the child's elf using the elves factory
     * @param elfColor the elf's color
     */
    private void updateElf(final String elfColor) {
        this.elf = ElvesFactory.getInstance().createElf(elfColor);
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

    public void setAssignedBudget(final double assignedBudget) {
        this.assignedBudget = assignedBudget;
    }

    public List<Gift> getReceivedGifts() {
        return receivedGifts;
    }

    public void setReceivedGifts(final List<Gift> receivedGifts) {
        this.receivedGifts = receivedGifts;
    }

    public Elf getElf() {
        return elf;
    }

    public int getNiceScoreBonus() {
        return niceScoreBonus;
    }
}
