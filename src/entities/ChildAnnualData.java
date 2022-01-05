//package entities;
//
//import averagescorestrategy.AverageScoreStrategy;
//import fileio.input.ChildInput;
//
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * Annual data of a child
// */
//public final class ChildAnnualData extends Child {
//    /**
//     * the list of gift preferences
//     */
//    private List<String> giftsPreferences;
//    /**
//     * child's average score
//     */
//    private double averageScore;
//    /**
//     * list of all scores
//     */
//    private List<Double> niceScoreHistory;
//    /**
//     * assigned budget
//     */
//    private double assignedBudget;
//    /**
//     * list of received gifts
//     */
//    private List<Gift> receivedGifts;
//
//    public ChildAnnualData(ChildInput childInput) {
//        super(childInput);
//        this.giftsPreferences = childInput.getGiftsPreferences();
//        this.averageScore = 0;
//        this.niceScoreHistory = new ArrayList<>();
//        this.niceScoreHistory.add(childInput.getNiceScore());
//        this.assignedBudget = 0;
//        this.receivedGifts = new ArrayList<>();
//    }
//
//    public ChildAnnualData(ChildAnnualData child) {
//        super(child.getId(), child.getLastName(), child.getFirstName(), child.getCity(), child.getAge());
//        this.giftsPreferences = child.getGiftsPreferences();
//        this.averageScore = child.getAverageScore();
//        this.niceScoreHistory = child.getNiceScoreHistory();
//        this.assignedBudget = child.getAssignedBudget();
//        this.receivedGifts = child.getReceivedGifts();
//    }
//
//    /**
//     * Use average score strategy to get the average score depending on the
//     * child's age
//     * @param averageScoreStrategy the strategy which calculates the average score
//     */
//    public void calculateAverageScore(AverageScoreStrategy averageScoreStrategy) {
//        this.averageScore = averageScoreStrategy.getAverageScore(this);
//    }
//
//    public void getOlder() {
//        this.setAge(this.getAge() + 1);
//    }
//
//    public List<String> getGiftsPreferences() {
//        return giftsPreferences;
//    }
//
//    public void setGiftsPreferences(List<String> giftsPreferences) {
//        this.giftsPreferences = giftsPreferences;
//    }
//
//    public double getAverageScore() {
//        return averageScore;
//    }
//
//    public void setAverageScore(double averageScore) {
//        this.averageScore = averageScore;
//    }
//
//    public List<Double> getNiceScoreHistory() {
//        return niceScoreHistory;
//    }
//
//    public void setNiceScoreHistory(List<Double> niceScoreHistory) {
//        this.niceScoreHistory = niceScoreHistory;
//    }
//
//    public double getAssignedBudget() {
//        return assignedBudget;
//    }
//
//    public void setAssignedBudget(double assignedBudget) {
//        this.assignedBudget = assignedBudget;
//    }
//
//    public List<Gift> getReceivedGifts() {
//        return receivedGifts;
//    }
//
//    public void setReceivedGifts(List<Gift> receivedGifts) {
//        this.receivedGifts = receivedGifts;
//    }
//
//    @Override
//    public String toString() {
//        return "ChildSantaData{" +
//                "giftsPreferences=" + giftsPreferences +
//                ", averageScore=" + averageScore +
//                ", niceScoreHistory=" + niceScoreHistory +
//                ", assignedBudget=" + assignedBudget +
//                ", receivedGifts=" + receivedGifts +
//                '}';
//    }
//}
