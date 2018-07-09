//https://www.hackerrank.com/challenges/2d-array/problem?h_l=playlist&slugs%5B%5D=interview&slugs%5B%5D=interview-preparation-kit&slugs%5B%5D=arrays
package datastructure.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class _2D_Array_DS {
    // Complete the hourglassSum function below.
    static int hourglassSum(int[][] arr) {
        List<Integer> res = new ArrayList<>();
        IntStream.range(0, 4).forEach(row -> {
            IntStream.range(0, 4).forEach(column -> {
                int temp = Arrays.stream(Arrays.copyOfRange(arr[row], column, column + 3)).sum()
                        + arr[row + 1][column + 1]
                        + Arrays.stream(Arrays.copyOfRange(arr[row + 2], column, column + 3)).sum();

                res.add(temp);
            });
        });

        return res.stream().max(Integer::compareTo).orElse(0);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int[][] arr = new int[6][6];

        for (int i = 0; i < 6; i++) {
            String[] arrRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 6; j++) {
                int arrItem = Integer.parseInt(arrRowItems[j]);
                arr[i][j] = arrItem;
            }
        }

        int result = hourglassSum(arr);

        System.out.println(result);

        scanner.close();
    }
}
