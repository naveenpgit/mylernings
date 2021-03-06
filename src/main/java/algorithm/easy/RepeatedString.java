package algorithm.easy;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class RepeatedString {
	// Complete the repeatedString function below.
	static long repeatedString(String s, long n) {

		if (s == null)
			return 0;
		if (s.length() == 1) {
			return s.equals("a") ? n : 0;
		}
		long countOf_a_ = Arrays.stream(s.split("")).filter(x -> x.equals("a")).count();

		long parts = n / s.length();
		int leftOver = (int) (n % s.length());

		long delta = Arrays.stream(s.substring(0, leftOver).split("")).filter(x -> x.equals("a")).count();

		return parts * countOf_a_ + delta;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void _main(String[] args) throws IOException {

		String s = scanner.nextLine();

		long n = scanner.nextLong();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		long result = repeatedString(s, n);

		System.out.println(result);
		scanner.close();
	}

	public static void main(String[] args) {
		System.out.println(repeatedString(
				"kmretasscityylpdhuwjirnqimlkcgxubxmsxpypgzxtenweirknjtasxtvxemtwxuarabssvqdnktqadhyktagjxoanknhgilnm",
				736778906400L));
	}
}
