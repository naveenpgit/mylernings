package algorithm.easy;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class LonelyInteger {
    // Complete the lonelyinteger function below.
    static int lonelyinteger(int[] a) {

        return Arrays.stream(a).reduce((x,y) -> x^y).getAsInt();
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] a = new int[n];

        String[] aItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int aItem = Integer.parseInt(aItems[i]);
            a[i] = aItem;
        }

        int result = lonelyinteger(a);

        System.out.println(result);
        scanner.close();
    }
}
