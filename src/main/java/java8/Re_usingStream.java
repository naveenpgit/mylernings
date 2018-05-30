package java8;

import org.apache.commons.lang.StringUtils;

import java.util.Arrays;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class Re_usingStream {
    public static void main(String[] args) {
        Stream<String> names = Arrays.stream(new String[]{"a", "b", "c", "d", "e"});
        names.forEach(x -> System.out.println(StringUtils.upperCase(x)));
        //names.forEach(x -> System.out.println(StringUtils.lowerCase(x)));//Would through IllegalStateException

        Supplier<Stream<String>> supplier = () -> Arrays.stream(new String[]{"a", "b", "c", "d", "e"});
        supplier.get().forEach(x -> System.out.println(StringUtils.upperCase(x)));
        supplier.get().forEach(x -> System.out.println(StringUtils.lowerCase(x)));
    }
}
