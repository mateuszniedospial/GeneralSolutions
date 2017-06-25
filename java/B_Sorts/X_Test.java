package B_Sorts;

import B_Sorts.ByComparisons.SortsByComparisons;

import java.util.Arrays;

/**
 * Created by Mateusz Niedośpiał on 27.04.2017.
 */
public class X_Test {
    public static void main(String[] args) {
        int[] array = {20,10,13,1,4,22,4,3,2};

        SortsByComparisons.quicksort(array, 0, array.length-1);

        Arrays.stream(array).forEach(System.out::println);

        int[] arrayB = {20,10,13,1,4,22,4,3,2};
        SortsByComparisons.bubbleSort(arrayB);

        System.out.println("Second array:");
        Arrays.stream(arrayB).forEach(System.out::println);

        int[] arrayD = {2,5,3,4,1};
        int[] sortedArray = LinearTimeSorts.countingSort(arrayD, 5);

        System.out.println("Counting sort: ");
        Arrays.stream(sortedArray).forEach(System.out::println);

        double[] arrayForBuckets = {0.78, 0.17, 0.39, 0.26, 0.72, 0.94, 0.21, 0.12, 0.23, 0.68};

        System.out.println("Bucket sort: ");
        Arrays.stream(LinearTimeSorts.bucketSort(arrayForBuckets)).forEach(System.out::println);
    }
}
