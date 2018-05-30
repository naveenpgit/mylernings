package practice;

import java.util.Scanner;

public class ArrayManipulation {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();

//This will be the "difference array". The entry arr[i]=k indicates that arr[i] is exactly k units larger than arr[i-1]
        long[] arr = new long[n];

        int a;
        int b;
        long k;

        for (int i = 0; i < n; i++) arr[i] = 0;

        for (int i = 0; i < m; i++) {
            a = scan.nextInt();
            b = scan.nextInt();
            k = scan.nextInt();
            arr[a - 1] += k;
            if (b < n) arr[b] -= k;
        }

        long max = 0;
        long temp = 0;

        for (int i = 0; i < n; i++) {
            temp += arr[i];
            if (temp > max) max = temp;
        }

        System.out.println(max);
    }
}
