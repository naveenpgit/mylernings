package learn;

import java.util.Arrays;

public class ArraysBinarySearch {
    public static void main(String[] args) {
        int[] arr = {10, 20, 40, 50, 100};
//        int[] arr = {100, 50, 40, 20, 10};
//        Arrays.sort(arr);
        int[] alice = new int[]{5, 25, 50, 120};
        Arrays.stream(alice).forEach(x -> System.out.println(Arrays.binarySearch(arr, x)));
    }
}
