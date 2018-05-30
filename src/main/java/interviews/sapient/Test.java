package interviews.sapient;

import java.util.Scanner;

public class Test {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int V = in.nextInt();
        int n = in.nextInt();
        int[] arr = new int[n];
        for (int arr_i = 0; arr_i < n; arr_i++) {
            arr[arr_i] = in.nextInt();
        }
        int result = introTutorial(V, arr);
        System.out.println(result);
        in.close();
    }

    static int introTutorial(int V, int[] arr) {
        int res = -1;
        int i = 0;
        int j = arr.length - 1;
        int mid = j / 2;
        while (i <= mid && j >= mid) {
            if (arr[i] == V) {
                res = i;
                break;
            } else if (arr[j] == V) {
                res = j;
                break;
            } else {
                i++;
                j--;
            }
        }

        return res;
    }
}
