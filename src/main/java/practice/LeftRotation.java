package practice;

import java.util.Scanner;

public class LeftRotation {
    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {

        int[] a = {1, 2, 3, 4, 5};
        int d = 3, n = a.length;

        for (int i = d; i - n != d; i++) {
            if (i < n)
                System.out.print(a[i] + " ");
            else
                System.out.print(a[i - n] + " ");
        }
    }
}
