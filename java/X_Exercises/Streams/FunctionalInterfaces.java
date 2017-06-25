package X_Exercises.Streams;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.function.*;

/**
 * Created by Mateusz Niedośpiał on 09.06.2017.
 *
 * All example methods are written for educational purposes only.
 * That is why some of them can make no sense in general.
 */
class FunctionalInterfaces {

    //Prevent from instantiating as all of the class methods are static;
    private FunctionalInterfaces(){}

    static LocalDate supplier(){
        Supplier<LocalDate> supplier = LocalDate::now;
        System.out.println(supplier.get());
        return supplier.get();
    }

    static void consumer() {
        Consumer<String> consumer = System.out::println;
        consumer.accept("String to sout.");
    }


    static void biConsumer(){
        HashMap<Integer, String> map = new HashMap<>();
        BiConsumer<Integer, String> biConsumer = map::put;
        biConsumer.accept(4, "four");
        System.out.println(map.get(4));
    }

    static void predicate(){
        Predicate<String> predicate = a -> a.contains("a");
        boolean first = predicate.test("amazon");
        boolean second = predicate.test("mongoDB");
        System.out.println(first);
        System.out.println(second);
    }

    static void biPredicate(){
        BiPredicate<Integer, Integer> biPredicate = (a,b) -> a.equals(b);
        boolean first = biPredicate.test(4, 4);
        boolean second = biPredicate.test(5, 4);
        System.out.println(first);
        System.out.println(second);
    }

    static void function(){
        HashMap<Integer, String> map = new HashMap<>();
        map.put(5, "five");
        Function<Integer, String> function = input -> map.get(input);
        System.out.println(function.apply(5));
    }

    static void biFunction(){
        BiFunction<String, String, String> biFunction = (a, b) -> a.concat(b);
        System.out.println(biFunction.apply("Logi", "tech"));
    }

    static void unaryOperator(){
        UnaryOperator<String> unaryOperator = a -> a.toLowerCase();
        System.out.println(unaryOperator.apply("Mr. Smith"));
    }

    static void binaryOperator(){
        BinaryOperator<String> binaryOperator = (a, b) -> a.toLowerCase().concat(b);
        System.out.println(binaryOperator.apply("MinE", "rals"));
    }
}
