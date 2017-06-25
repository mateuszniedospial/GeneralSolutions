package C_DataStructures.Lists;

import java.util.Arrays;
import java.util.Collection;
import java.util.NoSuchElementException;

/**
 * Created by Mateusz Niedośpiał on 02.05.2017.
 *
 * All data structures written under C_DataStructure package are
 * for educational purposes only. That is why there is no architecture
 * behind them i.e neither interfaces are implemented nor abstract classes extended.
 * There are also no Serializable & Cloneable interfaces implemented.
 *
 * This is simple ArrayList data structure implementation which is:
 * not synchronized and not sorted.
 *
 * @param <T> is any of element type that ArrayList holds;
 * The main idea is to have an array of object type underneath which
 * can extend its length (capacity) when needed (here by default it extends by 50%ofCurrentCapacity).
 *
 * The ArrayList is basically a vector data structure and differs from it slightly e.g vector
 * is synchronized and double capacity when it is needed.
 *
 * field: end is/or need to be/ the next available/empty index within the list.
 *
 * Note that not all of the ArrayList operations are included.
 *
 * (In Java implementation the field array is transient due to the fact
 * that read and write object methods are implemented to properly manage
 * serialization of instances.)
 *
 * @see LinkedList
 */
public class ArrayList<T> {

    private static final int INITIAL_CAPACITY = 10;
    private static final int MAX_CAPACITY = Integer.MAX_VALUE;

    private Object[] array;
    private int size;
    private int end;

    public ArrayList() {
        array = new Object[INITIAL_CAPACITY];
        size = INITIAL_CAPACITY;
        end = 0;
    }

    public ArrayList(Collection<? extends T> collection) {
        this();
        addAll(collection);
    }

    public void add(T element){
        checkCapacity();
        array[end] = element;
        end++;
    }

    public void add(int index, T element){
        checkCapacity();
        if(checkIndex(index)){
            addNew(index, element);
            end++;
        } else {
            extendCapacity();
            addNew(index, element);
            end++;
        }
    }

    @SuppressWarnings("unchecked")
    public void addAll(Collection<? extends T> collection) {
        Object[] objects = collection.toArray();
        if(checkRange(objects.length)){
            Arrays.stream(objects).forEach(element -> add((T)element));
        }else{
            extendCapacity(objects.length);
            Arrays.stream(objects).forEach(element -> add((T)element));
        }
    }

    public void addAll(int index, Collection<? extends T> collection){
        checkIndex(index);
        if(index == end){
            addAll(collection);
        } else {
            Object[] objects = collection.toArray();
            if(checkRange(objects.length)){
                addObjects(index, objects);
            } else {
                extendCapacity(objects.length);
                addObjects(index, objects);
            }
        }
    }

    @SuppressWarnings("unchecked")
    public T get(int index){
        checkIndex(index);
        return (T) array[index];
    }

    @SuppressWarnings("unchecked")
    public T set(int index, T element){
        checkIndex(index);
        T oldValue = (T) array[index];
        array[index] = element;
        return oldValue;
    }

    @SuppressWarnings("unchecked")
    public T remove(T element){
        int position = indexOf(element);
        T oldValue = (T) array[position];

        int toMove = end - position;
        if(toMove > 0){
            System.arraycopy(array, position+1, array, position, toMove);
        }
        array[--end] = null;
        return oldValue;
    }

    @SuppressWarnings("unchecked")
    public T remove(int index){
        checkIndex(index);
        if(ifNotNull(index)){
            T oldValue = (T)array[index];
            partArrayMove(index);
            array[--size] = null;
            end--;
            return oldValue;
        } else {
            partArrayMove(index);
            array[--size] = null;
            end--;
            return null;
        }
    }

    @SuppressWarnings("unchecked")
    public T[] removeRange(int fromIndex, int toIndex){
        checkIndex(fromIndex);
        checkIndex(toIndex);
        Object[] copy = new Object[toIndex - fromIndex];
        System.arraycopy(array, fromIndex, copy, 0, toIndex - fromIndex);
        System.arraycopy(array, toIndex, array, fromIndex, end-toIndex);

        int newEnd = end - (toIndex-fromIndex);
        for(int i = newEnd; i < end; i++){
            array[i] = null;
        }
        size = size - (toIndex-fromIndex);
        end = newEnd;
        return (T[]) copy;
    }

    public void clear(){
        for(int i = 0; i < end; i++){
            array[i] = null;
        }
        size = 0;
        end = 0;
    }

    public boolean contains(T element){
        return indexOf(element) >= 0;
    }

    public void trimToEnd(){
        if(end < size){
            array = Arrays.copyOf(array, end);
            size = end;
        }
    }

    private void partArrayMove(int index){
        int toMove = size - index - 1;
        if(toMove > 0){
            System.arraycopy(array, index+1, array, index, size);
        }
    }

    private void addObjects(int index, Object[] objects) {
        System.arraycopy(array, index, array, index+objects.length, end+objects.length);
        int next = 0;
        for(int iterator = index; iterator <= index+objects.length; iterator++){
            array[iterator] = objects[next];
            next++;
        }
        end = end + objects.length;
    }

    private boolean ifNotNull(int index) {
        return array[index] != null;
    }

    @SuppressWarnings("unchecked")
    private int indexOf(T element) {
        for(int i = 0; i < end; i++){
            if (element.equals((T)array[i])) {
                return i;
            }
        }
        throw new NoSuchElementException();
    }

    public int size() {
        return end;
    }

    public int capacity(){
        return size;
    }

    public boolean isEmpty(){
        return end == 0;
    }

    private void addNew(int index, T element) {
        System.arraycopy(array, index, array, index+1, end-index);
        array[index] = element;
    }

    private boolean checkRange(int length) {
        return (end + length) < size;
    }

    private boolean checkIndex(int index) {
        if(index < size && index >= 0){
            return true;
        }
        throw new IndexOutOfBoundsException("Index cannot be greater than list size && Index cannot be a negative value.");
    }

    private void checkCapacity() {
        if(end == size){
            extendCapacity();
        }
    }

    private void extendCapacity() {
        int oldSize = size;
        if((oldSize+oldSize/2) < MAX_CAPACITY){
            array = Arrays.copyOf(array, size + size / 2);
            size = array.length;
        }else{
            array = Arrays.copyOf(array, MAX_CAPACITY);
            size = array.length;
        }
    }

    private void extendCapacity(int of){
        int oldSize = size;
        if((oldSize+of) < MAX_CAPACITY) {
            array = Arrays.copyOf(array, size + of);
            size = array.length;
        } else {
            array = Arrays.copyOf(array, MAX_CAPACITY);
            size = array.length;
        }
    }
}
