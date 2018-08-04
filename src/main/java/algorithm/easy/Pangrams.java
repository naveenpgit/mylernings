package algorithm.easy;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class Pangrams {
    static String pangrams(String s) {

        final String PANGRAM = "pangram";
        final String NOT_PANGRAM = "not pangram";

        final Set<String> set = Arrays.stream(s.toUpperCase().split("")).collect(Collectors.toSet());

        if(Arrays.stream("ABCDEFGHIJKLMNOPQRSTUVWXYZ".split("")).anyMatch(x->set.add(x))){
            return NOT_PANGRAM;
        }else{
            return PANGRAM;
        }

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        String s = scanner.nextLine();

        String result = pangrams(s);

        System.out.println(result);
        scanner.close();
    }
}
