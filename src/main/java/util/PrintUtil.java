package util;

import static java.lang.String.valueOf;
import static java.util.Arrays.stream;
import static java.util.stream.Collectors.joining;

public class PrintUtil {
	public static void printArray(int[] twoSum) {
		System.out.println(stream(twoSum)
				.mapToObj(x -> valueOf(x))
				.collect(joining(",")));
	}
}
