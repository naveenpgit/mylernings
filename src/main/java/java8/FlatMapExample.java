package java8;

import org.apache.commons.lang.StringUtils;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FlatMapExample {
    public static void main(String[] args) {
        String[][] data = new String[][]{{"adam", "bob"}, {"c", "dough"}, {"emmy", "flinch", "andrew"}};

        Stream<String> s = Stream.of(data).flatMap(x -> Stream.of(x));
        System.out.println(s.filter(x -> StringUtils.startsWith(x, "a")).collect(Collectors.toList()));
    }
}
