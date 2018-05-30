package java8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Reduce {
    public static void main(String[] args) {

        String[] array = new String[]{"A", "B", "C"};
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);

        list.forEach(System.out::println);

        list.stream().reduce((a, b) -> a + b).ifPresent(System.out::println);
        System.out.println(list.stream().reduce(100, (a, b) -> a + b));
        System.out.println(Stream.of(array).collect(Collectors.joining("-")));
    }
}
