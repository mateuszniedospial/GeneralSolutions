package C_DataStructures;

import java.util.Arrays;
import java.util.EmptyStackException;

/**
 * Created by Mateusz Niedośpiał on 01.05.2017.
 *
 * All data structures written under C_DataStructure package are
 * for educational purposes only. That is why there is no architecture
 * behind them i.e neither interfaces are implemented nor abstract classes extended.
 * There are also no Serializable & Cloneable interfaces implemented.
 *
 * This is standard (and very basic) STACK data structure implementation which
 * have an array of Objects underneath and offers push (one element), pushMany (many elements),
 * pop, isEmpty, size and getTopIndex methods.
 *
 * Notice that Java STACK implementation include also method for removing elements while in here
 * there is no remove function (we could use e.g ArrayUtils.removeElement(array, element).
 * Instead of removing item while using 'pop()' we leave it in the array but decrement
 * the top field ('top-index') by one, then after using push on the instance of the STACK, the
 * item that was 'popped()' before, is rewritten and no longer exists. This way the 'pop' operation doesn't
 * force to create new copy of array underneath unless the STACK reaches its capacity;
 *
 * I considered adding one more constructor which would have a T[] parameter and would instantiate new stack
 * with already some data in it, but finally I decided not to do that since 'pushMany()' method is allowed.
 * (The way to do that would be e.g to create second constructor which parameter would be Collection <? extends T>,
 * make this collection to array and then use pushMany).
 *
 * Nowadays if there is need of stack like data-structure in Java it is preferable to make use of
 * 'deque' instead as its more consistent than an old stack (which btw extends Vector what's kinda weird) as its
 * implementation offer methods which only manipulates the end and the beginning of data structure and iterate over them.
 * Moreover Java stack implementation has no interface what makes it committed to a specific type.
 *
 * In Java Documentation it can be also read that Deque will be faster as stack than an old legacy stack implementation itself.
 */
public class Stack<T> {
    private Object[] array;
    private int top;
    private int capacity;

    private static final int initialCapacity = 10;

    public Stack() {
        this.array = new Object[initialCapacity];
        this.capacity = initialCapacity;
        this.top = 0;
    }

    public void push(T element){
        if(top == array.length){
            extendCapacity();
            array[top] = element;
            top += 1;
        } else {
            array[top] = element;
            top += 1;
        }
    }

    public void pushMany(T[] elements){
        if(elements.length + top <= capacity){
            Arrays.stream(elements).forEach(this::push);
        } else {
            extendCapacity(elements.length);
            Arrays.stream(elements).forEach(this::push);
        }
    }

    private void extendCapacity() {
        array = Arrays.copyOf(array, top+initialCapacity);
        capacity = array.length;
    }

    private void extendCapacity(int enlargement){
        array = Arrays.copyOf(array, top+enlargement);
        capacity = array.length;
    }

    @SuppressWarnings("unchecked")
    public T pop(){
        if(isEmpty()){
            throw new EmptyStackException(); //Could be also UnsupportedOperationException("Stack is currently empty.");
        } else {
            top -= 1;
            return (T) array[top];
        }
    }

    public boolean isEmpty(){
        return top == 0;
    }

    public int size(){
        return capacity;
    }

    public int getTopIndex(){
        return top;
    }
}
