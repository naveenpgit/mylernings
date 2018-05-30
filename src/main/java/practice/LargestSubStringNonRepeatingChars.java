package practice;

public class LargestSubStringNonRepeatingChars {


    public static void main(String[] args) {
        System.out.println(findLongestSubString("abcabcbb")); // abc
        System.out.println(findLongestSubString("bbbbb")); //b
        System.out.println(findLongestSubString("pwwkew")); // wke
        System.out.println(findLongestSubString("geeksforgeeks")); // eksforg
        System.out.println(findLongestSubString("ABDEFGABEF")); //ABDEFG
        System.out.println(findLongestSubString("qwertqwer")); // qwert
        System.out.println(findLongestSubString("qwertyuioijhghmnbvcdswwazxcv"));//ghmnbvcdsw
    }

    static String findLongestSubString(String input) {
        char[] s = input.toCharArray();

        String temp = "", longest = "";

        for (char c : s) {
            if (temp.contains(c + "")) {
                temp = temp.substring(temp.indexOf(c) + 1) + c;
            } else {
                temp += c;
                if (temp.length() > longest.length()) {
                    longest = temp;
                }
            }

        }
        return longest;
    }
}
