package morgan;

import java.util.HashMap;
import java.util.Map;

public class Anagram {
	public static int getAnagram(String s) {

		int half = s.length() / 2;

		Map<Character, Integer> lMap = new HashMap<>();
		Map<Character, Integer> rMap = new HashMap<>();

		for (int i = 0; i < s.length(); i++) {
			char temp = s.charAt(i);
			if (i < half)
				lMap.put(temp, lMap.getOrDefault(temp, 0) + 1);
			else
				rMap.put(temp, rMap.getOrDefault(temp, 0) + 1);
		}

		for (Character temp : lMap.keySet()) {
			if (rMap.containsKey(temp)) {
				rMap.put(temp, rMap.get(temp) - 1);
				lMap.put(temp, lMap.get(temp) - 1);
				half--;
			}
		}
		for (Character temp : rMap.keySet()) {
			if (lMap.containsKey(temp)) {
				rMap.put(temp, rMap.get(temp) - 1);
				lMap.put(temp, lMap.get(temp) - 1);
				half--;
			}
		}
		return half;

	}

	public static void main(String[] args) {
		System.out.println(Anagram.getAnagram("111111"));
	}
}
