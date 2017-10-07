package X_Exercises.Functions;

import C_DataStructures.BinarySearchTree;

import java.util.*;

/**
 * Created by Mateusz Niedośpiał on 01.10.2017.
 */
public class Simple {

    static void print(int input){
        if(input <= 100){
            System.out.println(input);
            print(input+1);
        }
    }

    static long factorial(int forNumber){
        if(forNumber == 0) return 0;
        if(forNumber == 1) return 1;
        else{
            return forNumber*factorial(forNumber-1);
        }
    }

    static long factorialIterative(int forNumber){
        if(forNumber == 0) return 0;
        else{
            long result = 1;
            for(int i = 1; i<=forNumber; i++){
                result *= i;
            }
            return result;
        }
    }

    static boolean isPrime(int number){
        for(int i = 2; i<number; i++){
            if(number % i == 0){
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        BinarySearchTree<Integer, String> bst = new BinarySearchTree<>();
        bst.insert(2, "dwa");
        bst.insert(5, "piec");
        bst.insert(3, "trzy");
        bst.insert(7, "siedem");
        bst.insert(1, "jeden");
        bst.insert(4, "cztery");
        bst.insert(10, "dziesiec");
        bst.insert(9, "dziewiec");

        System.out.println(bst.height());

        print(0);
        System.out.println("");
        bst.traversalOrderWithoutRecursion();
        System.out.println("");
        bst.traversalInOrder();
        System.out.println("");
        bst.printAllLeafs();

        List<Integer> list = new ArrayList<>();
        list.add(5);
        list.add(2);
        list.add(10);
        list.add(7);
        list.add(8);

        list.forEach(e -> System.out.println(isPrime(e)));

        System.out.println(" TERAZZ ");
        bst.printLeafs();

        C_DataStructures.Lists.LinkedList<String> ll = new C_DataStructures.Lists.LinkedList<>();

        ll.add("D");
        ll.add("C");
        ll.add("B");
        ll.add("A");
        System.out.println("");

        System.out.println(ll.middle());

        TreeSet<String> tset = new TreeSet<>();
        tset.add("A");
        tset.add("G");
        tset.add("F");
        tset.add("B");
        tset.add("C");
        tset.add("D");
        tset.add("E");
        tset.add("L");
        tset.add("H");

        System.out.println(tset.first());
        System.out.println(tset.last());
        System.out.println(tset.ceiling("B"));
        System.out.println(tset.floor("D"));

//        Iterator<String> descIterator = tset.descendingIterator();
//        System.out.println("DESC ITERATOR");
//        while(descIterator.hasNext()){
//            System.out.println(descIterator.next());
//        }
        System.out.println("FOR LOOP");
        for(Iterator<String> descIterator = tset.descendingIterator(); descIterator.hasNext(); ){
            System.out.println(descIterator.next());
        }

        NavigableSet<String> strings = tset.descendingSet();
        SortedSet<String> c = tset.tailSet("C");
        SortedSet<String> f = tset.headSet("F");

        Set<String> lhs = new LinkedHashSet<>();
        lhs.add("B");
        lhs.add("C");
        lhs.add("A");
        lhs.add("D");
        lhs.add("F");
        lhs.add("G");
        lhs.add("E");

        System.out.println("");
        for (String lh : lhs) {
            System.out.println(lh);
        }
    }

}
