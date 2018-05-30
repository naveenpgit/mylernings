//https://www.hackerrank.com/challenges/counting-valleys/problem
package practice;

import java.util.Scanner;

public class CountingValleys {
    public static void main(String[] args) {

        //System.out.println(countingValleys(8, "UDDDUDUU"));

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String s = scanner.next();
        System.out.println(countingValleys(n, s));
    }

    static int countingValleys(int n, String s) {

        int valleyCount = 0;
        int current = 0;
        boolean enteredValley = false;
        for (String ch : s.split("")) {

            if ("D".equals(ch)) {
                current--;
            } else if ("U".equals(ch)) {
                current++;
            }

            if (current < 0 && !enteredValley) {
                enteredValley = true;
                valleyCount++;

            } else if (current >= 0 && enteredValley) {
                enteredValley = false;
            }
        }

        return valleyCount;

    }
}
