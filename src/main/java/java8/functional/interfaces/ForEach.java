package java8.functional.interfaces;

import java.util.Arrays;
import java.util.List;

public class ForEach {
    public static void main(String[] args) {
        List<Integer> ints = Arrays.asList(1, 2, 3, 4, 5);
        ints.forEach(x -> System.out.println(x));

        ints.stream().filter(x -> x != 10);
    }
}
