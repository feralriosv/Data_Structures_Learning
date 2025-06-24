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
        int leftLength = mid - left + 1;
        int rightLength = right - mid;

        int[] leftPart = Arrays.copyOfRange(array, left, mid + 1);
        int[] rightPart = Arrays.copyOfRange(array, mid + 1, right + 1);

        int indexLeft = 0, indexRight = 0, inversionCounter = 0;
        int mergeIndex = left;

        while (indexLeft < leftLength && indexRight < rightLength) {

            if (leftPart[indexLeft] <= rightPart[indexRight]) {
                array[mergeIndex] = leftPart[indexLeft];
                indexLeft++;
            } else {
                array[mergeIndex] = rightPart[indexRight];
                indexRight++;
                inversionCounter += leftLength - indexLeft;
            }

            mergeIndex++;
        }

        copyRest(leftPart, array, indexLeft, mergeIndex);
        copyRest(rightPart, array, indexRight, mergeIndex);

        return inversionCounter;
    }

    private static void copyRest(int[] source, int[] target, int sourceIndex, int targetIndex) {
        while (sourceIndex < source.length) {
            target[targetIndex++] = source[sourceIndex++];
        }
    }

    /**
     * Calculates the LIS length of the introduced list.
     *
     * @param list the list to be checked.
     * @return the length of the LIS.
     */
    public static int LISLength(List<Integer> list) {
        List<Integer> sequence = new ArrayList<>();

        for (Integer num : list) {
            int index = locate(sequence, num);

            if (index < 0) {
                index = -(index + 1); // Decodes insertIndex: "not found, but it should be at ..."
            }

            if (index == sequence.size()) {
                sequence.add(num);
            } else {
                sequence.set(index, num);
            }
        }
        // The sequence will always be in ascending order
        // It will have the lowest values on each position.
        return sequence.size();
    }

    /**
     * Computes a traditional BinarySearch algorithm.
     *
     * @param list the list where the element is going to be searched.
     * @param element the element to be searched.
     * @return the list index where the element is located or should be located (in case not found)
     *
     */
    public static int locate(List<Integer> list, int element) {
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

        // Negative value means the element was not found
        // The index is transposed by 1 to avoid ambiguity when the element is found at index 0
        return -(left + 1);
    }
}
