package practice;

public class BreakingtheRecords {

    /*
     * Complete the breakingRecords function below.
     */
    static int[] breakingRecords(int[] score) {
        /*
         * Write your code here.
         */

        int MIN = Integer.MAX_VALUE;
        int MAX = Integer.MIN_VALUE;

        int maxSwap = 0;
        int minSwap = 0;

        for (int s : score) {
            if (s < MIN) {
                if (MIN != Integer.MAX_VALUE)
                    minSwap++;

                MIN = s;
            }

            if (s > MAX) {
                if (MAX != Integer.MIN_VALUE)
                    maxSwap++;

                MAX = s;
            }

        }

        //System.out.println(maxSwap + " " + minSwap);
        return new int[]{maxSwap, minSwap};

    }

    public static void main(String[] args) {

        breakingRecords(new int[]{12, 24, 10, 24});
        breakingRecords(new int[]{10, 5, 20, 20, 4, 5, 2, 25, 1});
        breakingRecords(new int[]{3, 4, 21, 36, 10, 28, 35, 5, 24, 42});

    }
}
