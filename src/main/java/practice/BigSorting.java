package practice;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class BigSorting {

//    public static void main(String[] args) {
//
//
//        String[] res = bigSorting(new String[]{
//                "31415926535897932384626433832795",
//                "1",
//                "3",
//                "10",
//                "3",
//                "5" });
//
//        for (String s : res) {
//            System.out.println(s);
//        }
//    }


    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        int N = scanner.nextInt();

        String[] unsorted = new String[N];

        for (int stringsItr = 0; stringsItr < N; stringsItr++) {
            unsorted[stringsItr] = scanner.next();
        }

        String[] result = bigSorting(unsorted);

        for (String s : result) {
            System.out.println(s);
        }

        scanner.close();
    }

    /*
     * Complete the bigSorting function below.
     */
    static String[] bigSorting(String[] unsorted) {

        Arrays.sort(unsorted, (x, y) -> {
            if (x.length() == y.length())
                return x.compareTo(y);
            else
                return x.length() - y.length();
        });

        return unsorted;
    }
}
