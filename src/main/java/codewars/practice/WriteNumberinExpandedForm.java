package codewars.practice;

import org.junit.Test;

import java.util.LinkedList;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;

public class WriteNumberinExpandedForm {
	public static String expandedForm(int num) {
		//your code here
		LinkedList<Integer> split = new LinkedList<>();
		int power = 0;
		while (num > 0) {
			int temp = num % 10;
			if (temp != 0)
				split.addFirst(temp * (int) Math.pow(10, power));

			power++;
			num /= 10;
		}
		return split.stream().map(String::valueOf).collect(Collectors.joining(" + "));
	}

	@Test
	public void testSomething() {
		assertEquals("10 + 2", expandedForm(12));
		assertEquals("40 + 2", expandedForm(42));
		assertEquals("70000 + 300 + 4", expandedForm(70304));
	}
}
