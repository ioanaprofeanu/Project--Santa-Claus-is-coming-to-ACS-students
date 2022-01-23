package utils;

import entities.Child;
import entities.City;
import entities.Gift;

import java.util.Comparator;

/**
 * Class which implements the comparators used for sorting the lists within the program
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

    /**
     * Sort children by nice score in descending order
     */
    public static final class SortChildrenByNiceScoreDesc implements Comparator<Child> {
        @Override
        public int compare(final Child o1, final Child o2) {
            return Double.compare(o2.getAverageScore(), o1.getAverageScore());
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

    /**
     * Sort cities by nice score city in descending order
     */
    public static final class SortCitiesByNiceScoreDesc implements Comparator<City> {
        @Override
        public int compare(final City o1, final City o2) {
            if (o1.getNiceScoreCity() == o2.getNiceScoreCity()) {
                return o1.getName().compareTo(o2.getName());
            }
            if (o1.getNiceScoreCity() < o2.getNiceScoreCity()) {
                return 1;
            }
            return -1;
        }
    }
}
