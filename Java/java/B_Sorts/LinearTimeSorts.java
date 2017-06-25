package B_Sorts;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import B_Sorts.ByComparisons.SortsByComparisons;

/**
 * Created by Mateusz Niedośpiał on 28.04.2017.
 *
 * @see SortsByComparisons
 */
public class LinearTimeSorts {

    //Private constructor to prevent instantiating of LinearTimeSorts due to fact it contains only static methods.

    private LinearTimeSorts() {}

    //The bucket sort algorithm is optimal sorting algorithm when a specific assumptions are met.
    //For this case I assume that array which is passed to the method contains values from a range <0,1);
    //Moreover I could also assume that they are chosen in accordance with constant distribution.
    //Having those assumptions met bucket sort achieves complexity of O(n);
    //In the worst scenario it is O(n^2); due to the fact of having all data in one bucket which is then sorted by
    //regular sorting algorithm (e.g insertion sort).
    // What is worse it will still use more memory.

    public static double[] bucketSort(double[] array){
        int n = array.length;

        //Declaring a table of lists is usually (Personally, I found it always) described as a bad design practise.
        //The reason is that arrays are not supposed to be containers for data that represents objects (like List in this case),
        //this is because arrays are one of the basic data structure/types in java and it is kinda going behind OOP back to put
        //an interfaces inside the array. Add to this that arrays can be more dangerous (thread-safe issues, don't mix with generics and so on).
        //In the case though, I know exactly what length of a data structure its needed (and I need to store primitives), thus
        //I am using array since adding to an array at a specific position is O(1) and the list is (worst case) O(n);
        //Nevertheless desired approach is probably to use:
        //
        // !!!! List<ArrayList<Double>> buckets = new ArrayList<ArrayList<Double>>; !!!!
        //
        //This would force small changes in all operations of adding and retrieve from table which I have provided below.
        //I use ArrayList because in this case I have a little data input and array list in general is faster.
        //With a large list it " could " be better in some cases to use linked list because it has faster insert operation (up to O(1)),
        //but it would require a check anyways because ArrayList main benefit is O(1) seek for data at specific index.

        List<Double>[] buckets = new ArrayList[n];

        for(int i = 0; i < n; i++){
            buckets[i] = new ArrayList<Double>();
        }

        for (double value : array) {

            //Remember assumption about having values from a range: <0,1);
            buckets[(int) (n * value)].add(value);

        }

        for(int i = 0; i < n; i++){

            //Here one can use any of the desired sorting algorithms e.g:
            //Insertion Sort / Merge Sort / QuickSort etc. (Remember tho that their complexity is different!)
            //In this case Collections.sort is underneath a merge-sort algorithm with the modification of Tim Peter's
            //Known as TimSort algorithm;

            Collections.sort(buckets[i]);
        }

        double[] sorted = new double[array.length];
        int k = 0;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < buckets[i].size(); j++){
                sorted[k] = buckets[i].get(j);
                k+=1;
            }
        }
        return sorted;
    }

    //TODO
    public static void radixSort(int[] p_array, int howManyDigits){
        for(int i = 1; i<=howManyDigits; i++){
            stabilitySort(p_array, i);
        }
    }

    //TODO
    private static void stabilitySort(int[] p_array, int i) {

    }

    //Counting sort which complexity is guaranteed to be O(n + maxValueWithin n Elements);
    //Like in every sorting algorithm which can work in complexity O(n) there are additional assumptions for input data.
    //In case of counting sort we need an information about what is a MAX_VALUE in array and from what range values can be.
    //In this example assumption is that values can vary between  <0, to MAX_VALUE>;

    public static int[] countingSort(int[] p_array, int maxValueInArray){
        int[] supportingArray = new int[maxValueInArray+1];
        int[] sortedArray = new int[p_array.length];


        //It is not required in this scenario because int primitive is initialized to zero by default in Java;

//        for(int i=0; i <= maxValueInArray; i++){
//            supportingArray[i] = 0;
//        }

        for (int element : p_array) {
            supportingArray[element] = supportingArray[element] + 1;
        }

        for(int i=2; i <= maxValueInArray; i++){
            supportingArray[i] = supportingArray[i] + supportingArray[i-1];
        }

        for(int i = p_array.length-1; i >= 0; i--){
            sortedArray[supportingArray[p_array[i]]-1] = p_array[i];
            supportingArray[p_array[i]] = supportingArray[p_array[i]]-1;
        }

        return sortedArray;
    }
}
