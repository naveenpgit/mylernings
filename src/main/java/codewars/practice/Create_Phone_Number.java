package codewars.practice;

import java.text.MessageFormat;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Create_Phone_Number {
	public static void main(String[] args) {
		System.out.println(createPhoneNumber(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 0 }));
	}

	public static String createPhoneNumber(int[] numbers) {
		// Your code here!
		String out = "({0}) {1}-{2}";

		String res = MessageFormat.format(out,
				Arrays.stream(Arrays.copyOfRange(numbers, 0, 3)).boxed().map(String::valueOf).collect(Collectors.joining("")),
				Arrays.stream(Arrays.copyOfRange(numbers, 3, 6)).boxed().map(String::valueOf).collect(Collectors.joining("")),
				Arrays.stream(Arrays.copyOfRange(numbers, 6, 10)).boxed().map(String::valueOf).collect(Collectors.joining(""))
		);
		return res;
	}
}
