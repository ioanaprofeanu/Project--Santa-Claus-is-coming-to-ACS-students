package entities;

import java.util.ArrayList;
import java.util.List;

public class City {
    private String name;
    private double niceScoreCity;
    private List<Child> childrenList;

    public City(String name) {
        this.name = name;
        this.niceScoreCity = 0;
        this.childrenList = new ArrayList<>();
    }

    public void addChild(Child child) {
        this.childrenList.add(child);
    }

    public void calculateNiceScoreCity() {
        if (childrenList == null) {
            return;
        }
        double sumOfScores = 0;
        for (Child child : childrenList) {
            sumOfScores += child.getAverageScore();
        }
        this.niceScoreCity = sumOfScores / childrenList.size();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getNiceScoreCity() {
        return niceScoreCity;
    }

    public void setNiceScoreCity(double niceScoreCity) {
        this.niceScoreCity = niceScoreCity;
    }

    public List<Child> getChildrenList() {
        return childrenList;
    }

    public void setChildrenList(List<Child> childrenList) {
        this.childrenList = childrenList;
    }

    @Override
    public String toString() {
        return "City{" +
                "name='" + name + '\'' +
                ", niceScoreCity=" + niceScoreCity +
                ", childrenList=" + childrenList +
                '}';
    }
}
