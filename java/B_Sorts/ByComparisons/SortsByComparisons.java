package B_Sorts.ByComparisons;

import C_DataStructures.Heap;
import C_DataStructures.Enums.HeapType;
import java.util.concurrent.ThreadLocalRandom;

import B_Sorts.LinearTimeSorts;

/**
 * Created by Mateusz Niedośpiał on 27.04.2017.
 *
 * @see LinearTimeSorts
 */
public class SortsByComparisons {

    //Private constructor to prevent instantiating.

    private SortsByComparisons() {}

    //Used often for sorting a large amount of data.
    //The modification is supposed to create more balanced divisions during partition function.
    //Worst scenario: O(n^2) ; average (definitely most often and pretty assured by randomized modification): O(n*lg(n))

    public static void randomizedQuicksort(int[] array, int firstIndex, int lastIndex){
        if (firstIndex < lastIndex) {
            int middleIndex = randomizedPartition(array, firstIndex, lastIndex);
            randomizedQuicksort(array, firstIndex, middleIndex-1);
            randomizedQuicksort(array, middleIndex+1, lastIndex);
        }
    }

    //Randomized partition is making a change in array between the last index value and pseudo-random selected index;
    //This way the divisions created by partition method should be more balanced (trying to min 9n/10 & n/10 divisions)

    private static int randomizedPartition(int[] array, int firstIndex, int lastIndex) {
        int randomIndex = ThreadLocalRandom.current().nextInt(firstIndex, lastIndex+1);
        int temp = array[randomIndex];
        array[randomIndex] = array[lastIndex];
        array[lastIndex] = temp;

        return partition(array, firstIndex, lastIndex);
    }


    //The worst scenario: O(n^2) ; average (and definitely most often): O(n*lgn)

    public static void quicksort(int[] array, int firstIndex, int lastIndex){
        if(firstIndex < lastIndex){
            int middleIndex = partition(array, firstIndex, lastIndex);
            quicksort(array, firstIndex, middleIndex-1);
            quicksort(array, middleIndex+1, lastIndex);
        }
    }

    private static int partition(int[] array, int firstIndex, int lastIndex){
        int lastValue = array[lastIndex];
        int divisionIndex = firstIndex-1;
        for(int j = firstIndex; j <= lastIndex-1; j++){
            if(array[j] <= lastValue){
                divisionIndex += 1;
                int temp = array[divisionIndex];
                array[divisionIndex] = array[j];
                array[j] = temp;
            }
        }
        int temp = array[divisionIndex+1];
        array[divisionIndex+1] = array[lastIndex];
        array[lastIndex] = temp;
        return divisionIndex+1;
    }

    //
    //Heapsort is implemented in G_DataStructures/Heap as one of the class functions.
    //Complexity stays at O(n*lgn). In an average situation its still O(n*lgn)
    //That is why it is comparable to both Merge and Quick sorts.
    //

    public static int[] heapsort(int[] p_arrayToSort, HeapType p_heapType){
        Heap heap = new Heap(p_arrayToSort, p_heapType);
        return heap.heapsort();
    }

    //
    //Recursive Merge sort of complexity O(n*lgn).
    //Basically in an average scenario quicksort is a better in terms of speed due to fact
    //that quicksort does less comparisons in its loops. Quicksort is better also in terms of memory allocation,
    //since quicksort perform all operations without more memory needed, and merge sort needs to allocate memory
    //for additional tables in internal merge() function. Merge sort is a sorting algorithm which one wants
    //(actually a modified one but fundamentally merge) when data to sort is stored on the hard disk not in RAM.
    //It is due to fact that hard disk has no trouble reading or writing megabytes per second of data sequentially,
    //but is limited in an amount of seeks it can do.
    //

    public static void mergeSort(int[] p_arrayToSort, int p_LowerIndex, int p_UpperIndex){
//        long measureTimeStart = System.nanoTime();

        mergeSortRecursive(p_arrayToSort, p_LowerIndex, p_UpperIndex);

//        long measureTimeEnd = System.nanoTime();
//        System.out.println("MergeSortTook: " + (measureTimeEnd - measureTimeStart) + " ns");
//        System.out.println("After:");
//        Arrays.stream(p_arrayToSort).forEach(System.out::println);
    }

    private static void mergeSortRecursive(int[] p_arrayToSort, int p_LowerIndex, int p_UpperIndex){
        if(p_LowerIndex<p_UpperIndex){
            int middleIndex = (p_LowerIndex+p_UpperIndex)/2;
            mergeSortRecursive(p_arrayToSort, p_LowerIndex, middleIndex);
            mergeSortRecursive(p_arrayToSort, middleIndex+1, p_UpperIndex);
            merge(p_arrayToSort, p_LowerIndex, middleIndex, p_UpperIndex);
        }
    }

    private static void merge(int[] p_arrayToSort, int p_LowerIndex, int p_MiddleIndex, int p_UpperIndex){
        int n1 = p_MiddleIndex - p_LowerIndex + 1;
        int n2 = p_UpperIndex - p_MiddleIndex;

        //+1 due to INF pointers:
        int[] tableA = new int[n1+1];
        int[] tableB = new int[n2+1];

        for(int iterator = 0; iterator < n1; iterator++){
            tableA[iterator] = p_arrayToSort[p_LowerIndex+iterator];
        }

        for(int iterator = 0; iterator < n2; iterator++){
            tableB[iterator] = p_arrayToSort[p_MiddleIndex+iterator];
        }

        tableA[n1] = Integer.MAX_VALUE;
        tableB[n2] = Integer.MAX_VALUE;

        int iteratorA = 0;
        int iteratorB = 0;

        for(int loop=p_LowerIndex; loop < p_UpperIndex; loop++){
            if(tableA[iteratorA] <= tableB[iteratorB]){
                p_arrayToSort[loop] = tableA[iteratorA];
                iteratorA = iteratorA+1;
            } else {
                p_arrayToSort[loop] = tableB[iteratorB];
                iteratorB = iteratorB+1;
            }
        }
    }

    //Bubble sort is well known yet ineffective algorithm.
    //Complexity: O(n^2);

    public static void bubbleSort(int[] p_arrayToSort){
        for(int iteratorA = 0; iteratorA < p_arrayToSort.length-2; iteratorA++){
            for(int iteratorB = 0; iteratorB < p_arrayToSort.length-1; iteratorB++){
                if(p_arrayToSort[iteratorB] > p_arrayToSort[iteratorB+1]){
                    int temp = p_arrayToSort[iteratorB];
                    p_arrayToSort[iteratorB] = p_arrayToSort[iteratorB+1];
                    p_arrayToSort[iteratorB+1] = temp;
                }
            }
        }
    }

    public static void bubbleSortReversed(int[] p_arrayToSort){
        for(int iteratorA = 0; iteratorA < p_arrayToSort.length-1; iteratorA++){
            for(int iteratorB = p_arrayToSort.length-1; iteratorB > iteratorA ; iteratorB--){
                if(p_arrayToSort[iteratorB] < p_arrayToSort[iteratorB-1]){
                    int temp = p_arrayToSort[iteratorB];
                    p_arrayToSort[iteratorB] = p_arrayToSort[iteratorB-1];
                    p_arrayToSort[iteratorB-1] = temp;
                }
            }
        }
    }

    //Easy sort algorithm of complexity O(n^2);
    //Well known modification of insertionSort is SHELL SORT,
    //Shell sort creates intervals within the array e.g for every third element,
    //And compare only those in the first iteration, then iterates with interval e.g every fifth element.
    //It makes insertion sort better due to fact that in the later iterations the divided part are more
    //sorted already and need less insertion changes.

    public static void insertionSort(double[] p_arrayToSort){
//        long measureTimeStart = System.nanoTime();

        double key;
        for(int j = 1 ; j < p_arrayToSort.length; j++){
            key = p_arrayToSort[j];
            int i = j-1;

            while(i>=0 && p_arrayToSort[i]>key){
                p_arrayToSort[i+1] = p_arrayToSort[i];
                i = i-1;
            }
            p_arrayToSort[i+1] = key;
        }

//        long measureTimeEnd = System.nanoTime();
//        System.out.println("InsertionSortTook: " + (measureTimeEnd - measureTimeStart) + " ns");
//        System.out.println("After:");
//        Arrays.stream(p_arrayToSort).forEach(System.out::println);
    }

    //One of the easiest sort algorithms of complexity O(n^2).
    //Can be speed up by selecting both MIN and MAX value.

    public static void selectionSort(int[] p_arrayToSort){
//        long measureTimeStart = System.nanoTime();

        for(int iterator=0; iterator < p_arrayToSort.length ; iterator++){
            reOrganiseArray(p_arrayToSort, iterator);
        }

//        long measureTimeEnd = System.nanoTime();
//        System.out.println("SelectionSortTook: " + (measureTimeEnd - measureTimeStart) + " ns");
//        System.out.println("After:");
//        Arrays.stream(p_arrayToSort).forEach(System.out::println);
    }

    private static void reOrganiseArray(int[] p_array, int p_iteratorA){
        int iteratorB = p_iteratorA+1;
        while(iteratorB < p_array.length){
            if(p_array[p_iteratorA] > p_array[iteratorB]){
                int insert = p_array[p_iteratorA];
                p_array[p_iteratorA] = p_array[iteratorB];
                p_array[iteratorB] = insert;
            }
            iteratorB++;
        }
    }
}
