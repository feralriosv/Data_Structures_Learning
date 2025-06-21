package algorithms;

import java.util.*;

public class AlgorithmProblems {
    public static void main(String[] args) {
        int[] arr1 = {1, 2, 4, 5, 5, 5, 5, 4, 54, 23, 42, 43};
        int[] arr2 = {};
        int[] arr3 = {-1, -1, -1, 0 , -1};
        int[] arr4 = {5};

        hasFrequentElementOverK(null, 1);
        hasFrequentElementOverK(arr1, 3);
        hasFrequentElementOverK(arr2, 0);
        hasFrequentElementOverK(arr3, 2);
        System.out.print(System.lineSeparator());
        hasPairWithSum(arr1, -1);
        hasPairWithSum(arr4, 5);
        System.out.print(System.lineSeparator());
        countInversionsBrute(arr1);
        countInversionsBrute(arr2);
          countInversionsOptimal(arr3);
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
                System.out.printf("Pair found: %d + %d = %d%n", number, complement, k);
                return;
            }
            numbers.add(number);
        }

        System.out.println("No pair found");
    }

    /**
     * Calculates the number of unordered index pairs (i, j) in the array
     * such that i < j and A[i] > A[j].
     * This value is known as the "disorder" or inversion count of the array.
     * <p>
     * Runtime: O(n^2)
     *
     * @param array the array of integers (can contain duplicates)
     */
    public static void countInversionsBrute(int[] array) {
        if (array == null) {
            System.err.println("Invalid array");
            return;
        }

        int inversionCounter = 0;
        int n = array.length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i < j && array[i] > array[j]) {
                    inversionCounter++;
                }
            }
        }

        System.out.println("Total inversions: " + inversionCounter);
    }

    /**
     * Counts the number of inversions in the given array using a modified MergeSort algorithm.
     * An inversion is a pair of indices (i, j) such that i < j and A[i] > A[j].
     * <p>
     * Runtime: O(n·log(n))
     *
     * @param array the input array of integers
     */
    public static void countInversionsOptimal(int[] array) {
        if (array == null) {
            System.err.println("Invalid array");
            return;
        }

        int totalInversions = sortAndCountInversions(array, 0, array.length - 1);
        System.out.println(totalInversions);
    }

    private static int mergeAndCount(int[] array, int left, int mid, int right) {
        int leftPartLength = mid - left + 1;
        int rightPartLength = right - mid;

        int[] leftPart = Arrays.copyOfRange(array, left, mid + 1);
        int[] rightPart = Arrays.copyOfRange(array, mid + 1, right + 1);

        int indexLeft = 0, indexRight = 0, inversionCounter = 0;
        int mergeIndex = left;

        while (indexLeft < leftPartLength && indexRight < rightPartLength) {

            if (leftPart[indexLeft] <= rightPart[indexRight]) {
                array[mergeIndex] = leftPart[indexLeft];
                indexLeft++;
            } else {
                array[mergeIndex] = rightPart[indexRight];
                indexRight++;
                inversionCounter += leftPartLength - indexLeft;
            }

            mergeIndex++;
        }

        copyIfRest(leftPart, array, indexLeft, mergeIndex);
        copyIfRest(rightPart, array, indexRight, mergeIndex);

        return inversionCounter;
    }

    private static int sortAndCountInversions(int[] array, int left, int right) {
        int partialInversions = 0;

        if (left < right) {
            int mid = (left + right) / 2;

            partialInversions += sortAndCountInversions(array, left, mid);
            partialInversions += sortAndCountInversions(array, mid + 1, right);
            partialInversions += mergeAndCount(array, left, mid, right);
        }

        return partialInversions;
    }

    private static void copyIfRest(int[] source, int[] target, int sourceIndex, int targetIndex) {
        while (sourceIndex < source.length) {
            target[targetIndex++] = source[sourceIndex++];
        }
    }
}
