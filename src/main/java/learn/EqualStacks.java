package learn;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class EqualStacks {

    /*
     * Complete the equalStacks function below.
     */
    static int equalStacks(int[] h1, int[] h2, int[] h3) {

        int max = Integer.MIN_VALUE;
        int[] result = new int[3];

        int i = h1.length - 1, j = h2.length - 1, k = h3.length - 1;
        while (i > -1 && j > -1 && k > -1
                && !(result[0] == max && result[1] == max && result[2] == max)) {

            if (result[0] != max) {
                result[0] += h1[i];
                i--;
            }
            if (result[1] != max) {
                result[1] += h2[j];
                j--;
            }

            if (result[2] != max) {
                result[2] += h3[k];
                k--;
            }

            max = Arrays.stream(result).max().orElse(Integer.MIN_VALUE);
        }

        return max;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        String[] n1N2N3 = scanner.nextLine().split(" ");

        int n1 = Integer.parseInt(n1N2N3[0].trim());

        int n2 = Integer.parseInt(n1N2N3[1].trim());

        int n3 = Integer.parseInt(n1N2N3[2].trim());

        int[] h1 = new int[n1];

        String[] h1Items = scanner.nextLine().split(" ");

        for (int h1Itr = 0; h1Itr < n1; h1Itr++) {
            int h1Item = Integer.parseInt(h1Items[h1Itr].trim());
            h1[h1Itr] = h1Item;
        }

        int[] h2 = new int[n2];

        String[] h2Items = scanner.nextLine().split(" ");

        for (int h2Itr = 0; h2Itr < n2; h2Itr++) {
            int h2Item = Integer.parseInt(h2Items[h2Itr].trim());
            h2[h2Itr] = h2Item;
        }

        int[] h3 = new int[n3];

        String[] h3Items = scanner.nextLine().split(" ");

        for (int h3Itr = 0; h3Itr < n3; h3Itr++) {
            int h3Item = Integer.parseInt(h3Items[h3Itr].trim());
            h3[h3Itr] = h3Item;
        }

        int result = equalStacks(h1, h2, h3);
        System.out.println(result);
    }
}
