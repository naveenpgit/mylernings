package unittesting;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class MyLearningConstants {
	public static final String ALPHABETS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

	public static Map<String, Integer> weightMap() {
		Map<String, Integer> weightMap = new HashMap<>();

		IntStream.range(0, 26).forEach(index -> {
			weightMap.put(String.valueOf(ALPHABETS.charAt(index)), ++index);
		});
		return weightMap;
	}
}
