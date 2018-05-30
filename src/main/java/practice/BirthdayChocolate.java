//https://www.hackerrank.com/challenges/the-birthday-bar/problem

package practice;

public class BirthdayChocolate {
    static int solve(int n, int[] s, int d, int m) {
        // Complete this function

        int start = 0;
        int end = start + m - 1;

        int count = 0;

        while (end != n) {

            if (getSum(s, start, end) == d)
                count++;

            start++;
            end++;
        }

        //System.out.println(count);
        return count;
    }

    static int getSum(int[] s, int start, int end) {
        int sum = 0;
        for (int i = start; i <= end; i++) {
            sum += s[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        solve(5, new int[]{1, 2, 1, 3, 2}, 3, 2);//2
        solve(6, new int[]{1, 1, 1, 1, 1, 1}, 3, 2); //0
        solve(1, new int[]{4}, 4, 1); //1
    }
}
