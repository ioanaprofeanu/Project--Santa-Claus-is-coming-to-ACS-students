package fileio.input;

import java.util.ArrayList;
import java.util.List;

/**
 * Information about a child, retrieved from parting the input file
 */
public final class ChildInput {
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
     * child age
     */
    private int age;
    /**
     * the city the child lives in
     */
    private String city;
    /**
     * the child's nice score
     */
    private double niceScore;
    /**
     * the list of gift preferences
     */
    private List<String> giftsPreferences = new ArrayList<>();

    public int getId() {
        return id;
    }

    public void setId(int Id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public double getNiceScore() {
        return niceScore;
    }

    public void setNiceScore(double niceScore) {
        this.niceScore = niceScore;
    }

    public List<String> getGiftsPreferences() {
        return giftsPreferences;
    }

    public void setGiftsPreferences(List<String> giftsPreferences) {
        this.giftsPreferences = giftsPreferences;
    }

    @Override
    public String toString() {
        return "ChildInput{" +
                "id=" + id +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", age=" + age +
                ", city='" + city + '\'' +
                ", niceScore=" + niceScore +
                ", giftsPreferences=" + giftsPreferences +
                '}';
    }
}
