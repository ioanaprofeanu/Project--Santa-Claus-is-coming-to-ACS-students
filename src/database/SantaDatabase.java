package database;

import entities.ChildAnnualData;
import entities.Gift;
import fileio.input.ChildInput;
import fileio.input.GiftInput;
import fileio.input.InitialDataInput;
import fileio.input.SimulationDataInput;
import utils.Comparators;

import java.util.*;

public class SantaDatabase {
    /**
     * santa's budget
     */
    private double santaBudget;
    /**
     * list of all children
     */
    private List<ChildAnnualData> children;
    /**
     * map of gifts with category as key and the list of
     * gifts sorted in ascending order by price as value
     */
    private Map<String, List<Gift>> gifts;

    public SantaDatabase(SimulationDataInput simulationDataInput) {
        this.santaBudget = simulationDataInput.getSantaBudget();
        this.children = new ArrayList<>();
        addChildren(simulationDataInput.getInitialData().getChildren());
        this.gifts = new HashMap<>();
        addGifts(simulationDataInput.getInitialData().getSantaGiftsList());
    }

    /**
     * Adds an input list of children to the list of all children
     * used both for the initial simulation and the year simulation
     * @param childrenInput the input list of children
     */
    public void addChildren(List<ChildInput> childrenInput) {
        if (childrenInput == null) {
            return;
        }
        for (ChildInput childInput : childrenInput) {
            ChildAnnualData child = new ChildAnnualData(childInput);
            children.add(child);
        }
        // sort the list in ascending order by id
        Collections.sort(this.children, new Comparators.SortChildrenByIdAsc());
    }

    /**
     * Adds an input list of gifts to the hashmap of all gifts
     * used both for the initial simulation and the year simulation
     * @param giftsInput the input list of gifts
     */
    public void addGifts(List<GiftInput> giftsInput) {
        if (giftsInput == null) {
            return;
        }
        for (GiftInput giftInput : giftsInput) {
            String giftCategory = giftInput.getCategory();
            Gift gift = new Gift(giftInput);
            // if the category already exists in the map
            if (this.gifts.containsKey(giftCategory)) {
                // if the gift already exists in the list, don't add it
                if (this.gifts.get(giftCategory).contains(gift)) {
                    continue;
                } else {
                    // add the gift in the list
                    this.gifts.get(giftCategory).add(gift);
                }
            } else {
                // create a new list (which will be the value of the new key)
                List<Gift> newGiftList = new ArrayList<>();
                newGiftList.add(gift);;
                this.gifts.put(giftCategory, newGiftList);
            }
        }
        sortGiftsMap();
    }

    /**
     * Sort each list of gifts from the hashmap by price in ascending order
     */
    public void sortGiftsMap() {
        if (this.gifts == null) {
            return;
        }
        for (Map.Entry<String, List<Gift>> entry : this.gifts.entrySet()) {
            Collections.sort(entry.getValue(), new Comparators.SortGiftsByPriceAsc());
        }
    }

    public List<ChildAnnualData> getChildren() {
        return children;
    }

    public void setChildren(List<ChildAnnualData> children) {
        this.children = children;
    }

    public Map<String, List<Gift>> getGifts() {
        return gifts;
    }

    public void setGifts(Map<String, List<Gift>> gifts) {
        this.gifts = gifts;
    }

    @Override
    public String toString() {
        return "SantaDatabase{" +
                "children=" + children +
                ", gifts=" + gifts +
                '}';
    }
}
