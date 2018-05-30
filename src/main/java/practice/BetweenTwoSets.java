package practice;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class BetweenTwoSets {

    /*
     * Complete the getTotalX function below.
     */
    static int getTotalX(int[] a, int[] b) {
        int res = 0;

        int min = Arrays.stream(b).min().orElse(Integer.MIN_VALUE);
        int max = Arrays.stream(a).max().orElse(Integer.MAX_VALUE);

        for (int i = max; i <= min; i = i + max) {

            boolean factorsOfA = true;
            for (int a_ : a) {
                if (i % a_ != 0) {
                    factorsOfA = false;
                    break;
                }
            }

            if (factorsOfA) {
                boolean bFactor = true;
                for (int b_ : b) {
                    if (b_ % i != 0) {
                        bFactor = false;
                        break;
                    }
                }

                if (bFactor) {
                    res++;
                }
            }
        }

        return res;
    }

    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        String[] nm = scan.nextLine().split(" ");

        int n = Integer.parseInt(nm[0].trim());

        int m = Integer.parseInt(nm[1].trim());

        int[] a = new int[n];

        String[] aItems = scan.nextLine().split(" ");

        for (int aItr = 0; aItr < n; aItr++) {
            int aItem = Integer.parseInt(aItems[aItr].trim());
            a[aItr] = aItem;
        }

        int[] b = new int[m];

        String[] bItems = scan.nextLine().split(" ");

        for (int bItr = 0; bItr < m; bItr++) {
            int bItem = Integer.parseInt(bItems[bItr].trim());
            b[bItr] = bItem;
        }

        System.out.println(getTotalX(a, b));

    }
}
