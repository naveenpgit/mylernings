package datastructure.arrays;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class MinimumSwaps_2 {

    // Complete the minimumSwaps function below.
    static int minimumSwaps(int[] arr) {

        int count = 0;
        boolean run_loop = true;
        int begin = 0;
        while (run_loop) {
            begin = order(arr, begin);
            if (begin != -1) {
                count++;
            }else{
                run_loop = false;
            }
        }

        return count;
    }

    static int order(int[] arr, int begin) {
        int a = IntStream.range(begin, arr.length).filter(x -> {
            return x != arr[x] - 1;
        }).findFirst().orElse(-1);

        if (a > -1) {
            int b = IntStream.range(a, arr.length).filter(i->a+1 == arr[i]).findFirst().orElse(-1);

            int temp = arr[a];
            arr[a] = arr[b];
            arr[b] = temp;

            return a + 1;
        } else {
            return -1;
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            try {
                int arrItem = Integer.parseInt(arrItems[i]);
                arr[i] = arrItem;
            }catch (Exception e){
                System.out.println("i ==== > " + i);
            }
        }

        int res = minimumSwaps(arr);

        System.out.println(res);

        scanner.close();
    }

}
