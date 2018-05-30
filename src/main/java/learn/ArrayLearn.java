package learn;

import java.util.stream.Stream;

public class ArrayLearn {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6};

        updateArray(array);

        Stream.of(array).forEach(System.out::println);
    }

    //int[]
    static void updateArray(int[] a) {
        for (int i = 0; i < a.length; i++) {
            a[i] *= 2;
        }
    }
}
