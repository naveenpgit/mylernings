package java8;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Optional_ {
    public static String MOCK_LOAN_GUID = false
            ? "{5fe5fe12-f71b-4851-9a30-571223b0c362}"
            : null;

    public static void main(String[] args) {
        System.out.println(Optional.ofNullable("A").orElse(getDefaultValue()));
        System.out.println(Optional.ofNullable("A").orElseGet(() -> getDefaultValue()));
        System.out.println(Optional.ofNullable(null).orElseGet(() -> getDefaultValue()));

        String s = "naveen kumar goudar";
        s = null;
        //System.out.println(Optional.ofNullable(s.replaceAll(" " , "")).orElse("--"));

        Map<String, Object> myMap = new HashMap<>();
        IntStream.range(1, 5).forEach(i -> {
            myMap.put(String.valueOf(i), String.valueOf(i) + "_V");
        });

        String res = Optional.ofNullable(myMap.get("30")).map(Object::toString)
                .orElse("not Found");
        System.out.println("Res ::: " + res);

        System.out.println(Optional.ofNullable("").orElse("It was null!!!"));


        System.out.println(Optional.ofNullable(MOCK_LOAN_GUID).orElse("It was nulllllllll"));

        System.out.println("Damn --- " + Optional.ofNullable("Naveen").map(x -> x + " ::: Map run").orElseGet(() -> "default"));

        List<Map.Entry<String, Object>> size_1 = Optional.ofNullable(getValue(myMap)).map(Set::stream).orElse(Stream.empty()).collect(Collectors.toList());
        System.out.println("Size 1 ::: " + size_1.size());
        List size_2 = (List) Optional.ofNullable(getValue()).map(t -> ((Set) t).stream()).orElse(Stream.empty()).collect(Collectors.toList());
        System.out.println("Size 2 ::: " + size_2.size());

    }

    private static Set<Map.Entry<String, Object>> getValue(Map<String, Object> myMap) {
        return myMap.entrySet();
    }

    private static Set<Map.Entry<String, Object>> getValue() {
        return null;
    }

    static String getDefaultValue() {
        System.out.println("hey there!!!");
        return "B";
    }
}
