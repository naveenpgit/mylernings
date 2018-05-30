package java8;

import java.util.stream.Collectors;

public class StringTOCharList {
    public static void main(String[] args) {

        System.out.println("Naveen".chars().mapToObj(o -> (char) o).collect(Collectors.toList()));
    }
}
