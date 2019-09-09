package algorithm.dynamicProgramming;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class TheMaximumSubarray {
    // Complete the maxSubarray function below.
    static int[] maxSubarray(int[] arr) {

        int[] arrCopy_1 = Arrays.copyOfRange(arr, 0, arr.length);
        int[] arrCopy_2 = Arrays.copyOfRange(arr, 0, arr.length);

        List<Integer> temp = new ArrayList<>();

        IntStream.range(0, arr.length).forEach(i -> {
            temp.add(arr[i]);
            temp.add(Arrays.stream(arrCopy_1).sum());
            temp.add(Arrays.stream(arrCopy_2).sum());
            arrCopy_1[i] = 0;
            arrCopy_2[arr.length - 1 - i] = 0;
        });

        int max = temp.stream().max(Integer::compareTo).get();
        System.out.println(max);

        // int res = Arrays.stream(arr).filter(i -> i >= 0).;
        return null;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] arr = new int[n];

            String[] arrItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int arrItem = Integer.parseInt(arrItems[i]);
                arr[i] = arrItem;
            }

            int[] result = maxSubarray(arr);

            for (int i = 0; i < result.length; i++) {
                System.out.print((String.valueOf(result[i])));

                if (i != result.length - 1) {
                    System.out.print(" ");
                }
            }

        }


        scanner.close();
    }
}
