package code_cheif;

import java.text.NumberFormat;
import java.util.Scanner;

public class START01 {
    private static final Scanner scanner = new Scanner(System.in);


    public static void main(String[] args) throws java.lang.Exception {
        // your code goes here
        String NEXT = scanner.next();
        Number n = NumberFormat.getInstance().parse(NEXT);
        System.out.println(NEXT);
        scanner.close();
    }
}
