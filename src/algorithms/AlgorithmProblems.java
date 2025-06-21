package algorithms;

import java.util.*;

public class AlgorithmProblems {
    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 5, 5, 5, 5, 4, 54, 23, 42, 43};
        int[] arr1 = {};
        int[] arr3 = {-1, -1, -1, 0};
        hasFrequentElementOverK(arr, 3);
        hasFrequentElementOverK(arr1, 0);
        hasFrequentElementOverK(arr3, 2);
    }

    /**
     * Determines whether there exists an integer in the array that appears more than k times.
     * The algorithm runs in linear time: O(n), where n is the length of the array.
     *
     * @param array the array of integers to be checked
     * @param k the repetition threshold
     */

    public static void hasFrequentElementOverK(int[] array, int k) {

        if (array.length < 1) {
            System.err.println("There must be at least one element in the array");
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
}
