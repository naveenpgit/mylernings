package practice;

import java.util.Scanner;

public class LongestCommonPrefixinanArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int t = scanner.nextInt();

        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt();

            String[] in = new String[n];
            String smallest = null;
            for (int j = 0; j < n; j++) {
                String temp = scanner.next();
                in[j] = temp;

                if (smallest == null || temp.length() < smallest.length())
                    smallest = temp;
            }

            //longestCommonPrefixinanArray(in, smallest);
            System.out.println(better_LongestCommonPrefixinanArray(in, smallest));
        }
    }

    private static void longestCommonPrefixinanArray(String[] in, String smallest) {
        String res = "";

        char[] blah = smallest.toCharArray();
        for (char c : blah) {
            String temp = res + c;
            boolean found = true;
            for (String current : in) {
                if (!current.startsWith(temp)) {
                    found = false;
                    break;
                }
            }
            if (found)
                res += c;
        }

        System.out.println(res.length() == 0 ? -1 : res);
    }

    private static String better_LongestCommonPrefixinanArray(String[] in, String smallest) {

        for (String s : in) {
            if (!s.startsWith(smallest)) {
                return better_LongestCommonPrefixinanArray(in, smallest.substring(0, smallest.length() - 1));
            }
        }

        return smallest;
    }
}
