//https://www.hackerrank.com/challenges/the-hurdle-race/problem
package algorithm.easy;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class TheHurdleRace {
    // Complete the hurdleRace function below.
    static int hurdleRace(int k, int[] height) {

        int max = Arrays.stream(height).max().getAsInt();

        return k > max ? 0 : max - k;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        int[] height = new int[n];

        for (int i = 0; i < n; i++) {
            int heightItem = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            height[i] = heightItem;
        }

        System.out.println(hurdleRace(k, height));


        scanner.close();
    }
}

