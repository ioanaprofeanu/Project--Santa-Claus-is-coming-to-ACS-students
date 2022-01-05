package entities;

import fileio.input.ChildInput;

/**
 * General information about a child
 */
public abstract class Child {
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

    public Child(ChildInput childInput) {
        this.id = childInput.getId();
        this.lastName = childInput.getLastName();
        this.firstName = childInput.getFirstName();
        this.city = childInput.getCity();
        this.age = childInput.getAge();
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
}
