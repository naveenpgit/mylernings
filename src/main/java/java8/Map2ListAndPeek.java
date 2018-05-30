package java8;

import java.util.*;
import java.util.stream.Collectors;

public class Map2ListAndPeek {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        map.put(10, "apple");
        map.put(20, "orange");
        map.put(30, "banana");
        map.put(40, "watermelon");
        map.put(50, "dragonfruit");

        List<Integer> key = new ArrayList<>();

        Comparator<Map.Entry<Integer, String>> entryComparator = Map.Entry.comparingByKey();
        List<String> values = map.entrySet().stream().sorted(entryComparator.reversed())
                .peek(x -> key.add(x.getKey()))
                .map(x -> x.getValue())
                .filter(x -> !x.equalsIgnoreCase("banana"))
                .collect(Collectors.toList());

        System.out.println(key);
        System.out.println(values);
    }
}
