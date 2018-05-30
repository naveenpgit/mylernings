package practice;

import java.util.Scanner;

public class FindKthSmall {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            int size = scanner.nextInt();
            int[] inArray = new int[size];
            for (int j = 0; j < size; j++) {
                inArray[j] = scanner.nextInt();
            }

            int k = scanner.nextInt();

            int[] result = kthSmall(inArray, k);
            System.out.println(result[k - 1]);
        }

    }


    static int[] kthSmall(int[] array, int k) {
        int[] result = new int[k];
        result[0] = array[0];
        for (int i = 1; i < k; i++) {
            result[i] = Integer.MAX_VALUE;
        }

        for (int i = 1; i < array.length; i++) {
            adjustArray(result, array[i]);
        }

        return result;
    }

    static void adjustArray(int[] subArray, int current) {
        for (int i = 0; i < subArray.length; i++) {
            if (subArray[i] < current) {
                continue;
            } else {
                for (int j = subArray.length - 1; j > i; j--) {
                    subArray[j] = subArray[j - 1];
                }
                subArray[i] = current;
                break;
            }
        }

    }
}
