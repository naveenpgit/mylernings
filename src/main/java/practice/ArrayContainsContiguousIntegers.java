package practice;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ArrayContainsContiguousIntegers {
    public static void main(String[] args) {
        List<Integer> collect = Stream.of(args).map(x -> Integer.parseInt(x)).collect(Collectors.toList());

        System.out.println("Min is ===> " + collect.stream().min(Integer::compare).get());
    }
}
