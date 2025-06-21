package algorithms;

import java.beans.PropertyEditorManager;
import java.util.*;

public class AlgorithmProblems {
    public static void main(String[] args) {
        int[] arr1 = {1, 2, 4, 5, 5, 5, 5, 4, 54, 23, 42, 43};
        int[] arr2 = {};
        int[] arr3 = {-1, -1, -1, 0};
        int[] arr4 = {5};

        hasFrequentElementOverK(null, 1);
        hasFrequentElementOverK(arr1, 3);
        hasFrequentElementOverK(arr2, 0);
        hasFrequentElementOverK(arr3, 2);
        System.out.println("-----");
        hasPairWithSum(arr1, -1);
        hasPairWithSum(arr4, 5);
    }

    /**
     * Determines whether there exists an integer in the array that appears more than k times using hash structures.
     * The algorithm runs in linear time: O(n), where n is the length of the array.
     *
     * @param array the array of integers to be checked
     * @param k the repetition threshold
     */
    public static void hasFrequentElementOverK(int[] array, int k) {

        if (array == null || array.length < 1 || k < 0) {
            System.err.println("Invalid arguments");
            return;
        }

        Map<Integer, Integer> frequencies = new HashMap<>();
        int maxFreq = 0;
        int value = 0;

        for (int currentValue : array) {
            int valueFrequency = frequencies.getOrDefault(currentValue, 0) + 1;
            frequencies.put(currentValue, valueFrequency);

            if (valueFrequency > k) {
                maxFreq = valueFrequency;
                value = currentValue;
            }
        }

        if (maxFreq > k) {
            System.out.println("Match with maximal frequency " + maxFreq + " at value " + value);
        } else {
            System.out.println("No match");
        }

    }

    /**
     * Checks if there are strictly two elements in the array whose sum equals k.
     * Uses a HashSet for expected O(n) runtime.
     *
     * @param array the array of integers
     * @param k the target sum
     */
    public static void hasPairWithSum(int[] array, int k) {

        if (array == null || array.length < 2) {
            System.err.println("Invalid array");
            return;
        }

        Set<Integer> numbers = new HashSet<>();

        for (int number : array) {
            int complement = k - number;

            if (numbers.contains(complement)) {
                System.out.println("Pair found: " + number + " + " + complement + " = " + k);
                return;
            }

            numbers.add(number);
        }

        System.out.println("No pair found");

    }


}
