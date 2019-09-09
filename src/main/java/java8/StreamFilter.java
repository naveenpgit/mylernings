package java8;

import java.util.Arrays;
import java.util.List;

public class StreamFilter {
	public static void main(String[] args) {
		List<Integer> nums = Arrays.asList(1, 3, 5, 7, 9, 2, 4);
		double res = nums.stream().filter(x -> x % 2 == 0)
				.map(y -> Math.pow(y, 3)).findFirst().orElse(0d);
		System.out.println(res);
	}
}
