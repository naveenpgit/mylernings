package practice;

import java.util.Arrays;
import java.util.Scanner;

public class SparseArrays {
    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        int N = scan.nextInt();

        String[] strings = new String[N];

        for (int stringsItr = 0; stringsItr < N; stringsItr++) {
            strings[stringsItr] = scan.next();
        }

        int Q = scan.nextInt();

        String[] queries = new String[Q];
        for (int queriesItr = 0; queriesItr < Q; queriesItr++) {
            queries[queriesItr] = scan.next();
        }

        Arrays.stream(queries).forEach(x -> {
            System.out.println(Arrays.stream(strings).filter(y -> x.equals(y)).toArray(String[]::new).length);
        });
    }
}
