package practice;

import java.util.Scanner;

public class ReverseArray {
    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
//        int n = Integer.parseInt(scan.nextLine().trim());
//
//        int[] arr = new int[n];
//
//        String[] arrItems = scan.nextLine().split(" ");
//
//        for (int arrItr = 0; arrItr < n; arrItr++) {
//            int arrItem = Integer.parseInt(arrItems[arrItr].trim());
//            arr[arrItr] = arrItem;
//        }

        int[] arr = new int[]{1, 4, 3, 2};

        for (int i = arr.length - 1; i > -1; i--) {
            System.out.print(arr[i]);
        }
    }
}
