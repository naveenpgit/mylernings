package practice;

public class DrawingBook {
    static int pageCount(int n, int p) {
        /*
         * Write your code here.
         */

        int res = 0;
        int forward = 0;
        int backward = 0;

        int start = 1;
        int end = n % 2 == 1 ? n - 1 : n;
        while (start <= end) {
            if (p <= start) {
                res = forward;
                break;
            } else if (p >= end) {
                res = backward;
                break;
            } else {
                start += 2;
                forward++;
                end -= 2;
                backward++;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(pageCount(6, 2));
        System.out.println(pageCount(5, 4));
        System.out.println(pageCount(21235, 17));
    }
}
