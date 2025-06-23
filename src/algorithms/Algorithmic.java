package algorithms;

import java.util.*;

public class Algorithmic {

    public Algorithmic() {
        // Utility class
    }

    /**
     * Determines whether there exists an integer in the array that appears more than k times using hash structures.
     * The algorithm runs in linear time: O(n), where n is the length of the array.
     *
     * @param array the array of integers to be checked
     * @param k the repetition threshold
     * @return an array indicating the element and its frequency if freq > k, otherwise null.
     */
    public static int[] isMoreThanKTimes(int[] array, int k) {
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
            return new int[] {maxFreq, value};
        } else {
            return null;
        }
    }

    /**
     * Searches for a pair of distinct numbers in the given array that add up to the target sum k.
     *
     * @param array the array of integers to search within
     * @param k the target sum to find as the sum of two elements
     * @return an array of two integers {a, b} such that a + b == k, or {@code null} if no such pair exists
     */
    public static int[] findPairWithSum(int[] array, int k) {
        Set<Integer> numbers = new HashSet<>();

        for (int number : array) {
            int complement = k - number;

            if (numbers.contains(complement)) {
                return new int[] {number, complement};
            }
            numbers.add(number);
        }

        return null;
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
    public static int countInversionsBrute(int[] array) {
        int inversionCounter = 0;
        int n = array.length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i < j && array[i] > array[j]) {
                    inversionCounter++;
                }
            }
        }

        return inversionCounter;
    }

    /**
     * Sorts recursively the given and counts the number of inversions.
     *
     * @param array the array of integers to be sorted and analyzed
     * @param left the starting index of the array
     * @param right the ending index of the array
     * @return the number of inversions found in the given array
     */
    public static int sortAndCountInversions(int[] array, int left, int right) {
        int partialInversions = 0;

        if (left < right) {
            int mid = (left + right) / 2;

            partialInversions += sortAndCountInversions(array, left, mid);
            partialInversions += sortAndCountInversions(array, mid + 1, right);
            partialInversions += mergeAndCount(array, left, mid, right);
        }

        return partialInversions;
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

    private static void copyIfRest(int[] source, int[] target, int sourceIndex, int targetIndex) {
        while (sourceIndex < source.length) {
            target[targetIndex++] = source[sourceIndex++];
        }
    }

    public static void findLIS(int[] array) {
        List<Integer> sequence = new ArrayList<>();

        sequence.add(array[0]);

        for (int i = 1; i < array.length; i++) {
            if (array[i] > sequence.getLast()) {
                System.out.println(sequence);
                sequence.add(array[i]);
            } else {
                int low = indexBinarySearch(sequence, array[i]);
                if (low < 0) {
                    low = -(low + 1);
                }
                sequence.set(low, array[i]);
            }
        }
    }

    public static int indexBinarySearch(List<Integer> list, int element) {
        int left = 0, right = list.size() - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (list.get(mid) == element) {
                return mid;
            } else if (list.get(mid) < element) {
                left = mid + 1;
            } else if (list.get(mid) > element){
                right = mid - 1;
            }
        }

        return -1 * left; // If not found returns the position where the value could be introduced
    }
}
