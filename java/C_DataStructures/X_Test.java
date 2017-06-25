package C_DataStructures;

import C_DataStructures.Enums.HeapType;
import C_DataStructures.Enums.LinkedListEnds;
import C_DataStructures.Maps.RedBlackMap;
import C_DataStructures.Sets.*;
import C_DataStructures.Sets.HashSet;

import java.util.*;
import java.util.ArrayList;
import java.util.HashMap;


/**
 * Created by Mateusz Niedośpiał on 29.04.2017.
 */
public class X_Test {
    public static void main(String[] args) {
        int[] heapArray = {4, 1, 3, 2, 16, 9, 10, 14, 8, 7};

        Heap maxHeap = new Heap(heapArray, HeapType.MAX);
        Heap minHeap = new Heap(heapArray, HeapType.MIN);


        System.out.println("Max heap:");
        for (int aMaxHeap : maxHeap.get()) {
            System.out.println(aMaxHeap);
        }

        System.out.println("Min heap:");
        for (int aMinHeap : minHeap.get()) {
            System.out.println(aMinHeap);
        }

        int[] sortedMax = maxHeap.heapsort();
        int[] sortedMin = minHeap.heapsort();

        System.out.println("Array after heapsort on a heap:");
        for (int element : sortedMax) {
            System.out.println(element);
        }

        System.out.println("Array after heapsort on a heap:");
        for (int element : sortedMin) {
            System.out.println(element);
        }

        maxHeap.insert(19);
        maxHeap.insert(30);
        System.out.println("After insertion:");
        System.out.println("Max heap:");
        for (int aMaxHeap : maxHeap.get()) {
            System.out.println(aMaxHeap);
        }

        maxHeap.changeKeyDependingOnHeapType(3, 20);

        System.out.println("Stack:");

        Stack<String> stack = new Stack<>();
        stack.push("]");
        stack.push("}");
        stack.push("1,2,3");
        stack.push("{");
        stack.push("[");

        int topIndex = stack.getTopIndex();
        for (int i = 0; i < topIndex; i++) {
            System.out.print(stack.pop());
        }
        System.out.println("");
        System.out.println("Queue:");

        Queue<String> queue = new Queue<>();
        queue.enqueue("[");
        queue.enqueue("{");
        queue.enqueue("1,2,3");
        queue.enqueue("}");
        queue.enqueue("]");

        int tailIndex = queue.getTailIndex();
        for (int i = 0; i < tailIndex; i++) {
            System.out.print(queue.dequeue());
        }

        System.out.println("");
        System.out.println("EnqueueMany:");

        String[] tabString = {"[", "{", "1,2,3", "}", "]"};
        queue.enqueueMany(tabString);

        int tailIndex2 = queue.getTailIndex();
        for (int i = 0; i < tailIndex; i++) {
            System.out.print(queue.dequeue());
        }

        C_DataStructures.Lists.LinkedList<String> list = new C_DataStructures.Lists.LinkedList<>();
        List<String> arrayList = new ArrayList<>();
        arrayList.add("This");
        arrayList.add("is");
        arrayList.add("simple");
        arrayList.add("test");
        arrayList.add("of");
        arrayList.add("my");
        arrayList.add("own");
        arrayList.add("linked");
        arrayList.add("list");
        arrayList.add(".");

        list.addAll(arrayList);

        C_DataStructures.Lists.LinkedList<String> list2 = new C_DataStructures.Lists.LinkedList<>(arrayList);

        list.add("Adding 1", LinkedListEnds.END);
        list.add("Adding 2", LinkedListEnds.END);
        list.add("Adding 3", LinkedListEnds.END);
        list.add("Adding 4", LinkedListEnds.END);
        list.add(".", LinkedListEnds.END);

        list2.add("Adding 1", LinkedListEnds.END);
        list2.add("Adding 2", LinkedListEnds.END);
        list2.add("Adding 3", LinkedListEnds.END);
        list2.add("Adding 4", LinkedListEnds.END);
        list2.add(".", LinkedListEnds.END);

        list.clear();

        list2.remove("Adding 3");
        list2.remove(0);
        list2.remove(5);

        list2.add("This", 0);
        list2.add("own", 6);

        String head = list2.getHead();
        String tail = list2.getTail();

        boolean contains = list2.contains("Adding 2");
        int size = list2.getSize();
        String retrieve = list2.retrieve("Adding 2");
        String retrieve1 = list2.retrieve(5);

        C_DataStructures.Lists.ArrayList<String> ownArrayList = new C_DataStructures.Lists.ArrayList<>();
        ownArrayList.add("This");
        ownArrayList.add("is");
        ownArrayList.add("my");
        ownArrayList.add("own");
        ownArrayList.add("array");
        ownArrayList.add("list");
        ownArrayList.add("implementation.");

        for (int i = 0; i < ownArrayList.size(); i++) {
            System.out.println(ownArrayList.get(i));
        }

        ownArrayList.add("1");
        ownArrayList.add("2");
        ownArrayList.add("3");
        ownArrayList.add("4");
        ownArrayList.add("5");
        ownArrayList.add("6");
        ownArrayList.add("7");
        ownArrayList.add("8");

        List<String> listAdd = new ArrayList<>();
        listAdd.add("abc");
        listAdd.add("def");
        listAdd.add("ghj");
        listAdd.add("klm");
        listAdd.add("noó");
        listAdd.add("prs");

        ownArrayList.addAll(listAdd);
        C_DataStructures.Lists.ArrayList<String> constructorCheck = new C_DataStructures.Lists.ArrayList<>(listAdd);

        ownArrayList.add(10, "ZZZZZ");
        ownArrayList.remove("abc");
        ownArrayList.set(5, "&&&&&");
        ownArrayList.removeRange(4, 8);
        ownArrayList.contains("ghj");
        ownArrayList.size();
        ownArrayList.isEmpty();
        ownArrayList.trimToEnd();

        ownArrayList.clear();

        C_DataStructures.Maps.HashMap<String, String> testMap = new C_DataStructures.Maps.HashMap<>(2);
        testMap.put("USA", "Washington");
        testMap.put("POLAND", "Warsaw");
        testMap.put("DENMARK", "Kopenhagen");
        testMap.put("GERMANY", "Berlin");
        testMap.put("CHINA", "Baejin");
        testMap.put("RUSSIA", "Moscow");

        String china = testMap.get("CHINA");
        System.out.println(china);

        C_DataStructures.Lists.ArrayList<C_DataStructures.Maps.HashMap.Entry<String, String>> entryList = testMap.entryList();
        entryList.get(0).setValue("BUMPO");

        boolean usa = testMap.containsKey("USA");
        testMap.remove("DENMARK");

        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("USA2", "Washington");
        hashMap.put("POLAND2", "Warsaw");
        hashMap.put("POLAND4", "Warsaw");
        hashMap.put("DENMARK", "Kopenhagen");
        hashMap.put("GERMANY2", "Berlin");
        hashMap.put("CHINA2", "Baejin");
        hashMap.put("CHINA3", "Baejin");
        hashMap.put("RUSSIA2", "Moscow");
        hashMap.put("RUSSIA3", "Moscow");

        hashMap.entrySet().forEach(e -> e.setValue("bumpoooo"));

        testMap.putAll(hashMap);

        C_DataStructures.Maps.HashMap<String, String> hass = new C_DataStructures.Maps.HashMap<>(hashMap);
        System.out.println("");

        hass.clear();
        System.out.println("");

        BinarySearchTree<Integer, String> bst = new BinarySearchTree<>();
        bst.insert(5, "To");
        bst.insert(1, "Jest");
        bst.insert(3, "B");
        bst.insert(7, "S");
        bst.insert(10, "T");
        bst.insert(5, "HEHE");

        String maximum = bst.maximum();
        String minimum = bst.minimum();

        String s = bst.get(7);
        C_DataStructures.Lists.ArrayList<BinarySearchTree.Entry<Integer, String>> entryArrayList = bst.entryList();
        bst.containsKey(3);

        bst.insert(2, "TYLE");
        bst.insert(6, "Halo");
        bst.insert(12, "juz");
        bst.insert(11, "nie");

        bst.remove(7);

        RedBlackMap<Integer, String> blackMap = new RedBlackMap<>();
        blackMap.put(1, "RED");
        blackMap.put(5, "-");
        blackMap.put(8, "BLACK");
        blackMap.put(12, "MAP");
        blackMap.put(20, "PUT");
        blackMap.put(22, "CHECK");
        blackMap.put(30, "HOW");
        blackMap.put(32, "IT");
        blackMap.put(40, "WORKS");
        blackMap.put(45, "DUMB");
        blackMap.put(3, "HALO");
        blackMap.put(13, "NIU");
        blackMap.put(14, "HALO");

        blackMap.put(4, "NEW");
        blackMap.put(6, "NEW2");
        blackMap.put(15, "NEW3");
        blackMap.put(28, "GLOB");
        blackMap.put(29, "NEWS");
        blackMap.put(48, "NEWS");
        blackMap.put(42, "NEWS");
        blackMap.put(52, "NEWS");
        blackMap.put(60, "NEWS");
        blackMap.put(70, "NEWS");
        blackMap.put(65, "NEWS");
        blackMap.put(58, "NEWS");
        blackMap.put(49, "NEWS");

        C_DataStructures.Lists.ArrayList<RedBlackMap.Entry<Integer, String>> entryBlackMap = blackMap.entryList();
        C_DataStructures.Lists.ArrayList<Integer> keyListBlackMap = blackMap.keyList();

        String s2 = blackMap.get(6);
        String s3 = blackMap.get(1);
        String s4 = blackMap.get(15);
        String s5 = blackMap.get(30);
        String s6 = blackMap.get(8);

        blackMap.clear();

        C_DataStructures.Sets.HashSet<String> set = new HashSet<>();
        set.add("Hash");
        set.add("Set");
        set.add("Initialization");
        set.add("Is");
        set.add("Made");
        set.add("Elements");
        set.add("Added");
        set.add("Process");
        set.add("Complete");

        set.remove("Added");
        set.remove("Elements");

        boolean hash = set.contains("Hash");
        boolean elements = set.contains("Elements");

        C_DataStructures.Lists.ArrayList<String> setEntryList = set.entryList();
        HashSet<String> clonedSet = set.clone();

        boolean empty = set.isEmpty();
        set.addAll(clonedSet);

        set.addAll(testMap);

        HashSet<String> newSet = new HashSet<>(testMap);
        newSet.contains("POLAND");

        newSet.clear();
        boolean poland = newSet.contains("POLAND");

        RedBlackSet<String> redBlackSet = new RedBlackSet<>();
        redBlackSet.add("Hash");
        redBlackSet.add("Set");
        redBlackSet.add("Initialization");
        redBlackSet.add("Is");
        redBlackSet.add("Made");
        redBlackSet.add("Elements");
        redBlackSet.add("Added");
        redBlackSet.add("Process");
        redBlackSet.add("Complete");

        boolean made = redBlackSet.contains("Made");
        redBlackSet.remove("Made");
        boolean made1 = redBlackSet.contains("Made");

        int size1 = redBlackSet.size();

        C_DataStructures.Lists.ArrayList<String> entryListRBSet = redBlackSet.entryList();
        boolean empty1 = redBlackSet.isEmpty();

        RedBlackMap<String, String> blacky = new RedBlackMap<>();
        blacky.put("BLACKY", "BLA");

        redBlackSet.addAll(blacky);
        RedBlackSet<String> clone = redBlackSet.clone();
        clone.add("NOWHERETOBEFOUND");
        redBlackSet.addAll(clone);

        redBlackSet.clear();
        clone.clear();
    }
}
