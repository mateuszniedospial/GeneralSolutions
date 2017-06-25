package C_DataStructures.Maps;

import C_DataStructures.Lists.ArrayList;

import java.util.Map;
import java.util.NoSuchElementException;

/**
 * Created by Mateusz Niedośpiał on 04.05.2017.
 *
 * All data structures written under C_DataStructure package are
 * for educational purposes only. That is why there is no architecture
 * behind them i.e neither interfaces are implemented nor abstract classes extended.
 * There are also no Serializable & Cloneable interfaces implemented.
 *
 * This is simple HashMap data structure implementation which is not synchronized and
 * does not guarantee maintaining any specific order of the map (which may and probably will change over time rapidly).
 *
 * Underneath there is a simple array of objects used for data storage.
 * Note that it is different from java.util.HashMap because the java.util. HashMap array initialization
 * is made completely outside the constructor (which is better for memory allocation optimization
 * since no array initialization is needed before any data is put inside).
 *
 * In terms of hashing this implementation is highly inspired and constructed almost the same
 * as java.util.HashMap is. Slight difference occur due to using AND(&) logic binary operation instead of XOR (^).
 *
 * Buckets inside the underneath array are simple single LinkedList data structures implemented as instances of
 * nested class Node that is private and static (more information above the Node class implementation).
 *
 * Note that unlike java.util.HashMap this implementation does not change buckets implementation after
 * defined threshold is reached. Here buckets will always be represented by LinkedList structure. It is
 * less optimized approach since in java.util.HashMap buckets may transform to Red-Black Tree data structure,
 * which makes operations faster than in case of simple single LinkedList nodes.
 *
 * This implementation provide methods to retrieve entryList/keyList/valueList which are equivalents to java.util.HashMap
 * entrySet/keySet/values in terms of final results but implementation is different. Note that data is received as lists,
 * (C_DataStructures/ArrayList) more specifically and for entryList each entry is represented as instance of TreeNode nested class
 * (more information above the class itself). The approach to hold entries inside an ArrayList is worse than one presented in
 * java.util.HashMap because since HashMap does not guarantee any specific order of elements stored inside it is perfect
 * environment for using HashSet to store elements from the original HashMap (performance of retrieving data from HashSet
 * is in general better than ArrayList if the number of elements is not very small).
 * ( *** The only reason why HashSet was not used in the implementation is that there hasn't been
 * an implementation of it under G_DataStructures package yet *** ).
 *
 * The HashMap provide constant-time ( O(1) ) performance for both retrieving and inserting element
 * assuming the hash function distribute the elements properly among the buckets. Worst scenario is when all
 * elements are stored inside one bucket which makes it internally a simple single linkedList data structure with
 * also more memory allocation needed in total. That is why well optimized hashing procedure is crucial for the
 * HashMap implementation.
 *
 * @see RedBlackMap
 *
 * @param <K> type of keys held in HashMap;
 * @param <V> type of values held in HashMap;
 */
public class HashMap<K,V> {

    /**
     * Capacity used for underneath array when a default constructor is used.
     * Since this implementation of HashMap is copying hashing process written in
     * java.util.HashMap the capacity must be a power of two.
     *
     * Note that bit move on binary "1 << x" starting at one value (e.g 0001)
     * always results in pow(2,x). In this case the result is 2^4 = 16.
     */
    private static final int DEFAULT_CAPACITY = 1 << 4;

    /**
     * The same rule as in DEFAULT_CAPACITY, the value 30 is in this case used
     * due to maximal integer value limit.
     */
    private static final int MAXIMUM_CAPACITY = 1 << 30;


    /**
     * Default value of the LOAD_FACTOR that is used to
     * obtain threshold at which the array needs to be resized for
     * further usage (if the case capacity is doubled).
     */
    private static final float DEFAULT_LOAD_FACTOR = 0.75f;

    private Object[] array;

    private int size;
    private int threshold;

    private final float loadFactor;

    public HashMap() {
        initializeArray(DEFAULT_CAPACITY);
        this.threshold = (int) (DEFAULT_CAPACITY * DEFAULT_LOAD_FACTOR);
        this.loadFactor = DEFAULT_LOAD_FACTOR;
        this.size = 0;
    }

    public HashMap(int capacity, float loadFactor) {
        if(capacity < 0){
            throw new IllegalArgumentException("Illegal capacity: " + capacity);
        } else if (capacity > MAXIMUM_CAPACITY){
            capacity = MAXIMUM_CAPACITY;
        } else if (loadFactor <= 0 || Float.isNaN(loadFactor)){
            throw new IllegalArgumentException("Illegal load factor: " + loadFactor);
        }

        initializeArray(capacity);
        this.threshold = (int) (adjustCapacity(capacity)*loadFactor);
        this.loadFactor = loadFactor;
        this.size = 0;
    }

    public HashMap(int capacity){
        this(capacity, DEFAULT_LOAD_FACTOR);
    }

    public HashMap(Map<? extends K, ? extends V> map){
        this();
        putAll(map);
    }

    @SuppressWarnings("unchecked")
    private void initializeArray(int capacity) {
        capacity = adjustCapacity(capacity);
        array = new Object[capacity];
    }

    /**
     * Make sure that capacity of the array would be the power of two.
     */
    private static final int adjustCapacity(int capacity) {
        int n = capacity - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;

        if(n < 0){
            return 1;
        } else {
            if(n >= MAXIMUM_CAPACITY){
                return MAXIMUM_CAPACITY;
            } else {
                return n+1;
            }
        }
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    @SuppressWarnings("unchecked")
    public V get(K key){
        int hash = hash(key);
        Node<K, V> node = (Node<K, V>) array[(array.length - 1) & hash];
        while(node != null){
            if(node.key.equals(key)){
                return node.getValue();
            } else if (node.next == null) {
                break;
            } else {
                node = node.next;
            }
        }
        return null;
    }


    /**
     * All three methods i.e entryList(), keyList() and valueList() are
     * implemented only for retrieving data from original HashMap.
     * This means a new instance of list and each entry of original HashMap is
     * created in the process and further modifications do not interfere
     * in the original HashMap instance.
     */
    public ArrayList<Entry<K,V>> entryList(){
        ArrayList<Entry<K, V>> list = new ArrayList<>();
        for (Object node : array) {
            @SuppressWarnings("unchecked")
            Node<K, V> arrayNode = (Node<K, V>) node;
            while(arrayNode != null){
                list.add(new Entry<>(arrayNode.getKey(), arrayNode.getValue()));
                arrayNode = arrayNode.next;
            }
        }
        return list;
    }

    public ArrayList<K> keyList(){
        ArrayList<K> list = new ArrayList<>();
        for(Object node : array){
            @SuppressWarnings("unchecked")
            Node<K, V> arrayNode = (Node<K, V>) node;
            while(arrayNode != null){
                list.add(arrayNode.getKey());
                arrayNode = arrayNode.next;
            }
        }
        return list;
    }

    public ArrayList<V> valueList(){
        ArrayList<V> list = new ArrayList<>();
        for(Object node : array){
            @SuppressWarnings("unchecked")
            Node<K, V> arrayNode = (Node<K, V>) node;
            while(arrayNode != null){
                list.add(arrayNode.getValue());
                arrayNode = arrayNode.next;
            }
        }
        return list;
    }


    public V remove(K key){
        int computedIndex = (array.length-1) & hash(key);
        @SuppressWarnings("unchecked")
        Node<K, V> foundNode = (Node<K, V>) (array[computedIndex]);
        Node<K, V> prevNode = null;
        while(foundNode != null){
            if(foundNode.getKey().equals(key)){
                if(foundNode.next != null){
                    prevNode.next = foundNode.next;
                    V oldValue = foundNode.getValue();
                    foundNode = null; //To make GC work easier.
                    size--;
                    return oldValue;
                } else {
                    if(prevNode != null){
                        prevNode.next = null;
                    } else {
                        array[computedIndex] = null;
                    }
                    V oldValue = foundNode.getValue();
                    foundNode = null; //To make GC work easier.
                    size--;
                    return oldValue;
                }
            }
            prevNode = foundNode;
            foundNode = foundNode.next;
        }
        throw new NoSuchElementException("There is no element of key: " + key);
    }

    public V replace(K key, V value){
        int computedIndex = (array.length-1) & hash(key);
        @SuppressWarnings("unchecked")
        Node<K, V> foundNode = (Node<K, V>) (array[computedIndex]);
        while(foundNode != null){
            if(foundNode.getKey().equals(key)){
                V oldValue = foundNode.getValue();
                foundNode.setValue(value);
                return oldValue;
            }
            foundNode = foundNode.next;
        }
        throw new NoSuchElementException("There is no element of key: " + key);
    }

    public boolean containsKey(K key){
        int computedIndex = (array.length-1) & hash(key);
        @SuppressWarnings("unchecked")
        Node<K, V> foundNode = (Node<K, V>) (array[computedIndex]);
        while(foundNode != null){
            if(foundNode.getKey().equals(key)){
                return true;
            }
            foundNode = foundNode.next;
        }
        return false;
    }

    public void clear(){
        if(array != null){
            for(int i = 0; i < array.length; i++){
                array[i] = null;
            }
        }
        size = 0;
    }

    public void putAll(Map<? extends K, ? extends V> map){
        map.entrySet().forEach(e -> put(e.getKey(), e.getValue()));
    }

    public V put(K key, V value){
        return checkThresholdAndProceed(hash(key), key, value);
    }

    private V checkThresholdAndProceed(int hash, K key, V value){
        if(size == threshold){
            resize();
            return putElement(hash, key, value);
        }else{
            return putElement(hash, key, value);
        }
    }

    private V putElement(int hash, K key, V value) {
        int computedIndex = (array.length-1) & hash;
        if(array[computedIndex] == null){
            array[computedIndex] = new Node<>(hash, key, value, null);
            size++;
            return null;
        }else{
            @SuppressWarnings("unchecked")
            Node<K, V> insideNode = (Node<K, V>) array[computedIndex];
            while(insideNode != null){
                if(doesMappingOfKeyExist(insideNode, key)) {
                    V oldValue = insideNode.getValue();
                    insideNode.setValue(value);
                    return oldValue;
                } else if(insideNode.next == null) {
                    insideNode.next = new Node<>(hash, key, value, null);
                    break;
                } else{
                    insideNode = insideNode.next;
                }
            }
            size++;
            return null;
        }
    }

    private boolean doesMappingOfKeyExist(Node<K,V> existingNode, K pendingKey){
        return existingNode.key.equals(pendingKey);
    }

    private void resize() {
        if(threshold >= MAXIMUM_CAPACITY/2){
            throw new UnsupportedOperationException("The map cannot store more elements. " +
                    "Resize is not possible MAX_CAPACITY reached (bounded by INT positive value: 2^31-1).");
        }
        Object[] oldArray = array;
        int oldSize = size;
        array = newArrayInitialize();
        size = 0;
        for(int i = 0; i <= oldSize; i++){
            if(oldArray[i] != null){
                @SuppressWarnings("unchecked")
                Node<K, V> node = (Node<K, V>) oldArray[i];
                while(node != null){
                    put(node.key, node.value);
                    if(node.next == null){
                        break;
                    }
                    node = node.next;
                }
            }
        }
        threshold = (int)(loadFactor*array.length);
    }

    private Object[] newArrayInitialize() {
       if(MAXIMUM_CAPACITY/2 <= array.length){
           return new Object[MAXIMUM_CAPACITY];
       } else{
           return new Object[array.length * 2];
       }
    }

    /**
     * Method using a native hashCode on an object
     * and returning a more specified hash (see below explanation).
     * @return hash is like in java.util.HashMap implementation
     * a result of using a logical shift (>>>) operation what
     * means that higher bits are masked with zeros and the
     * sign bit is not propagated during the shift.
     * Therefore returned value is 5-digit long integer value from
     * 0 - 65535 (as sign bit is not propagated and & (logical and) is used).
     */
    private static final int hash(Object key){
        int hash;
        if(key == null){
            hash = 0;
            return hash;
        } else {
            hash = key.hashCode();
            hash = hash & (hash >>> 16);
            return hash;
        }
    }

    /**
     * This is a simple inner class representation of nodes
     * that are kept inside HashMap table buckets after initialization.
     * The class is inner since and private since we use it only
     * within the parent HashMap class. It is also static as there is no
     * need of accessing parent class members whatsoever.
     *
     * @param <K> is the type of keys used within the node;
     * @param <V> it the type of values used within the node;
     */
    private static class Node<K,V> {

        /**
         * Note that 'hash' and 'key' are declared as final.
         * This is a must since both of those fields are used to
         * identify an appropriate Node instance once it is created thus
         * they cannot be modified. It is also a matter of optimization since
         * there is no need to create new Node object when the new value is supposed
         * to be set under the same key.
         */
        final int hash;
        final K key;

        V value;
        Node<K,V> next;

        Node(int hash, K key, V value, Node<K, V> next) {
            this.hash = hash;
            this.key = key;
            this.value = value;
            this.next = next;
        }

        final K getKey() {
            return key;
        }

        final V getValue() {
            return value;
        }

        final V setValue(V newValue) {
            V oldValue = getValue();
            value = newValue;
            return oldValue;
        }
    }

    /**
     * This is simple representation of single HashMap data entry,
     * used specifically for HashMap entryList method as internal
     * list objects.
     *
     * Note that the class is static as it does not need and should not
     * hold reference to HashMap instance and have any access to its members.
     * Both Key and Value fields are not final because the implementation of entryList()
     * does build new instance of list and each entry from HashMap original entries.
     * This means that any further modifications do not operate on HashMap instance.
     *
     * Different approach would be to make operations managed on list of entries
     * in such a way so they are meant to use internal data held in HashMap.
     * In that case key field of Entry should be final not to interfere
     * in the inner overall hash based procedures of HashMap in any way.
     * (This is how entrySet is implemented in java.util.HashMap, where the forEach method
     * perform operations on HashMap original data).
     *
     * @param <K> type of keys held in HashMap;
     * @param <V> type of values held in HashMap;
     */

    public static class Entry<K,V>{
        private K key;
        private V value;

        private Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        public void setKey(K key) { this.key = key;}

        public void setValue(V value) {
            this.value = value;
        }
    }
}
