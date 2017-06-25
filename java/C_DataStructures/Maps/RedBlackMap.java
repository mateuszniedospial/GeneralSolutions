package C_DataStructures.Maps;

import java.util.Comparator;
import java.util.Map;

/**
 * Created by Mateusz Niedośpiał on 12.05.2017.
 *
 * All data structures written under C_DataStructure package are
 * for educational purposes only. That is why there is no architecture
 * behind them i.e neither interfaces are implemented nor abstract classes extended.
 * There are also no Serializable & Cloneable interfaces implemented.
 *
 * This is a simple Map implementation which uses a Red-Black Tree data structure
 * internally. This implementation is not synchronized and does not permit null as a key due to
 * sorting.
 *
 * Underneath it is built similar to C_DataStructures/BinarySearchTree data structure,
 * but TreeNodes have additional field 'color' specified. As it is an implementation of
 * a Map Red-Black Tree builds itself using 'key' fields of TreeNodes which does mean that
 * comparisons of nodes depends on keys not on values held inside and that is why Comparator<? super K>
 * must be specified if natural ordering is not used. Specifying appropriate Comparator with compare
 * method override lays in users responsibility.
 * Obviously, the implementation does guarantee that elements are sorted.
 * By default sorting priority is from the least priority to the highest, and that
 * is how entryList(), keyList() methods order elements within.
 *
 * Beside the obvious methods i.e root/size/containsKey/get/put/remove/minimum etc.
 * also the entryList operation is implemented. This function returns an ArrayList (C_DataStructures/ArrayList)
 * of all RedBlackMap entries (Entries are objects of the second nested class of RedBlackMap - more information
 * provided above the class). This list is ordered by keys from low to high priority (as specified by Comparator)
 * or natural ordering. Note that entryList creates a new instance of all entries which means that actual
 * data held in RedBlackMap cannot be modified using entryList.
 *
 * The RedBlackMap guarantees O(lg n) complexity of search/insert/remove operations
 * where (lg n) is the height of the Red-Black Tree. This means that in average situation
 * the operations are made even faster.
 *
 * Note that not all of the basic TreeMap methods are implemented.
 *
 * @see HashMap
 *
 * @param <K> type of keys held in TreeNodes of RedBlackMap;
 * @param <V> type of values held in TreeNodes of RedBlackMap;
 */
public class RedBlackMap<K,V> {

    /**
     * Fields which represent a specific color of the TreeNode;
     * RED or BLACK in this case.
     */
    private static final boolean RED   = false;
    private static final boolean BLACK = true;

    /**
     * TreeNode which is used, as a dummy BLACK colored node of NULL,
     * whenever regular TreeNode does not have any of the sons
     * or a parent (root).
     *
     * Made for memory allocation optimization.
     */
    private final TreeNode<K,V> SENTINEL = new TreeNode<>(null, null, null, null, null, BLACK);

    /**
     * Root of the entire underneath Red-Black Tree structure;
     */
    private TreeNode<K, V> root;

    /**
     * Comparator used to sort TreeNodes appropriately.
     * NULL if natural ordering is used.
     */
    private final Comparator<? super K> comparator;

    /**
     * The number of TreeNodes in the Red-Black Tree;
     */
    private int size;

    public RedBlackMap() {
        comparator = null;
        size = 0;
    }

    public RedBlackMap(Comparator<? super K> comparator) {
        this.comparator = comparator;
        size = 0;
    }

    public RedBlackMap(Map<? extends K, ? extends V> map){
        this();
        putAll(map);
    }

    public RedBlackMap(RedBlackMap<K, V> redBlackMap){
        comparator = redBlackMap.comparator();
        root = redBlackMap.root;
        size = redBlackMap.size();
    }

    public int size() { return size; }

    public boolean isEmpty(){
        return size == 0;
    }

    public Comparator<? super K> comparator() {
        return comparator;
    }

    public V get(K key){
        TreeNode<K,V> foundNode;
        if(comparator == null){
            foundNode = findNodeNaturally(key);
        } else {
            foundNode = findNodeUsingComparator(key);
        }

        if(foundNode.equals(SENTINEL)){
            return null;
        } else {
            return foundNode.getValue();
        }
    }

    private TreeNode<K,V> findNodeNaturally(K key) {
        @SuppressWarnings("unchecked")
        Comparable<? super K> comparable = (Comparable<? super K>) key;
        TreeNode<K,V> startNode = root;
        while(! startNode.equals(SENTINEL)){
            int compareResult = comparable.compareTo(startNode.key);
            if(compareResult < 0){
                startNode = startNode.leftSon;
            } else if (compareResult > 0){
                startNode = startNode.rightSon;
            } else {
                return startNode;
            }
        }
        return SENTINEL;
    }


    private TreeNode<K,V> findNodeUsingComparator(K key) {
        Comparator<? super K> comparator = this.comparator;
        TreeNode<K,V> startNode = root;
        while(! startNode.equals(SENTINEL)){
            int compareResult = comparator.compare(key, startNode.getKey());
            if(compareResult < 0){
                startNode = startNode.leftSon;
            } else if(compareResult > 0){
                startNode = startNode.rightSon;
            } else {
                return startNode;
            }
        }
        return SENTINEL;
    }

    public boolean containsKey(K key){
        if(comparator == null){
           return containsKeyNaturally(key);
        } else {
           return containsKeyComparator(key);
        }
    }

    private boolean containsKeyNaturally(K key) {
        @SuppressWarnings("unchecked")
        Comparable<? super K> comparable = (Comparable<? super K>) key;
        TreeNode<K,V> startNode = root;
        while(! startNode.equals(SENTINEL)){
            int compareResult = comparable.compareTo(startNode.key);
            if(compareResult < 0){
                startNode = startNode.leftSon;
            } else if (compareResult > 0){
                startNode = startNode.rightSon;
            } else {
                return true;
            }
        }
        return false;
    }

    private boolean containsKeyComparator(K key) {
        Comparator<? super K> comparator = this.comparator;
        TreeNode<K,V> startNode = root;
        while(! startNode.equals(SENTINEL)){
            int compareResult = comparator.compare(key, startNode.getKey());
            if(compareResult < 0){
                startNode = startNode.leftSon;
            } else if(compareResult > 0){
                startNode = startNode.rightSon;
            } else {
                return true;
            }
        }
        return false;
    }

    public C_DataStructures.Lists.ArrayList<Entry<K,V>> entryList(){
        C_DataStructures.Lists.ArrayList<Entry<K, V>> entryList = new C_DataStructures.Lists.ArrayList<>();
        buildEntryListRecursively(root, entryList);
        return entryList;
    }

    public C_DataStructures.Lists.ArrayList<K> keyList(){
        C_DataStructures.Lists.ArrayList<K> keyList = new C_DataStructures.Lists.ArrayList<>();
        buildKeyListRecursively(root, keyList);
        return keyList;
    }


    private void buildEntryListRecursively(TreeNode<K,V> startNode, C_DataStructures.Lists.ArrayList<Entry<K, V>> entryList){
        if(! startNode.equals(SENTINEL)){
            buildEntryListRecursively(startNode.leftSon, entryList);
            entryList.add(new Entry<>(startNode.key, startNode.value));
            buildEntryListRecursively(startNode.rightSon, entryList);
        }
    }

    private void buildKeyListRecursively(TreeNode<K,V> startNode, C_DataStructures.Lists.ArrayList<K> keyList){
        if(! startNode.equals(SENTINEL)){
            buildKeyListRecursively(startNode.leftSon, keyList);
            keyList.add(startNode.key);
            buildKeyListRecursively(startNode.rightSon, keyList);
        }
    }

    public void clear(){
        while(size != 0){
            remove(root.getKey());
        }
    }

    public V minimum(){
        TreeNode<K,V> startNode = root;
        TreeNode<K, V> minimum = treeMinimum(startNode);
        return minimum.getValue();
    }

    private TreeNode<K,V> treeMinimum(TreeNode<K,V> startNode) {
        while(! startNode.equals(SENTINEL)){
            startNode = startNode.leftSon;
        }
        return startNode;
    }

    private void putAll(Map<? extends K, ? extends V> map) {
        map.entrySet().forEach(e -> put(e.getKey(), e.getValue()));
    }

    public V put(K key, V value){
        if(comparator == null){
            return insertNaturally(key, value);
        } else {
            return insertUsingComparator(key, value);
        }
    }

    private V insertNaturally(K key, V value) {
        @SuppressWarnings("unchecked")
        Comparable<? super K> comparable = (Comparable<? super K>) key;
        TreeNode<K,V> previous = null;
        TreeNode<K, V> startNode = root;

        if(startNode == null){
            comparable.compareTo(key);
            root = new TreeNode<>(key, value, SENTINEL, SENTINEL, SENTINEL, BLACK);
            size++;
            return null;
        }

        while (! startNode.equals(SENTINEL)) {
            int compareResult = comparable.compareTo(startNode.getKey());
            if(compareResult < 0){
                previous = startNode;
                startNode = startNode.leftSon;
            } else if(compareResult > 0){
                previous = startNode;
                startNode = startNode.rightSon;
            } else {
                return startNode.setValue(value);
            }
        }

        TreeNode<K, V> newNode = new TreeNode<>(key, value, previous, SENTINEL, SENTINEL, RED);

        if(previous != null){ //CANNOT HAPPEN WHATSOEVER
            if(comparable.compareTo(previous.key) < 0){
                previous.leftSon = newNode;
            } else {
                previous.rightSon = newNode;
            }
        }

        insertionFix(newNode);
        size++;
        return null;
    }


    private V insertUsingComparator(K key, V value) {
        Comparator<? super K> comparator = this.comparator;
        TreeNode<K,V> previous = null;
        TreeNode<K, V> startNode = root;

        if(startNode == null){
            comparator.compare(key, key);
            root = new TreeNode<>(key, value, SENTINEL, SENTINEL, SENTINEL, BLACK);
            size++;
            return null;
        }

        while (! startNode.equals(SENTINEL)) {
            int compareResult = comparator.compare(key, startNode.getKey());
            if(compareResult < 0){
                previous = startNode;
                startNode = startNode.leftSon;
            } else if(compareResult > 0){
                previous = startNode;
                startNode = startNode.rightSon;
            } else {
                return startNode.setValue(value);
            }
        }

        TreeNode<K, V> newNode = new TreeNode<>(key, value, previous, SENTINEL, SENTINEL, RED);

        if(previous != null){ //CANNOT HAPPEN WHATSOEVER
            if(comparator.compare(key, previous.key) < 0){
                previous.leftSon = newNode;
            } else {
                previous.rightSon = newNode;
            }
        }

        insertionFix(newNode);
        size++;
        return null;
    }

    private void insertionFix(TreeNode<K, V> newNode) {
        while(parentOf(newNode).color == RED && (! newNode.equals(SENTINEL))) {
            if (parentOf(newNode).equals(leftSonOf(parentOf(parentOf(newNode))))) {
                TreeNode<K, V> toCheck = rightSonOf(parentOf(parentOf(newNode)));
                if (colorOf(toCheck) == RED) {
                    color(parentOf(newNode), BLACK);
                    color(toCheck, BLACK);
                    color(parentOf(parentOf(newNode)), RED);
                    newNode = parentOf(parentOf(newNode));
                } else {
                    if (newNode.equals(rightSonOf(parentOf(newNode)))) {
                        newNode = parentOf(newNode);
                        leftRotate(newNode);
                    }
                    color(parentOf(newNode), BLACK);
                    color(parentOf(parentOf(newNode)), RED);
                    rightRotate(parentOf(parentOf(newNode)));
                }
            } else {
                TreeNode<K, V> toCheck = leftSonOf(parentOf(parentOf(newNode)));
                if (colorOf(toCheck) == RED) {
                    color(parentOf(newNode), BLACK);
                    color(toCheck, BLACK);
                    color(parentOf(parentOf(newNode)), RED);
                    newNode = parentOf(parentOf(newNode));
                } else {
                    if (newNode.equals(leftSonOf(parentOf(newNode)))) {
                        newNode = parentOf(newNode);
                        rightRotate(newNode);
                    }
                    color(parentOf(newNode), BLACK);
                    color(parentOf(parentOf(newNode)), RED);
                    leftRotate(parentOf(parentOf(newNode)));
                }
            }
        }
        root.color = BLACK;
    }

    private void leftRotate(TreeNode<K,V> startNode){
        if(! startNode.equals(SENTINEL)){
            TreeNode<K, V> rightSonOfStart = startNode.rightSon;
            startNode.rightSon = rightSonOfStart.leftSon;
            if(! rightSonOfStart.leftSon.equals(SENTINEL)){
                rightSonOfStart.leftSon.parent = startNode;
            }
            rightSonOfStart.parent = startNode.parent;
            if(startNode.parent.equals(SENTINEL)){
                root = rightSonOfStart;
            } else if ( startNode.equals(startNode.parent.leftSon)){
                startNode.parent.leftSon = rightSonOfStart;
            } else {
                startNode.parent.rightSon = rightSonOfStart;
            }

            rightSonOfStart.leftSon = startNode;
            startNode.parent = rightSonOfStart;
        }
    }

    private void rightRotate(TreeNode<K,V> startNode){
        if(! startNode.equals(SENTINEL)) {
            TreeNode<K, V> leftSonOfStart = startNode.leftSon;
            startNode.leftSon = leftSonOfStart.rightSon;
            if (!leftSonOfStart.rightSon.equals(SENTINEL)) {
                leftSonOfStart.rightSon.parent = startNode;
            }
            leftSonOfStart.parent = startNode.parent;
            if (startNode.parent.equals(SENTINEL)) {
                root = leftSonOfStart;
            } else if (startNode.equals((startNode.parent.leftSon))) {
                startNode.parent.leftSon = leftSonOfStart;
            } else {
                startNode.parent.rightSon = leftSonOfStart;
            }

            leftSonOfStart.rightSon = startNode;
            startNode.parent = leftSonOfStart;
        }
    }

    public V remove(K key){
        TreeNode<K,V> nodeToDelete;
        if(comparator == null){
            nodeToDelete = findNodeNaturally(key);
        } else {
            nodeToDelete = findNodeUsingComparator(key);
        }
        if(nodeToDelete.equals(SENTINEL)){
           return null;
        }

        V oldValue = nodeToDelete.getValue();
        deleteNode(nodeToDelete);
        size--;
        return oldValue;
    }

    private void deleteNode(TreeNode<K, V> nodeToDelete) {
        if((! nodeToDelete.leftSon.equals(SENTINEL)) && (! nodeToDelete.rightSon.equals(SENTINEL))){
            TreeNode<K, V> successor = successor(nodeToDelete);
            nodeToDelete.key = successor.key;
            nodeToDelete.value = successor.value;
            nodeToDelete = successor;
        }

        TreeNode<K,V> replaceNode;

        if(nodeToDelete.leftSon != null && (! nodeToDelete.leftSon.equals(SENTINEL))){
            replaceNode = nodeToDelete.leftSon;
        } else {
            replaceNode = nodeToDelete.rightSon;
        }

        if(! replaceNode.equals(SENTINEL)){
            replaceNode.parent = nodeToDelete.parent;
            if(nodeToDelete.parent.equals(SENTINEL)){
                root = replaceNode;
            } else if (nodeToDelete.equals(nodeToDelete.parent.leftSon)){
                nodeToDelete.parent.leftSon = replaceNode;
            } else {
                nodeToDelete.parent.rightSon = replaceNode;
            }

            nodeToDelete.leftSon = nodeToDelete.rightSon = nodeToDelete.parent = null;

            if(nodeToDelete.color == BLACK){
                afterDeletionFix(replaceNode);
            }
        } else if (nodeToDelete.parent.equals(SENTINEL)){
            root = SENTINEL;
        } else {
            if(nodeToDelete.color == BLACK){
                afterDeletionFix(nodeToDelete);
            }

            if(! nodeToDelete.parent.equals(SENTINEL)){
                if(nodeToDelete.equals(nodeToDelete.parent.leftSon)){
                    nodeToDelete.parent.leftSon = SENTINEL;
                } else if(nodeToDelete.equals(nodeToDelete.parent.rightSon)){
                    nodeToDelete.parent.rightSon = SENTINEL;
                }
                nodeToDelete.parent = SENTINEL;
            }
        }
    }

    private void afterDeletionFix(TreeNode<K, V> replaceNode) {
        while((! replaceNode.equals(root)) && colorOf(replaceNode) == BLACK){
            if(replaceNode.equals(leftSonOf(parentOf(replaceNode)))){
                TreeNode<K,V> rightSon = rightSonOf(parentOf(replaceNode));

                if(colorOf(rightSon) == RED){
                    color(rightSon, BLACK);
                    color(parentOf(replaceNode), RED);
                    leftRotate(parentOf(replaceNode));
                    rightSon = rightSonOf(parentOf(replaceNode));
                }

                if(colorOf(leftSonOf(rightSon)) == BLACK &&
                   colorOf(rightSonOf(rightSon)) == BLACK){
                    color(rightSon, RED);
                    replaceNode = parentOf(replaceNode);
                } else {
                    if(colorOf(rightSonOf(rightSon)) == BLACK){
                        color(leftSonOf(rightSon), BLACK);
                        color(rightSon, RED);
                        rightRotate(rightSon);
                        rightSon = rightSonOf(parentOf(replaceNode));
                    }
                    color(rightSon, colorOf(parentOf(replaceNode)));
                    color(parentOf(replaceNode), BLACK);
                    color(rightSonOf(rightSon), BLACK);
                    leftRotate(parentOf(replaceNode));
                    replaceNode = root;
                }
            } else {
                TreeNode<K, V> leftSon = leftSonOf(parentOf(replaceNode));

                if(colorOf(leftSon) == RED){
                    color(leftSon, BLACK);
                    color(parentOf(replaceNode), RED);
                    rightRotate(parentOf(replaceNode));
                    leftSon = leftSonOf(parentOf(replaceNode));
                }

                if(colorOf(rightSonOf(leftSon)) == BLACK &&
                   colorOf(leftSonOf(leftSon)) == BLACK){
                    color(leftSon, RED);
                    replaceNode = parentOf(replaceNode);
                } else {
                    if(colorOf(leftSonOf(leftSon)) == BLACK){
                        color(rightSonOf(leftSon), BLACK);
                        color(leftSon, RED);
                        leftRotate(leftSon);
                        leftSon = leftSonOf(parentOf(replaceNode));
                    }
                    color(leftSon, colorOf(parentOf(replaceNode)));
                    color(parentOf(replaceNode), BLACK);
                    color(leftSonOf(replaceNode), BLACK);
                    rightRotate(parentOf(replaceNode));
                    replaceNode = root;
                }
            }
        }

        color(replaceNode, BLACK);
    }

    /**
     * Method used to delete node and replace it with its child.
     * Deprecated from the moment when the operation is made inside
     * deleteNode function itself.
     */
    @Deprecated
    private void transplant(TreeNode<K,V> toDelete, TreeNode<K,V> toReplace){
        if(parentOf(toDelete).equals(SENTINEL)){
            root = toReplace;
        } else if (toDelete.equals(leftSonOf(parentOf(toDelete)))) {
            toDelete.parent.leftSon = toReplace;
        } else {
            toDelete.parent.rightSon = toReplace;
        }
        toDelete.parent = toReplace.parent;
    }

    private TreeNode<K,V> successor(TreeNode<K,V> node){
        if(node == null){
            return null;
        } else if(! node.rightSon.equals(SENTINEL)){
            TreeNode<K, V> rightSon = node.rightSon;
            while(! rightSon.leftSon.equals(SENTINEL)){
                rightSon = rightSon.leftSon;
            }
            return rightSon;
        } else {
            TreeNode<K, V> parent = node.parent;
            TreeNode<K, V> copy = node;
            while((! parent.equals(SENTINEL)) && copy.equals(parent.rightSon)){
                copy = parent;
                parent = parent.parent;
            }
            return parent;
        }
    }

    private TreeNode<K,V> parentOf(TreeNode<K,V> node){
        if(node == null || node.equals(SENTINEL)){
            return SENTINEL;
        } else {
            return node.parent;
        }
    }

    private TreeNode<K,V> leftSonOf(TreeNode<K,V> node){
        if(node == null || node.equals(SENTINEL)){
            return SENTINEL;
        } else {
            return node.leftSon;
        }
    }

    private TreeNode<K,V> rightSonOf(TreeNode<K,V> node){
        if(node == null || node.equals(SENTINEL)){
            return SENTINEL;
        } else {
            return node.rightSon;
        }
    }

    private boolean colorOf(TreeNode<K,V> node) {
        return node.equals(SENTINEL) || node.color;
    }

    private void color(TreeNode<K,V> node, boolean color){
        if(! (node.equals(SENTINEL))){
            node.color = color;
        }
    }

    /**
     * Nested class that is representation of nodes objects
     * held inside the Red-Black Tree data structure which is
     * a base of entire RedBlackMap data structure implementation.
     *
     * @param <K> type of TreeNode keys;
     * @param <V> type of TreeNode values;
     */
    static final class TreeNode<K,V>{
        K key;
        V value;
        TreeNode<K,V> parent;
        TreeNode<K,V> leftSon;
        TreeNode<K,V> rightSon;
        boolean color;

        TreeNode(K key, V value, TreeNode<K, V> parent,
                 TreeNode<K, V> leftSon, TreeNode<K, V> rightSon, boolean color) {
            this.key = key;
            this.value = value;
            this.parent = parent;
            this.leftSon = leftSon;
            this.rightSon = rightSon;
            this.color = color;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        public V setValue(V value) {
            V oldValue = this.value;
            this.value = value;
            return oldValue;
        }

        public boolean equals(Object object) {
            if (!(object instanceof RedBlackMap.TreeNode))
                return false;
            RedBlackMap.TreeNode<?,?> e = (RedBlackMap.TreeNode<?,?>) object;

            if(key == null && value == null){
                return (null == e.getKey() && value == e.getValue());
            } else if (key != null && value == null) {
                return (key.equals(e.getKey()) && value == e.getValue());
            } else if (key == null){
                return (null == e.getKey() && value.equals(e.getKey()));
            } else {
                return (key.equals(e.getKey())) && (value.equals(e.getValue()));
            }
        }

        public int hashCode() {
            int keyHash = (key == null ? 0 : key.hashCode());
            int valueHash = (value == null ? 0 : value.hashCode());
            return keyHash ^ valueHash;
        }
    }


    /**
     * This is simple representation of single RedBlackMap data entry,
     * used specifically for RedBlackMap entryList method as internal
     * list objects.
     *
     * Note that the class is static as it does not need and should not
     * hold reference to RedBlackMap instance or have any access to its members.
     *
     * Both Key and Value fields are not final because the implementation of entryList()
     * does build new instance of list and each entry from RedBlackMap original entries.
     * This means that any further modifications do not operate on RedBlackMap instance.
     *
     * Different approach would be to make operations managed on list of entries
     * in such a way so they are meant to use internal data held in RedBlackMap.
     * (This is how e.g entrySet is implemented in java.util.HashMap, where the forEach method
     * perform operations on HashMap original data).
     *
     * @param <K> type of keys held in RedBlackMap;
     * @param <V> type of values held in RedBlackMap;
     */
    public static final class Entry<K,V>{
        private K key;
        private V value;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        public void setKey(K key) {
            this.key = key;
        }

        public V setValue(V value) {
            V oldValue = this.value;
            this.value = value;
            return oldValue;
        }
    }
}
