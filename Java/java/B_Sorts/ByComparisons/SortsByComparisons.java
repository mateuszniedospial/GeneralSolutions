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

    static void selection(int[] toSort){
        int length = toSort.length;
        int iteratorA;
        int iteratorB;
        for(iteratorA = 0; iteratorA < length-1; iteratorA++){
            iteratorB = iteratorA+1;
            while(iteratorB < length){
                if(toSort[iteratorA] > toSort[iteratorB]){
                    int temp = toSort[iteratorA];
                    toSort[iteratorA] = toSort[iteratorB];
                    toSort[iteratorB] = temp;
                }
                iteratorB++;
            }
        }
    }

    static void insertion(int[] toSort){
        for(int itA = 1; itA < toSort.length; itA++){
            int itB = itA-1;
            int itAA = itA;
            while(itB >= 0){
                if(toSort[itB] > toSort[itAA]){
                    int temp = toSort[itAA];
                    toSort[itAA] = toSort[itB];
                    toSort[itB] = temp;
                }
                itB--;
                itAA--;
            }
        }
    }

    static void shell(int[] toSort){
        int gap = toSort.length/2;
        while(gap > 0){
            for(int itA = gap; itA < toSort.length; itA++){
                int itB = itA - gap;
                int itAA = itA;
                while(itB >= 0 && (itAA < toSort.length)){
                    if(toSort[itB] > toSort[itAA]){
                        int temp = toSort[itB];
                        toSort[itB] = toSort[itAA];
                        toSort[itAA] = temp;
                    }
                    itB -= gap;
                    itAA -= gap;
                }
            }
            gap /= 2;
        }
    }

    static void bubble(int[] toSort){
        boolean wasSwapped;
        do {
            wasSwapped = false;
            for(int i = 0; i < toSort.length; i++){
                if(i+1 < toSort.length){
                    if(toSort[i] > toSort[i+1]){
                        int temp = toSort[i];
                        toSort[i] = toSort[i+1];
                        toSort[i+1] = temp;
                        wasSwapped = true;
                    }
                }
            }
        } while(wasSwapped);
    }

    static void mergeSortThe2nd(int[] toSort){
        split(toSort, 0, toSort.length-1);
    }

    private static void split(int[] toSort, int low, int high){
        if(low < high){
            int mid = (low+high)/2;
            split(toSort, low, mid);
            split(toSort, mid+1, high);
            mergeThe2nd(toSort, low, mid, high);
        }
    }

    private static void mergeThe2nd(int[] toSort, int low, int mid, int high) {
        int[] helper = new int[high+1];
        for(int i = 0; i <= high; i++){
            helper[i] = toSort[i];
        }

        int i = low;
        int j = mid+1;
        int k = low;

        while(i <= mid && j <= high){
            if(helper[i] < helper[j]){
                toSort[k] = helper[i];
                i++;
            } else {
                toSort[k] = helper[j];
                j++;
            }
            k++;
        }

        while(i < mid || j < high){
            if(i < mid){
                toSort[k] = helper[i];
                i++;
            } else {
                toSort[k] = helper[j];
                j++;
            }
            k++;
        }
    }

    static void mergeSortThe3rd(int[] toSort){
        splitRec(toSort, 0, toSort.length-1);
    }

    private static void splitRec(int[] toSort, int low, int upper) {
        if(low < upper){
            int middle = low + (upper-low)/2;
            splitRec(toSort, low, middle);
            splitRec(toSort, middle+1, upper);
            mergeThe3rd(toSort, low, middle, upper);
        }
    }

    private static void mergeThe3rd(int[] toSort, int low, int middle, int upper) {
        int[] helper = new int[toSort.length];
        for(int i = low; i<toSort.length; i++){
            helper[i] = toSort[i];
        }

        int i = low;
        int j = middle+1;
        int k = low;

        while(i <= middle && j <= upper){
            if(helper[i] <= helper[j]){
                toSort[k] = helper[i];
                i++;
            } else {
                toSort[k] = helper[j];
                j++;
            }
            k++;
        }

        while(i <= middle){
            toSort[k] = helper[i];
            i++;
            k++;
        }
    }

    static void quickSortThe2nd(int [] array, int startPosition, int lastPosition){
        if(startPosition < lastPosition){
            int division = partitionThe2nd(array, startPosition, lastPosition);
            quickSortThe2nd(array, startPosition, division-1);
            quickSortThe2nd(array, division+1, lastPosition);
        }
    }

    private static int partitionThe2nd(int[] array, int low, int upper) {
        int lastValue = array[upper];
        int k = low - 1;
        for(int j = low; j < upper; j++){
            if(array[j] < lastValue){
                k++;
                int temp = array[k];
                array[k] = array[j];
                array[j] = temp;
            }
        }

        int temp = array[k+1];
        array[k+1] = array[upper];
        array[upper] = temp;
        return k+1;
    }

    static void countingSort(int[] toSort, int minValue, int maxValue){
        int bound = (maxValue - minValue) + 1;
        int[] helper = new int[bound];

        //Int always has initial values = 0;
        for(int i = 0; i < toSort.length; i++){
            int temp = toSort[i];
            helper[temp-1] += 1;
        }

        int j = 0;

        for(int k = 0; k < helper.length; k++){
            while(helper[k] != 0){
                toSort[j] = k + minValue;
                j++;
                helper[k] -= 1;
            }
        }

        //For GC;
        helper = null;
    }

    public static void main(String[] args) {
//        int[] array = {7, 10, 1, 2, 14, 8, 5, 9, 12, 3};
        int[] array = {1, 5, 1, 4, 3, 2, 3, 6, 6, 1};
//        selection(array);
//        for(int a : array){
//            System.out.println(a);
//        }

        countingSort(array, 1, 6);
        for(int a : array){
            System.out.println(a);
        }
    }
}
