package java8;

import java.util.Arrays;
import java.util.List;

public class SortIntArray {
    public static void main(String[] args) {
        MathOperation add = (a, b) -> a + b;

        System.out.println(operate(3, 4, add));

        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);

    }

    static int operate(int a, int b, MathOperation operation) {
        return operation.operation(a, b);
    }

    interface MathOperation {
        int operation(int a, int b);
    }
}
