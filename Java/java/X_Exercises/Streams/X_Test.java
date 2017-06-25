package X_Exercises.Streams;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mateusz Niedośpiał on 10.06.2017.
 */
public class X_Test {

    public static void main(String[] args) {
        LocalDate date = FunctionalInterfaces.supplier();
        System.out.println(date);

        FunctionalInterfaces.consumer();
        FunctionalInterfaces.biConsumer();

        FunctionalInterfaces.predicate();
        FunctionalInterfaces.biPredicate();

        FunctionalInterfaces.function();
        FunctionalInterfaces.biFunction();

        FunctionalInterfaces.unaryOperator();
        FunctionalInterfaces.binaryOperator();


        List<Integer> intList = new ArrayList<>();
        intList.add(4);
        intList.add(3);
        intList.add(10);
        intList.add(12);
        intList.add(115);
        intList.add(15);
        intList.add(6);
        intList.add(9);
        intList.add(20);
        intList.add(20);
        intList.add(20);
        intList.add(20);

        Streams.onGenerics(intList);

        List<String> stringList = new ArrayList<>();
        stringList.add("adam");
        stringList.add("alex");
        stringList.add("anne");
        stringList.add("amanda");
        stringList.add("michael");
        stringList.add("michelle");
        stringList.add("vladimir");
        stringList.add("henry");
        stringList.add("philip");
        stringList.add("jake");
        stringList.add("jason");
        stringList.add("frank");
        stringList.add("nicole");
        stringList.add("george");
        stringList.add("anne");
        stringList.add("adam");
        stringList.add("juliet");
        stringList.add("xiao");
        stringList.add("xen-ong");

        Streams.onStrings(stringList);
        Streams.onGenerics(stringList);
    }
}
