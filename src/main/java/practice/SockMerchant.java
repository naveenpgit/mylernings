package practice;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SockMerchant {
    // Complete the sockMerchant function below.
    static int sockMerchant(int n, int[] ar) {
        Set<Integer> socks = new HashSet<>();
        for (int a : ar) {
            boolean res = socks.add(a);
            if (!res) {
                socks.remove(a);
            }
        }

        return (n - socks.size()) / 2;
    }


    public static void main(String[] args) {
        String input = "10 20 20 10 10 30 50 10 20";

        String[] split = input.split(" ");
        System.out.println(sockMerchant(split.length, Arrays.stream(split).mapToInt(x -> Integer.parseInt(x)).toArray()));
    }
}
