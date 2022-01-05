package utils;

import entities.Child;
import entities.Gift;

import java.util.Comparator;

/**
 * Class which implements the comparators used for sorting the arraylists within the program
 */
public final class Comparators {
    private Comparators() {
    }

    /**
     * Sort children by id in ascending order
     */
    public static class SortChildrenByIdAsc implements Comparator<Child> {
        @Override
        public int compare(Child o1, Child o2) {
            if (o2.getId() < o1.getId()) {
                return 1;
            }
            return -1;
        }
    }

    /**
     * Sort gifts by price in ascending order
     */
    public static class SortGiftsByPriceAsc implements Comparator<Gift> {
        @Override
        public int compare(Gift o1, Gift o2) {
            if (o2.getPrice() < o1.getPrice()) {
                return 1;
            }
            return -1;
        }
    }
}
