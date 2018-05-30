package java8;

import java.util.function.BiFunction;

public class Add2NumbersFunctional {
    static int operate(int a, int b, Calculate calculate) {
        return calculate.operate(a, b);
    }

    static BiFunction add = (a, b) -> (int) a + (int) b;

    public static void main(String[] args) {
        System.out.println("Addition ::: " + operate(4, 2, Calculate.add));
        System.out.println("Multiply ::: " + operate(4, 2, Calculate.multiply));
        System.out.println("Add BiFunction ::: " + add.apply(4, 3));
    }
}

interface Calculate {
    static Calculate add = (a, b) -> a + b;
    static Calculate multiply = (a, b) -> a * b;
    static Calculate sub = (a, b) -> a - b;

    int operate(int a, int b);
}
