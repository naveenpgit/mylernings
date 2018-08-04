package algorithm.easy;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.BiConsumer;

public class MakingAnagrams {
    static int makingAnagrams(String s1, String s2) {
        Map<String, AtomicInteger> s1_ = new HashMap<>();
        Map<String, AtomicInteger> s2_ = new HashMap<>();

        BiConsumer<Map<String, AtomicInteger>, String> mapStringBiConsumer = (map, x1) -> {
            if (map.get(x1) == null)
                map.put(x1, new AtomicInteger(1));
            else
                map.get(x1).incrementAndGet();
        };
        Arrays.stream(s1.split("")).forEach(x -> {
            mapStringBiConsumer.accept(s1_, x);
        });
        Arrays.stream(s2.split("")).forEach(x -> {
            mapStringBiConsumer.accept(s2_, x);
        });

        s2_.entrySet().stream().forEach(x -> {
            if (s1_.get(x.getKey()) == null)
                s1_.put(x.getKey(), x.getValue());
            else
                s1_.put(x.getKey(), new AtomicInteger(Math.abs(x.getValue().get() - s1_.get(x.getKey()).get())));
        });

       return s1_.entrySet().stream().mapToInt(x->x.getValue().get()).sum();
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        String s1 = scanner.nextLine();

        String s2 = scanner.nextLine();

        int result = makingAnagrams(s1, s2);

        System.out.println(result);
        scanner.close();
    }
}
