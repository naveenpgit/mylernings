package practice;

import java.util.*;
import java.util.stream.Stream;

public class GroupAnagramsTogether {


    public static final List<Character> CHARS = Arrays.asList('A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z');

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int numberOfInputs = scanner.nextInt();

        String[][] input = new String[numberOfInputs][];
        for (int i = 0;
             i < numberOfInputs; i++) {
            int numberOfWords = scanner.nextInt();
            String[] inArray = new String[numberOfWords];
            for (int j = 0; j < numberOfWords; j++) {
                inArray[j] = scanner.next();
            }

            input[i] = inArray;
        }

        Stream.of(input).forEach(x -> {
            group(x);
        });

//        group(new String[]{"act", "cat", "tac", "god", "dog"});
    }

    private static void group(String[] x) {

        Map<Double, Integer> temp = new LinkedHashMap<>();
        Stream.of(x).forEach(y -> {
            char[] t = y.toUpperCase().toCharArray();
            double score = 0;
            for (int k = 0; k < t.length; k++) {
                score += CHARS.indexOf(t[k]) * t[k];
            }
            Integer count = temp.get(score);
            if (count == null) {
                temp.put(score, 1);
            } else {
                temp.put(score, ++count);
            }
        });

        final StringBuffer buffer = new StringBuffer();
        temp.entrySet().stream().sorted(Map.Entry.comparingByValue()).map(x1 -> x1.getValue()).forEach(f -> System.out.print(f + " "));
        System.out.println();
    }
}
