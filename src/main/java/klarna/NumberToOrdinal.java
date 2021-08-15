package klarna;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class NumberToOrdinal {
	public static String numberToOrdinal(Integer number) {

		if (number == 0) {
			return String.valueOf(number);
		}
		String suffix = "th";
		int last2Digits = number % 100;
		if (last2Digits >= 11 && last2Digits <= 19) {
			suffix = "th";
		}
		else {
			int lastDigit = number % 10;
			switch (lastDigit) {
			case 1:
				suffix = "st";
				break;
			case 2:
				suffix = "nd";
				break;
			case 3:
				suffix = "rd";
				break;
			}

		}
		return String.valueOf(number) + suffix;
	}

	@Test
	public void shouldHandleSingleDigits() {
		assertEquals("1st", numberToOrdinal(1));
		assertEquals("2nd", numberToOrdinal(2));
		assertEquals("3rd", numberToOrdinal(3));
		assertEquals("21st", numberToOrdinal(21));
		assertEquals("113th", numberToOrdinal(113));
		assertEquals("0", numberToOrdinal(0));
	}
}
