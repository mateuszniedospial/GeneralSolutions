package C_DataStructures;

import C_DataStructures.Enums.HeapType;

import java.util.Arrays;

/**
 * Created by Mateusz Niedośpiał on 26.04.2017.
 *
 * All data structures written under C_DataStructure package are
 * for educational purposes only. That is why there is no architecture
 * behind them i.e neither interfaces are implemented nor abstract classes extended.
 * There are also no Serializable & Cloneable interfaces implemented.
 *
 * This is standard HEAP data structure based on a binary tree.
 * Underneath it is a simple array of (unfortunately) an <p> INTEGER </p> type.
 * To make this structure a generic heap (Heap<T>) one must change array to Object[]
 * and cast Object elements to (T) after retrieving and before return call.
 * Then it is a necessity to include a comparator to use specific method for adjusting
 * priority of elements placement in a heap (if comparator is null, then a natural ordering would be used).
 *
 * In addition this Heap contains methods which in general are characteristic operations of Priority Queues:
 * Insert/MaxOrMin/Extract/IncreaseKey etc.
 * This way the HEAP can be as well considered as a simple PQ.
 *
 * Note that inside there is also an implementation of the popular sorting algorithm <i>heapsort</i> which uses
 * Heap as an underneath data structure to execute operations.
 *
 * EDIT: 11.05.2017.
 * The example of how to modify Heap to be of a generic type and use Comparator (which is described above)
 * can be seen under C_DataStructures/BinarySearchTree, where I have provided such an implementation to make
 * BinarySearchTree a generic data structure.
 */
public class Heap {
    //Underneath array:
    private int[] array;

    //Heap-size:
    private int size;

    //Heap-type:
    private HeapType heapType;

    public Heap(int[] array, HeapType heapType) {
        this.array = Arrays.copyOf(array, array.length);
        this.size = array.length-1;
        this.heapType = heapType;

        if(heapType == HeapType.MAX){
            buildMaxHeap();
        } else if(heapType == HeapType.MIN){
            buildMinHeap();
        }
    }

    public int[] get() {
        return array;
    }

    public int size() {
        return size;
    }

    private void buildMaxHeap(){
        for(int i = size/2 ; i >= 0 ; i--){
            maxHeapify(i);
        }
    }

    private void buildMinHeap(){
        for(int i = size/2 ; i >= 0 ; i--){
            minHeapify(i);
        }
    }

    private void maxHeapify(int index) {
        int leftUnderNodeMax = getLeftUnderNodeMax(index);
        int rightUnderNodeMax = getRightUnderNodeMax(index);
        int largest;

        if(leftUnderNodeMax <= size && array[leftUnderNodeMax] > array[index]){
            largest = leftUnderNodeMax;
        } else {
            largest = index;
        }

        if(rightUnderNodeMax <= size && array[rightUnderNodeMax] > array[largest]){
            largest = rightUnderNodeMax;
        }

        if(largest != index){
            int temp = array[index];
            array[index] = array[largest];
            array[largest] = temp;
            maxHeapify(largest);
        }
    }

    private void minHeapify(int index) {
        int leftUnderNodeMax = getLeftUnderNodeMax(index);
        int rightUnderNodeMax = getRightUnderNodeMax(index);
        int smallest;

        if(leftUnderNodeMax <= size && array[leftUnderNodeMax] < array[index]){
            smallest = leftUnderNodeMax;
        } else {
            smallest = index;
        }

        if(rightUnderNodeMax <= size && array[rightUnderNodeMax] < array[smallest]){
            smallest = rightUnderNodeMax;
        }

        if(smallest != index){
            int temp = array[index];
            array[index] = array[smallest];
            array[smallest] = temp;
            minHeapify(smallest);
        }
    }

    private int getLeftUnderNodeMax(int index){
        if(index == 0){
            return 1;
        } else {
            return 2*index+1;
        }

    }

    private int getRightUnderNodeMax(int index){
        if(index == 0){
            return 2;
        } else {
            return 2*index+2;
        }
    }

    private int getParentNodeIndex(int index){
        if(index == 1){
            return 0;
        } else if(index == 2){
            return 0;
        } else if(index%2 == 0) {
            return index/2-1;
        } else {
            return index/2;
        }
    }

    public int[] heapsort(){
       return doHeapsort();
    }

    private int[] doHeapsort(){
        int[] backupArray = Arrays.copyOf(array, array.length);

        for(int i = size; i>=1; i--){
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;
            size = size - 1;
            doHeapify();
        }

        int[] sortedArray = Arrays.copyOf(array, array.length);
        array = Arrays.copyOf(backupArray, backupArray.length);
        size = backupArray.length-1;

        return sortedArray;
    }

    private void doHeapify(){
        if(heapType == HeapType.MAX){
            maxHeapify(0);
        } else if(heapType == HeapType.MIN){
            minHeapify(0);
        } else {
            throw new UnsupportedOperationException("Cannot perform heapsort on an unknown heap type.");
        }
    }

    public int getRoot(){
        return array[0];
    }

    public int extractRoot(){
        if(size < 0){
            throw new UnsupportedOperationException("Heap is empty.");
        }
        int maxOrMin = array[0];
        array[0] = array[size];
        size -= 1;
        doHeapify();
        return maxOrMin;
    }

    public void changeKeyDependingOnHeapType(int index, int key){
        if(heapType == HeapType.MIN){
            decreaseKey(index, key);
        } else if(heapType == HeapType.MAX){
            increaseKey(index, key);
        } else {
            throw new UnsupportedOperationException("Cannot perform heapsort on an unknown heap type.");
        }
    }

    private void increaseKey(int index, int key){
        if(key < array[index]){
            throw new UnsupportedOperationException("Max heap can only increase keys.");
        }
        array[index] = key;
        while(index > 0 && array[getParentNodeIndex(index)] < array[index]){
            int temp = array[getParentNodeIndex(index)];
            array[getParentNodeIndex(index)] = array[index];
            array[index]=temp;
            index= getParentNodeIndex(index);
        }
    }

    private void decreaseKey(int index, int key){
        if(key > array[index]){
            throw new UnsupportedOperationException("Max heap can only increase keys.");
        }
        array[index] = key;
        while(index > 0 && array[getParentNodeIndex(index)] > array[index]){
            int temp = array[getParentNodeIndex(index)];
            array[getParentNodeIndex(index)] = array[index];
            array[index]=temp;
            index= getParentNodeIndex(index);
        }
    }

    public void insert(int key){
        array = Arrays.copyOf(array, array.length + 1);
        size += 1;
        if(heapType == HeapType.MAX){
            array[size] = Integer.MIN_VALUE;
        } else if(heapType == HeapType.MIN){
            array[size] = Integer.MAX_VALUE;
        } else {
            throw new UnsupportedOperationException("Cannot perform heapsort on an unknown heap type.");
        }
        changeKeyDependingOnHeapType(size, key);
    }
}
