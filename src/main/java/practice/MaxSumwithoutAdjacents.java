package practice;

import java.util.ArrayList;
import java.util.List;

public class MaxSumwithoutAdjacents {
    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int numberOfInputs = scanner.nextInt();
//
//        for (int i = 0; i < numberOfInputs; i++) {
//            int n = scanner.nextInt();
//            int[] inArray = new int[n];
//            for (int j = 0; j < n; j++) {
//                inArray[j] = scanner.nextInt();
//            }
//
//            maximumSumOfSubsequence(inArray);
//        }

        maximumSumOfSubsequence(new int[]{468, 335, 1, 170, 225, 479, 359, 463, 465, 206,
                146, 282, 328, 462, 492, 496, 443, 328, 437, 392,
                105, 403, 154, 293, 383, 422, 217, 219, 396, 448,
                227, 272, 39, 370, 413, 168, 300, 36, 395, 204,
                312, 323});
    }

    private static void maximumSumOfSubsequence(int[] inArray) {
        int sum = 0;
        for (int i = 0; i < inArray.length; i++) {

            for (int k = i + 2; k < inArray.length; k++) {
                List<Integer> subArr = new ArrayList<>();
                subArr.add(inArray[i]);
                int temp = inArray[i];
                int n = k;
                while (n < inArray.length) {
                    subArr.add(inArray[n]);
                    temp += inArray[n];
                    n = n + 2;
                }
                System.out.println(temp + "  ::::  " + subArr);
                if (temp > sum) {
                    sum = temp;
                }
            }
        }

        System.out.println(sum);
    }

}
