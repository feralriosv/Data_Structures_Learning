package algorithms;

import java.util.Arrays;
import java.util.List;

public class Main {
    private static final String ELEMENT_INDEX_FOUND_MESSAGE = "Element found at index %d%n";
    private static final String ELEMENT_INDEX_NOT_FOUND_MESSAGE = "Element not found, it should be introduced at index %d";
    private static final String TOTAL_INVERSIONS_MESSAGE = "Total inversions found: %d%n";
    private static final String MORE_THAN_K_TIMES_FOUND_MESSAGE = "Match with maximal frequency %d at value %d%n";
    private static final String SUM_PAIR_FOUND_MESSAGE = "Pair found: %d + %d = %d%n";

    private static final String MORE_THAN_K_TIMES_NOT_FOUND_MESSAGE = "No value has frequency > %d";
    private static final String SUM_PAIR_NOT_FOUND_MESSAGE = "No pair found";

    private static final String ERROR_INVALID_ARGUMENTS = "Invalid arguments";

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 4, 5, 5, 5, 5, 4, 54, 23, 42, 43};
        int[] arr2 = {};
        int[] arr3 = {-1, -1, -1, 0 , -1};
        int[] arr4 = {5};
        int[] arr5 = {7, 8, 5, 4, 5, 2};
        List<Integer> list1 = List.of(3, 4, 6, 8, 14, 34);

        isElementMoreThanKTimes(null, 1);
        isElementMoreThanKTimes(arr1, 3);
        isElementMoreThanKTimes(arr2, 0);
        isElementMoreThanKTimes(arr3, 2);
        getElementIndex(list1, 8);
        System.out.print(System.lineSeparator());
        findPairWithSum(arr1, -1);
        findPairWithSum(arr4, 5);
        System.out.print(System.lineSeparator());
        countInversionsBrute(arr1);
        countInversionsBrute(arr2);
        countInversionsOptimal(arr3);
    }

    // Private methods that validate user inputs separately from algorithm logic:

    private static void countInversionsOptimal(int[] array) {
        if (array == null) {
            System.err.println(ERROR_INVALID_ARGUMENTS);
            return;
        }

        int totalInversions = Algorithmic.sortAndCountInversions(array, 0, array.length - 1);
        System.out.printf(TOTAL_INVERSIONS_MESSAGE, totalInversions);
    }

    private static void countInversionsBrute(int[] array) {
        if (array == null) {
            System.err.println(ERROR_INVALID_ARGUMENTS);
            return;
        }

        int totalInversions = Algorithmic.countInversionsBrute(array);
        System.out.printf(TOTAL_INVERSIONS_MESSAGE, totalInversions);
    }

    private static void isElementMoreThanKTimes(int[] array, int k) {
        if (array == null || array.length < 1 || k < 0) {
            System.err.println(ERROR_INVALID_ARGUMENTS);
            return;
        }

        int[] result = Algorithmic.isMoreThanKTimes(array, k);

        if (result != null) {
            System.out.printf((MORE_THAN_K_TIMES_FOUND_MESSAGE), result[0], result[1]);
        } else {
            System.out.printf(MORE_THAN_K_TIMES_NOT_FOUND_MESSAGE, k);
        }
    }

    private static void findPairWithSum(int[] array, int sum) {
        if (array == null || array.length < 2) {
            System.err.println(ERROR_INVALID_ARGUMENTS);
            return;
        }

        int[] pairs = Algorithmic.findPairWithSum(array, sum);

        if (pairs != null) {
            System.out.printf((SUM_PAIR_FOUND_MESSAGE), pairs[0], pairs[1], sum);
        } else {
            System.out.println(SUM_PAIR_NOT_FOUND_MESSAGE);
        }
    }

    private static void getElementIndex(List<Integer> list, int element) {
        int index = Algorithmic.indexBinarySearch(list, element);

        if (index > 0) {
            System.out.printf(ELEMENT_INDEX_FOUND_MESSAGE, index);
        } else {
            index = -1 * index;
            System.out.printf(ELEMENT_INDEX_NOT_FOUND_MESSAGE, index);
        }
    }
}
