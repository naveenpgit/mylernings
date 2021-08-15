package codewars.practice;

import java.util.Arrays;

public class ShortestWord {
	public static int findShort(String s) {
		return Arrays.stream(s.split(" ")).filter(x -> !x.isEmpty()).map(x -> x.length()).min(Integer::compare).get();
	}

	public static void main(String[] args) {
		System.out.println(findShort("bitcoin take over the world maybe who knows perhaps"));
		System.out.println(findShort("turns out random test cases are easier than writing out basic ones"));
		System.out.println(findShort("Let's travel abroad shall we"));
	}
}
