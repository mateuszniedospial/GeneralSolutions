package X_Exercises.Streams;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by Mateusz Niedośpiał on 09.06.2017.
 *
 * All methods are created for educational purposes only,
 * so some of them can make no sense in general.
 */
class Streams {

    //All methods are static
    private Streams(){}

    static <T> List<Integer> onGenerics(List<T> pList){
        if(pList.size() < 5){
            return pList.stream()
                        .distinct()
                        .filter(obj -> Objects.equals(obj.getClass().getName(), "String"))
                        .map(obj -> (String) obj)
                        .peek(System.out::println)
                        .map(String::length)
                        .collect(Collectors.toList());
        } else if (pList.size() >= 5 && pList.size() <= 10) {
            Set<Integer> resultSet = pList.stream()
                    .limit(3)
                    .sorted()
                    .map(obj -> {
                        if (obj.getClass().getName().equals("Integer")) {
                            Integer intObj = (Integer) obj;
                            return intObj + 25;
                        } else {
                            return obj.hashCode() + 25;
                        }
                    })
                    .collect(Collectors.toSet());

            return resultSet.stream().collect(Collectors.toList());
        } else if(pList.size() <= 0) {
            return new ArrayList<>();
        } else {
            Map<Boolean, List<Integer>> map = pList.stream()
                                                .limit(15)
                                                .map(Object::hashCode)
                                                .sorted()
                                                .distinct()
                                                .collect(Collectors.partitioningBy(a -> a < 250000));

            return map.entrySet().stream()
                            .flatMap(obj -> obj.getValue().stream())
                            .peek(System.out::println)
                            .collect(Collectors.toList());
        }
    }

    static List<String> onStrings(List<String> pList){
        if(pList.size() < 5){

            TreeMap<Integer, List<String>> treeMap = pList.stream()
                    .filter(a -> !a.startsWith("a"))
                    .limit(4)
                    .map(String::toUpperCase)
                    .map(string -> string + string.length())
                    .collect(Collectors.groupingBy(String::length, TreeMap::new, Collectors.toList()));

            return treeMap.entrySet().stream()
                    .flatMap(obj -> obj.getValue().stream())
                    .collect(Collectors.toList());
        } else {

            Map<Integer, String> map = pList.stream()
                    .map(a -> {
                        if (a.startsWith("x")) {
                            return a.concat("_X");
                        } else {
                            return a.concat(a.substring(2, 4));
                        }
                    })
                    .filter(a -> a.endsWith("_X") || !a.equals(a.substring(2, 4)))
                    .peek(System.out::println)
                    .distinct()
                    .collect(Collectors.toMap(String::hashCode, a -> a.concat(a.toUpperCase())));

//                    .collect(Collectors
//                            .groupingBy(String::length,
//                                    Collectors.mapping(a -> a.endsWith("_X"), Collectors.minBy(Comparator.reverseOrder()))
//                            )
//                    );

            return map.entrySet().stream()
                    .distinct()
                    .peek(a -> System.out.println(a.getKey()))
                    .map(a -> a.getKey().toString())
                    .collect(Collectors.toList());
        }
    }
}
