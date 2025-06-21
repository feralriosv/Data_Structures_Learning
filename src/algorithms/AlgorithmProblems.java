package algorithms;

import java.util.*;

public class AlgorithmProblems {
    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 5, 5, 5, 5, 4, 54, 23, 42, 43};

        hasRepeatedMoreThanKTimes(arr, 3);
    }

    /**
     * Determines whether there exists an integer in the array that appears more than k times.
     * The algorithm runs in linear time: O(n), where n is the length of the array.
     *
     * @param array the array of integers to be checked
     * @param k the repetition threshold
     * @return true if any integer appears more than k times, false otherwise
     */

    public static void hasRepeatedMoreThanKTimes(int[] array, int k) {
        Map<Integer, Integer> frequencies = new HashMap<>();
        int maxFreq = 0;

        for (int value : array) {

            int frequency = frequencies.getOrDefault(value, 0) + 1;

            if (frequency > k) {
                System.out.println("FOUND: " + value);
                return;
            }

            frequencies.put(value, frequency);
        }

        System.out.println("NO MATCH");
    }
}
