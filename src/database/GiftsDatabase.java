package database;

import entities.Gift;
import fileio.input.GiftInput;
import fileio.input.SimulationDataInput;
import utils.Comparators;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

/**
 * Database which contains a list of all gifts and methods regarding changes to the list
 */
public final class GiftsDatabase {
    /**
     * map of gifts with category as key and the list of
     * gifts sorted in ascending order by price as value
     */
    private Map<String, List<Gift>> gifts;

    public GiftsDatabase(final SimulationDataInput simulationDataInput) {
        this.gifts = new HashMap<>();
        addGifts(simulationDataInput.getInitialData().getSantaGiftsList());
    }

    /**
     * Adds an input list of gifts to the hashmap of all gifts
     * used both for the initial simulation and the year simulation
     * @param giftsInput the input list of gifts
     */
    public void addGifts(final List<GiftInput> giftsInput) {
        if (giftsInput == null) {
            return;
        }
        for (GiftInput giftInput : giftsInput) {
            String giftCategory = giftInput.getCategory();
            Gift gift = new Gift(giftInput);
            // if the category already exists in the map
            if (this.gifts.containsKey(giftCategory)) {
                // if the gift already exists in the list, don't add it
                if (!this.gifts.get(giftCategory).contains(gift)) {
                    // add the gift in the list
                    this.gifts.get(giftCategory).add(gift);
                }
            } else {
                // create a new list (which will be the value of the new key)
                List<Gift> newGiftList = new ArrayList<>();
                newGiftList.add(gift);
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

    public Map<String, List<Gift>> getGifts() {
        return gifts;
    }

    public void setGifts(final Map<String, List<Gift>> gifts) {
        this.gifts = gifts;
    }

    @Override
    public String toString() {
        return "GiftsDatabase{"
                + "gifts=" + gifts
                + '}';
    }
}
