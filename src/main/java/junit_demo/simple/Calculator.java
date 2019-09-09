package junit_demo.simple;

import java.util.Date;

public class Calculator {
    public int add(int i, int j) {
        if (i < 0 || j < 0)
            throw new IllegalStateException("values are negative");

        return i + j;
    }

    public static void main(String[] args) {
        Date date = new Date(1556063979433L);
        System.out.println(date);
    }
}
