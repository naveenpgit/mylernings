package interviews.ncr;

import java.util.Arrays;

public class RollString {

    static String rollTheString(String s, int[] roll) {


        char[] chars = s.toCharArray();


        for (int i = 0; i < chars.length; i++) {
            final int index = i + 1;
            long rolls = Arrays.stream(roll).filter(x -> x >= index).count();
            long temp = chars[i] + rolls;
            temp = temp > 122 ? temp - 26 : temp;
            chars[i] = (char) temp;
        }

//        for (int i : roll) {
//
//            for (int start = 0; start < i; start++) {
//                int temp = chars[start] + 1;
//                temp = temp > 122 ? temp - 26 : temp;
//                chars[start] = (char) temp;
//            }
//
//        }

        String res = new String(chars);
        System.out.println(res);
        return res;
    }

    public static void main(String[] args) {
        rollTheString("vwxyz", new int[]{1, 2, 3, 4, 5});
        rollTheString("abz", new int[]{3});
        rollTheString("abz", new int[]{3, 2, 1});
        rollTheString("zcza", new int[]{1, 1, 3, 4});
    }
}
