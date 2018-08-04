package algorithm.easy;

import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FibonacciModified {
    static BigInteger fibonacciModified(int t1, int t2, int n) {

        List<BigInteger> fib = new ArrayList<>();
        fib.add(BigInteger.valueOf(t1));
        fib.add(BigInteger.valueOf(t2));

        for (int i = 0; i < n - 2; i++) {
            BigInteger b = fib.get(i + 1);
            BigInteger a = fib.get(i);
            fib.add(a.add(b.multiply(b)));
        }

        return fib.get(n-1);
    }

        private static final Scanner scanner = new Scanner(System.in);

        public static void main(String[] args) throws IOException {

            String[] t1T2n = scanner.nextLine().split(" ");

        int t1 = Integer.parseInt(t1T2n[0]);

        int t2 = Integer.parseInt(t1T2n[1]);

        int n = Integer.parseInt(t1T2n[2]);

        System.out.println(fibonacciModified(t1, t2, n).toString());
        scanner.close();
    }
}
