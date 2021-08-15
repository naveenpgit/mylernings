package codewars.practice;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class PersistentBugger {
	public static int persistence(long n) {
		// your code
		int count = 0;
		while (n >= 10) {
			n = multiply(n);
			count++;
		}
		return count;
	}

	static long multiply(long n) {
		return Arrays.stream(String.valueOf(n).split("")).mapToLong(s -> Long.valueOf(s)).reduce(1, (a, b) -> a * b);
	}

	@Test
	public void BasicTests() {
		System.out.println("****** Basic Tests ******");
		assertEquals(3, persistence(39));
		assertEquals(0, persistence(4));
		assertEquals(2, persistence(25));
		assertEquals(4, persistence(999));
	}
}
