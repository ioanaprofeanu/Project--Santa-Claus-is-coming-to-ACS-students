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
    public static final class SortChildrenByIdAsc implements Comparator<Child> {
        @Override
        public int compare(final Child o1, final Child o2) {
            return Integer.compare(o1.getId(), o2.getId());
        }
    }

    public static final class SortChildrenByNiceScoreDesc implements Comparator<Child> {
        @Override
        public int compare(Child o1, Child o2) {
            if (o1.getAverageScore() == o2.getAverageScore()) {
                Integer.compare(o1.getId(), o2.getId());
            }
            if (o1.getAverageScore() < o2.getAverageScore()) {
                return 1;
            }
            return -1;
        }
    }

    /**
     * Sort gifts by price in ascending order
     */
    public static final class SortGiftsByPriceAsc implements Comparator<Gift> {
        @Override
        public int compare(final Gift o1, final Gift o2) {
            return Double.compare(o1.getPrice(), o2.getPrice());
        }
    }
}
