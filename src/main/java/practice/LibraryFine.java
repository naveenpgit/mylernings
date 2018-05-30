package practice;

import java.util.Scanner;

public class LibraryFine {
    static int libraryFine(int da, int ma, int ya, int de, int me, int ye) {

        int result = 0;
        // Complete this function

        if (ye > ya || (ye == ya && me > ma) || (ye == ya && me == ma && de > da)) {
            result = 0;
        } else {
            if (ye < ya) {
                result = 10000;
            } else if (me < ma) {
                result = 500 * (ma - me);
            } else if (de < da) {
                result = 15 * (da - de);
            }
        }


        return result;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int d1 = in.nextInt();
        int m1 = in.nextInt();
        int y1 = in.nextInt();
        int d2 = in.nextInt();
        int m2 = in.nextInt();
        int y2 = in.nextInt();
        int result = libraryFine(d1, m1, y1, d2, m2, y2);
        System.out.println(result);
        in.close();
    }
}
