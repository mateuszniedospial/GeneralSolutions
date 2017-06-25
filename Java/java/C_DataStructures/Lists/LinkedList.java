package C_DataStructures.Lists;

import C_DataStructures.Enums.LinkedListEnds;

import java.util.Collection;
import java.util.NoSuchElementException;

/**
 * Created by Mateusz Niedośpiał on 01.05.2017.
 *
 * All data structures written under C_DataStructure package are
 * for educational purposes only. That is why there is no architecture
 * behind them i.e neither interfaces are implemented nor abstract classes extended.
 * There are also no Serializable & Cloneable interfaces implemented.
 *
 * Simple LinkedList data structure implementation that is:
 * doubly linked, not sorted, not synchronized and not cyclical.
 *
 * @param <T> is any type of elements that LinkedList holds;
 * The main idea is to keep elements inside of a node objects which
 * provide information about predecessor and successor via references.
 *
 * Index counting within the list is realised the same way as in Array:
 * if size = 5, then iterating via elements is from 0 to 4 (included).
 * First element is referred to as a 'head' and the last one as a 'tail'.
 *
 * Note that some of the linkedList operations are not included e.g:
 * set (as replace), peek, push, pop, indexOf etc.
 * (Many of them are implemented because of the fact that LinkedList implements
 * interfaces which require them).
 *
 * (In Java implementation the fields are transient due to the fact
 * that read and write object methods are implemented to properly manage
 * serialization of instances.)
 *
 * @see ArrayList
 */
public class LinkedList<T> {

    private int size = 0;

    /**
     * Head is the reference to the first element on the linked list.
     */
    private Node<T> head;

    /**
     * Tail is the reference to the last element on the linked list.
     */
    private Node<T> tail;

    public LinkedList() {}

    public LinkedList(Collection<? extends T> collection){
        this();
        addAll(collection);
    }

    public void add(T element){
        linkFirst(element);
    }

    public void add(T element, int index){
        checkElementIndex(index);
        linkAt(nodeOf(index), element);
    }

    public void add(T element, LinkedListEnds position){
        if(position == LinkedListEnds.BEGINNING){
            linkFirst(element);
        } else if(position == LinkedListEnds.END){
            linkLast(element);
        } else {
            throw new UnsupportedOperationException("Cannot add to list at the unknown end type.");
        }
    }

    @SuppressWarnings("unchecked")
    public void addAll(Collection<? extends T> collection){
        Object[] keys = collection.toArray();
        for(int i = keys.length-1; i >= 0; i--){
            add((T)keys[i]);
        }
    }

    public T removeFirst(){
        checkIfEmpty();
        return unlinkFirst();
    }

    public T removeLast(){
        checkIfEmpty();
        return unlinkLast();
    }

    public T remove(T object){
        if(object != null){
           for(int i=0; i<size; i++){
               if(object.equals(nodeOf(i).key)){
                   return unlink(nodeOf(i));
               }
           }
        } else {
           for(int i=0; i<size; i++){
               if(nodeOf(i).key == null){
                   return unlink(nodeOf(i));
               }
           }
        }
        throw new UnsupportedOperationException("There is no such element in the list.");
    }

    public T remove(int index){
        checkElementIndex(index);
        return unlink(nodeOf(index));
    }

    public T retrieve(T object){
        if(object != null){
          for(int i = 0; i < size; i++){
              if(object.equals(nodeOf(i).key)){
                  return nodeOf(i).key;
              }
          }
        } else {
            for(int i = 0; i < size; i++){
                if(nodeOf(i).key == null){
                    return nodeOf(i).key;
                }
            }
        }
        throw new NoSuchElementException("There is no such element in the list.");
    }

    public T retrieve(int index){
        checkElementIndex(index);
        return nodeOf(index).key;
    }

    public int getSize() {
        return size;
    }

    public T getHead() {
        checkElementIndex(0);
        return head.key;
    }

    public T getTail() {
        checkElementIndex(size-1);
        return tail.key;
    }

    public boolean contains(T element){
        for(int i = 0; i < size; i++){
            if(element.equals(nodeOf(i).key)){
                return true;
            }
        }
        return false;
    }

    public void clear(){
        int currentSize = size;
        for(int i = 0; i < currentSize; i++){
            unlinkFirst();
        }
    }

    private void linkAt(Node<T> currentElement, T newElement){
        Node<T> toInsert = new Node<>(newElement, currentElement.prev, currentElement);
        currentElement.prev = toInsert;

        if(toInsert.prev == null) {
            head = toInsert;
        } else {
            currentElement.prev.prev.next = toInsert;
        }

        size++;
    }

    private void linkFirst(T element){
        Node<T> prevHead = head;
        Node<T> newNode = new Node<>(element, null, prevHead);
        head = newNode;

        if(prevHead == null){
            tail = newNode;
        } else if(prevHead.next == null) {
            prevHead.prev = newNode;
            tail = prevHead;
        } else {
            prevHead.prev = newNode;
        }

        size++;
    }

    private void linkLast(T element){
        Node<T> prevTail = tail;
        Node<T> newNode = new Node<>(element, tail, null);
        tail = newNode;

        if(prevTail == null){
            head = newNode;
        } else if(prevTail.prev == null){
            prevTail.next = newNode;
            head = prevTail;
        } else {
            prevTail.next = newNode;
        }

        size++;
    }

    private T unlinkFirst(){
        Node<T> element = head;
        T key = element.key;

        if(element.next != null){
            element.next.prev = null;
            head = element.next;

            //Thanks to this Garbage Collector will faster get rid of the unlinked object;
            element.prev = null;
            element.next = null;
        }

        //Thanks to this Garbage Collector will faster get rid of the unlinked object;
        element.key = null;

        size--;
        return key;
    }

    private T unlinkLast(){
        Node<T> element = tail;
        T key = element.key;

        if(element.prev != null){
            element.prev.next = null;
            tail = element.prev;

            //Thanks to this Garbage Collector will faster get rid of the unlinked object;
            element.prev = null;
            element.next = null;
        }

        //Thanks to this Garbage Collector will faster get rid of the unlinked object;
        element.key = null;

        size--;
        return key;
    }

    private T unlink(Node<T> node){
        if(node.prev == null){
            return unlinkFirst();
        }else if(node.next == null) {
            return unlinkLast();
        } else{
            T key = node.key;
            Node<T> predecessor = node.prev;
            predecessor.next = node.next;
            node.next.prev = predecessor;

            //Thanks to this Garbage Collector will faster get rid of the unlinked object;
            node.prev = null;
            node.next = null;
            node.key = null;

            size--;
            return key;
        }
    }

    private Node<T> nodeOf(int index){
        if(index < (size >> 1 )){
            Node<T> node = head;
            for(int i = 0; i < index; i++){
                node = node.next;
            }
            return node;

        } else {
            Node<T> node = tail;
            for(int i = size-1; i > index; i--){
                node = node.prev;
            }
            return node;
        }
    }

    private void checkElementIndex(int index){
        if(! isElement(index))
            throw new IndexOutOfBoundsException("There is no element of index: " + Integer.toString(index));
    }

    private boolean isElement(int index){
        return index >= 0 && index < size;
    }

    private void checkIfEmpty(){
        if(size == 0) throw new NoSuchElementException();
    }

    /**
     * Being static class makes sense here, because although it is an inner class
     * we do not need access to members of the parent class.
     * @param <T> means any type of elements that Node holds;
     * key is the element value that a node holds inside.
     */
    private static class Node<T> {
        T key;
        Node<T> prev;
        Node<T> next;

        Node(T key, Node<T> prev, Node<T> next) {
            this.key = key;
            this.prev = prev;
            this.next = next;
        }
    }
}
