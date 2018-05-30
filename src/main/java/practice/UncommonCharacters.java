package practice;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class UncommonCharacters {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int numberOfInputs = scanner.nextInt();

        String[][] input = new String[numberOfInputs][];

        String s1, s2;
        for (int i = 0; i < numberOfInputs; i++) {
            s1 = scanner.next();
            s2 = scanner.next();
            uncommon(s1, s2);
        }
        //uncommon("characters", "alphabets");
    }

    private static void uncommon(String s1, String s2) {


        Set<Character> collect1 = s1.chars().mapToObj(o -> (char) o).collect(Collectors.toCollection(LinkedHashSet::new));
        Set<Character> collect2 = s2.chars().mapToObj(o -> (char) o).collect(Collectors.toCollection(LinkedHashSet::new));
        Set<Character> collect2_ = s2.chars().mapToObj(o -> (char) o).collect(Collectors.toCollection(LinkedHashSet::new));
        collect2.removeAll(collect1);
        collect1.removeAll(collect2_);
        collect1.addAll(collect2);

        collect1.stream().sorted().forEach(x -> System.out.print(x));
        System.out.println();
    }


}
