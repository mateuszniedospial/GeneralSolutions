package C_DataStructures;
import C_DataStructures.Lists.ArrayList;

import java.util.Comparator;
import java.util.NoSuchElementException;

/**
 * Created by Mateusz Niedośpiał on 09.05.2017.
 *
 * All data structures written under C_DataStructure package are
 * for educational purposes only. That is why there is no architecture
 * behind them i.e neither interfaces are implemented nor abstract classes extended.
 * There are also no Serializable & Cloneable interfaces implemented.
 *
 * This is a simple BST data structure which is not synchronized.
 *
 * Underneath it is built similar to LinkedList and holds all elements in nodes
 * which are objects of nested class TreeNode, which actually transforms this BST
 * into a BSTMap data structure(more specific information are provided above the class).
 * Note that in this implementation Binary Search Tree builds itself using 'key' fields of
 * TreeNodes which does mean that comparisons of nodes depends on keys not on values held inside and
 * that is why Comparator<? super K> must be specified if natural ordering is not used.
 * Specifying appropriate Comparator with compare method override lays in users responsibility.
 *
 * Beside the obvious methods i.e root/size/containsKey/get/insert/remove/minimum/maximum
 * also the entryList operation is implemented. This function returns an ArrayList (C_DataStructures/ArrayList)
 * of all BST entries (Entries are objects of the second nested class of BinarySearchTree - more information
 * provided above the class). This list is ordered by keys from low to high priority (as specified by Comparator)
 * or natural ordering. Note that entryList creates a new instance of all entries which means that actual
 * data held in Binary Search Tree cannot be modified using entryList.
 *
 * The Binary Search Tree provide O(h) complexity of search/insert/remove operations
 * where h parameter is a height of Tree itself. This means that worst scenario is when
 * all elements are set in a single line changing BST into a single LinkedList data structure.
 * This scenario is however very unlikely and in general O(h) time-complexity is a norm.
 *
 * Note that there are many data structure based on BST that provide protection from
 * having balance issues. For example a Red-Black Tree data structure guarantees that elements
 * will disperse more evenly over branches using additional information of TreeNode - its color.
 *
 * Note that not all of the basic BST methods are implemented.
 *
 * @param <K> type of keys held in TreeNodes of BST;
 * @param <V> type of values held in TreeNodes of BST;
 */
public class BinarySearchTree<K,V> {

    /**
     * The root of the entire BST.
     */
    private TreeNode<K,V> root;

    /**
     * Comparator for appropriate order of nodes in the tree structure.
     * Null if natural order of elements is used.
     */
    private final Comparator<? super K> comparator;

    private int size;

    public BinarySearchTree() {
        this.comparator = null;
        size = 0;
    }

    public BinarySearchTree(Comparator<? super K> comparator) {
        this.comparator = comparator;
        size = 0;
    }

    public TreeNode<K,V> root() {
        return root;
    }

    public Comparator<? super K> comparator() {
        return comparator;
    }

    public int size() {
        return size;
    }

    public boolean containsKey(K key){
        TreeNode<K,V> startNode = root;
        if(comparator != null){
            return checkIfUsingComparator(startNode, key);
        } else {
            return checkIfNaturally(startNode, key);
        }

    }

    private boolean checkIfNaturally(TreeNode<K, V> startNode, K key) {
        @SuppressWarnings("unchecked")
        Comparable<? super K> comparator = (Comparable<? super K>) key;
        while(startNode != null){
            int compareResult = comparator.compareTo(startNode.key);
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

    private boolean checkIfUsingComparator(TreeNode<K,V> startNode, K key) {
        Comparator<? super K> comparator = this.comparator;
        if(comparator != null){
            while(startNode != null){
                int compareResult = comparator.compare(key, startNode.key);
                if(compareResult < 0){
                    startNode = startNode.leftSon;
                } else if (compareResult > 0){
                    startNode = startNode.rightSon;
                } else {
                    return true;
                }
            }
        }
        return false;
    }

    public V get(K key){
        TreeNode<K,V> startNode = root;
        if(comparator != null){
            return retrieveUsingComparator(startNode, key);
        } else {
            return retrieveNaturally(startNode, key);
        }
    }

    private V retrieveNaturally(TreeNode<K, V> startNode, K key) {
        @SuppressWarnings("unchecked")
        Comparable<? super K> comparator = (Comparable<? super K>) key;
        while(startNode != null){
            int compareResult = comparator.compareTo(startNode.key);
            if(compareResult < 0){
                startNode = startNode.leftSon;
            } else if (compareResult > 0){
                startNode = startNode.rightSon;
            } else {
                return startNode.value;
            }
        }
        return null;
    }

    private V retrieveUsingComparator(TreeNode<K, V> startNode, K key) {
        Comparator<? super K> comparator = this.comparator;
        if(comparator != null){
            while(startNode != null){
                int compareResult = comparator.compare(key, startNode.key);
                if(compareResult < 0){
                    startNode = startNode.leftSon;
                } else if(compareResult > 0){
                    startNode = startNode.rightSon;
                } else {
                    return startNode.value;
                }
            }
        }
        return null;
    }

    public V minimum(){
        TreeNode<K, V> startNode = root;
        while(startNode.leftSon != null){
            startNode = startNode.leftSon;
        }
        return startNode.value;
    }

    public V maximum(){
        TreeNode<K, V> startNode = root;
        while(startNode.rightSon != null){
            startNode = startNode.rightSon;
        }
        return startNode.value;
    }

    public V remove(K key){
        TreeNode<K, V> startNode = root;
        if(comparator != null){
            return removeUsingComparator(key, startNode);
        } else {
            return removeNaturally(key, startNode);
        }
    }

    private V removeNaturally(K key, TreeNode<K, V> startNode) {
        @SuppressWarnings("unchecked")
        Comparable<? super K> comparable = (Comparable<? super K>) key;
        if(comparable != null){
            TreeNode<K, V> previous = startNode;
            int leftOrRight = 0;
            while(startNode != null){
                int compareResult = comparable.compareTo(startNode.key);
                if(compareResult < 0){
                    previous = startNode;
                    startNode = startNode.leftSon;
                    leftOrRight = -1;
                } else if(compareResult > 0){
                    previous = startNode;
                    startNode = startNode.rightSon;
                    leftOrRight = 1;
                } else {
                    break;
                }
            }
            if(startNode != null){
                return transplant(startNode, previous, leftOrRight);
            } else {
                throw new NoSuchElementException("There is no such element in the BST.");
            }
        }
        return null;
    }

    private V removeUsingComparator(K key, TreeNode<K, V> startNode) {
        Comparator<? super K> comparator = this.comparator;
        if(comparator != null){
            TreeNode<K, V> previous = startNode;
            int leftOrRight = 0;
            while(startNode != null){
                int compareResult = comparator.compare(key, startNode.key);
                if(compareResult < 0){
                    previous = startNode;
                    startNode = startNode.leftSon;
                    leftOrRight = -1;
                } else if(compareResult > 0){
                    previous = startNode;
                    startNode = startNode.rightSon;
                    leftOrRight = 1;
                } else {
                    break;
                }
            }
            if(startNode != null){
                return transplant(startNode, previous, leftOrRight);
            } else {
                throw new NoSuchElementException("There is no such element in the BST.");
            }
        }
        return null;
    }

    private V transplant(TreeNode<K, V> startNode, TreeNode<K, V> previous, int leftOrRight) {
        if ((startNode.leftSon != null) && (startNode.rightSon != null)){
            return transplantBoth(startNode, previous, leftOrRight);
        } else if(startNode.leftSon != null){
            return transplantLeftSon(startNode, previous, leftOrRight);
        } else if (startNode.rightSon != null){
            return transplantRightSon(startNode, previous, leftOrRight);
        } else {
            return transplantNone(startNode, previous, leftOrRight);
        }
    }

    private V transplantBoth(TreeNode<K, V> startNode, TreeNode<K, V> previous, int leftOrRight) {
        if(previous != null){
            if(leftOrRight == -1) {
                previous.leftSon = startNode.rightSon;
                startNode.rightSon.parent = previous;
            } else if (leftOrRight == 1){
                previous.rightSon = startNode.rightSon;
                startNode.rightSon.parent = previous;
            }
            TreeNode<K, V> tempNode = startNode.rightSon;
            TreeNode<K, V> tempPrevious = startNode.rightSon;
            while(tempNode != null){
                tempPrevious = tempNode;
                tempNode = tempNode.leftSon;
            }
            tempPrevious.leftSon = startNode.leftSon;
            startNode.leftSon.parent = tempPrevious;

            V value = startNode.value;
            startNode = null; //To make GC work easier.
            size--;
            return value;
        } else {
            root = startNode.rightSon;
            startNode.rightSon.parent = root;

            TreeNode<K, V> tempNode = startNode.rightSon;
            TreeNode<K, V> tempPrevious = startNode.rightSon;
            while(tempNode != null){
                tempPrevious = tempNode;
                tempNode = tempNode.leftSon;
            }
            tempPrevious.leftSon = startNode.leftSon;
            startNode.leftSon.parent = tempPrevious;

            V value = startNode.value;
            startNode = null; //To make GC work easier.
            size--;
            return value;
        }
    }

    private V transplantNone(TreeNode<K, V> startNode, TreeNode<K, V> previous, int leftOrRight) {
        if(previous != null){
            if(leftOrRight == -1) {
                previous.leftSon = null;
            } else if (leftOrRight == 1) {
                previous.rightSon = null;
            }
            V value = startNode.value;
            startNode = null; //To make GC work easier.
            size--;
            return value;
        } else {
            root = null;
            V value = startNode.value;
            startNode = null; //To make GC work easier.
            size--;
            return value;
        }
    }

    private V transplantRightSon(TreeNode<K, V> startNode, TreeNode<K, V> previous, int leftOrRight) {
        if(previous != null){
            if(leftOrRight == -1) {
                previous.leftSon = startNode.rightSon;
            } else if(leftOrRight == 1) {
                previous.rightSon = startNode.rightSon;
            }

            startNode.rightSon.parent = previous;
            V value = startNode.value;
            startNode = null; //To make GC work easier.
            size--;
            return value;
        } else {
            root = startNode.rightSon;
            V value = startNode.value;
            startNode = null; //To make GC work easier.
            size--;
            return value;
        }
    }

    private V transplantLeftSon(TreeNode<K, V> startNode, TreeNode<K, V> previous, int leftOrRight) {
        if(previous != null){
            if(leftOrRight == -1){
                previous.leftSon = startNode.leftSon;
            } else if(leftOrRight == 1) {
                previous.rightSon = startNode.leftSon;
            }
            startNode.leftSon.parent = previous;
            V value = startNode.value;
            startNode = null; //To make GC work easier.
            size--;
            return value;
        } else {
            root = startNode.leftSon;
            V value = startNode.value;
            startNode = null; //To make GC work easier.
            size--;
            return value;
        }
    }

    public void insert(K key, V value){
        TreeNode<K, V> startNode = root;
        if(comparator != null){
            insertUsingComparator(key, value, startNode);
        } else {
            insertNaturally(key, value, startNode);
        }
    }

    private void insertNaturally(K key, V value, TreeNode<K, V> startNode) {
        @SuppressWarnings("unchecked")
        Comparable<? super K> comparable = (Comparable<? super K>) key;
        TreeNode<K, V> previous = null;
        int leftOrRight = 0;
        while(startNode != null){
            int compareResult = comparable.compareTo(startNode.key);
            if(compareResult < 0){
                previous = startNode;
                startNode = startNode.leftSon;
                leftOrRight = -1;
            } else {
                previous = startNode;
                startNode = startNode.rightSon;
                leftOrRight = 1;
            }
        }
        TreeNode<K, V> nodeToInsert = new TreeNode<>(key, value, previous, null, null);
        if(leftOrRight == -1){
            previous.leftSon = nodeToInsert;
        } else if (leftOrRight == 1){
            previous.rightSon = nodeToInsert;
        } else {
            root = nodeToInsert;
        }
        size++;
    }


    private void insertUsingComparator(K key, V value, TreeNode<K, V> startNode) {
        Comparator<? super K> comparator = this.comparator;
        TreeNode<K, V> previous = null;
        int leftOrRight = 0;
        if(comparator != null){
            while(startNode != null){
                int compareResult = comparator.compare(key, startNode.key);
                if(compareResult < 0){
                    previous = startNode;
                    startNode = startNode.leftSon;
                    leftOrRight = -1;
                } else {
                    previous = startNode;
                    startNode = startNode.rightSon;
                    leftOrRight = 1;
                }
            }
            TreeNode<K, V> nodeToInsert = new TreeNode<>(key, value, previous, null, null);
            if(leftOrRight == -1){
                previous.leftSon = nodeToInsert;
            } else if (leftOrRight == 1){
                previous.rightSon = nodeToInsert;
            } else {
                root = nodeToInsert;
            }
            size++;
        }
    }

    public ArrayList<Entry<K,V>> entryList(){
        TreeNode<K,V> startNode = root;
        ArrayList<Entry<K,V>> entryList = new ArrayList<>();
        return retrieveEntry(startNode, entryList);
    }

    private ArrayList<Entry<K, V>> retrieveEntry(TreeNode<K, V> startNode, ArrayList<Entry<K,V>> entryList) {
        if(startNode != null){
            retrieveEntry(startNode.leftSon, entryList);
            entryList.add(new Entry<>(startNode.getKey(), startNode.getValue()));
            retrieveEntry(startNode.rightSon, entryList);
        }
        return entryList;
    }

    /**
     * Simple recursive method for retrieving value of node that contains specific nodeKey
     * using comparator. Marked as deprecated since the regular method is better optimized.
     * This is just an example how can the retrieve operation be achieved using
     * recursive approach.
     */
    @Deprecated
    private V retrieveRecursivelyUsingComparator(TreeNode<K,V> startNode, K nodeKey) {
        if(comparator!=null){
            if(startNode != null){
                int compareResult = comparator.compare(nodeKey, startNode.key);
                if(compareResult < 0){
                    retrieveRecursivelyUsingComparator(startNode.leftSon, nodeKey);
                } else if (compareResult > 0){
                    retrieveRecursivelyUsingComparator(startNode.rightSon, nodeKey);
                } else {
                    return startNode.value;
                }
            }
        }
        return null;
    }

    /**
     * Nested class which is a representation
     * of nodes created and held inside the BST.
     * Note that in this implementation every node
     * has not only 'value' but also the 'key' field
     * meaning that there is a mapping of key -> value going
     * on underneath which makes it a  BinarySearchTreeMap structure.
     *
     * @param <K> any type of the Key leading to Value for Node.
     * @param <V> any type of Value held inside the TreeNode.
     */
    static final class TreeNode<K,V>{
        K key;
        V value;
        TreeNode<K,V> parent;
        TreeNode<K,V> leftSon;
        TreeNode<K,V> rightSon;

        public TreeNode(K key, V value, TreeNode<K,V> parent, TreeNode<K,V> leftSon, TreeNode<K,V> rightSon) {
            this.key = key;
            this.value = value;
            this.parent = parent;
            this.leftSon = leftSon;
            this.rightSon = rightSon;
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
    }

    /**
     * This is simple representation of single BST data entry,
     * used specifically for BST entryList method as internal
     * list objects.
     *
     * Note that the class is static as it does not need and should not
     * hold reference to BST instance and have any access to its members.
     *
     * Both Key and Value fields are not final because the implementation of entryList()
     * does build new instance of list and each entry from Binary Search Tree original entries.
     * This means that any further modifications do not operate on BST instance.
     *
     * Different approach would be to make operations managed on list of entries
     * in such a way so they are meant to use internal data held in BST.
     * (This is how e.g entrySet is implemented in java.util.HashMap, where the forEach method
     * perform operations on HashMap original data).
     *
     * @param <K> type of keys held in BST;
     * @param <V> type of values held in BST;
     */

    public static final class Entry<K,V>{
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
