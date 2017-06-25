package C_DataStructures;

import java.util.Arrays;

/**
 * Created by Mateusz Niedośpiał on 01.05.2017.
 *
 * All data structures written under C_DataStructure package are
 * for educational purposes only. That is why there is no architecture
 * behind them i.e neither interfaces are implemented nor abstract classes extended.
 * There are also no Serializable & Cloneable interfaces implemented.
 *
 * This is standard (and very basic) QUEUE data structure implementation which
 * have an array of Objects underneath and offers enqueue (one element), enqueueMany (many elements),
 * dequeue, isEmpty, size and getTailIndex methods.
 *
 * In Java the queue is actually an interface and the most famous implementation of 'queue' is PriorityQueue.
 * PriorityQueue is underneath a HEAP data structure of a MIN type (which allows to prioritise using a comparator).
 *
 * In this case the Queue IS NOT of a cyclical type, thus the head remains at a 0 index position and only tail is
 * increased after an enqueue call and decreased after a dequeue call (this way no remove element method is necessary).
 */
public class Queue<T> {

    private Object[] array;
    private int tail;

    private int capacity;

    private static final int head = 0;
    private static final int initialCapacity = 10;

    public Queue() {
        array = new Object[initialCapacity];
        tail = 0;
        capacity = initialCapacity;
    }

    public void enqueue(T element){
        if(tail == capacity){
            extendCapacity();
        } else {
            array[tail] = element;
            tail += 1;
        }
    }

    public void enqueueMany(T[] elements){
        if(tail+elements.length <= capacity){
            Arrays.stream(elements).forEach(this::enqueue);
        } else {
            extendCapacity(elements.length);
            Arrays.stream(elements).forEach(this::enqueue);
        }
    }

    private void extendCapacity() {
        array = Arrays.copyOf(array, tail+initialCapacity);
        capacity = array.length;
    }

    private void extendCapacity(int enlargement){
        array = Arrays.copyOf(array, tail+enlargement);
        capacity = array.length;
    }

    @SuppressWarnings("unchecked")
    public T dequeue(){
        if(head == tail){
            throw new UnsupportedOperationException("Queue is currently empty.");
        } else {
            T element = (T) array[head];
            rebuildQueue();
            tail -= 1;
            return element;
        }
    }

    private void rebuildQueue() {
        for(int i = head+1; i < tail ; i++){
            array[i-1] = array[i];
        }
    }

    public boolean isEmpty(){
        return tail == 0;
    }

    public int size(){
        return capacity;
    }

    public int getTailIndex(){
        return tail;
    }
}
