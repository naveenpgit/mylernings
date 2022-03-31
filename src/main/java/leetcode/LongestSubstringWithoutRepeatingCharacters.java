package leetcode;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {

	public static void main(String[] args) {
		LongestSubstringWithoutRepeatingCharacters main = new LongestSubstringWithoutRepeatingCharacters();
		System.out.println(main.lengthOfLongestSubstring("abba"));//2
		System.out.println(main.lengthOfLongestSubstring("pwwkew"));//3
	}

	public int lengthOfLongestSubstring(String s) {
		int res = 0;
		Set<String> temp = new HashSet<>();
		String[] s_arr = s.split("");
		int left = 0;
		for (int right = 0; right < s.length(); right++) {
			while (temp.contains(s_arr[right])) {
				temp.remove(s_arr[left]);
				left++;
			}
			temp.add(s_arr[right]);
			res = Math.max(res, right - left + 1);
		}
		return res;
	}
}
