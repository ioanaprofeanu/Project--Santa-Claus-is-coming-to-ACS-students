package common;

public final class Constants {
    public static final String OUTPUT_PATH = "output/out_";
    public static final String OUTPUT = "output";
    public static final String REF_PATH = "ref/ref_test";
    public static final String TEST = "tests/test";
    public static final String FILE_EXTENSION = ".json";
    public static final Integer SMALL_TEST_POINTS = 2;
    public static final Integer BIG_TEST_POINTS = 3;
    public static final Integer TESTS_NUMBER = 25;
    public static final Integer MAXIMUM_ERROR_CHECKSTYLE = 30;
    public static final Integer CHECKSTYLE_POINTS = 10;
    public static final Integer TESTS_NUMBER_SMALL = 15;

    // values used for calculating the child's age category
    // and the average score
    public static final Integer BABY_LOWER_VALUE = 0;
    public static final Integer BABY_UPPER_VALUE = 4;
    public static final Integer CHILD_LOWER_VALUE = 5;
    public static final Integer CHILD_UPPER_VALUE = 11;
    public static final Integer TEEN_LOWER_VALUE = 12;
    public static final Integer TEEN_UPPER_VALUE = 18;
    public static final Integer BABY_AVERAGE_SCORE = 10;

    private Constants() {
        //constructor for checkstyle
    }

}
