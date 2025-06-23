package algorithms;

import java.util.Arrays;
import java.util.List;

public class Testing {
    public static void main(String[] args) {
        int[] arr1 = {1, 2, 4, 5, 5, 5, 5, 4, 54, 23, 42, 43};
        int[] arr2 = {};
        int[] arr3 = {-1, -1, -1, 0 , -1};
        int[] arr4 = {5};
        int[] arr5 = {7, 8, 5, 4, 5, 2};
        List<Integer> list1 = List.of(3, 4, 6, 8, 14, 34);

        Algorithmic.hasFrequentElementOverK(null, 1);
        Algorithmic.hasFrequentElementOverK(arr1, 3);
        Algorithmic.hasFrequentElementOverK(arr2, 0);
        Algorithmic.hasFrequentElementOverK(arr3, 2);
        System.out.print(System.lineSeparator());
        Algorithmic.hasPairWithSum(arr1, -1);
        Algorithmic.hasPairWithSum(arr4, 5);
        System.out.print(System.lineSeparator());
        Algorithmic.countInversionsBrute(arr1);
        Algorithmic.countInversionsBrute(arr2);
        Algorithmic.countInversionsOptimal(arr3);

        System.out.println(Algorithmic.getIndexBinarySearch(list1, 11));
    }
}
