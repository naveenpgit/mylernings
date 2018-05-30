//https://www.hackerrank.com/challenges/bon-appetit/problem
package practice;

import java.util.Arrays;
import java.util.Scanner;

public class BonAppétit {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int k = scanner.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        int b_charged = scanner.nextInt();

        int sum = Arrays.stream(arr).reduce((x, y) -> x + y).orElse(0);
        int b_actual = (sum - arr[k]) / 2;

        int abs = Math.abs(b_actual - b_charged);
        System.out.println(abs == 0 ? "Bon Appetit" : String.valueOf(abs));
    }
}
