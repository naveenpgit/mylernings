package klarna;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CreditCard {
	public static String maskify(String creditCardNumber) {
		// Add code here
		if (creditCardNumber == null || creditCardNumber.length() < 6) {
			return creditCardNumber;
		}
		String temp = creditCardNumber.substring(1, creditCardNumber.length() - 4);
		temp = temp.replaceAll("\\d", "#");
		return creditCardNumber.charAt(0) + temp + creditCardNumber.substring(creditCardNumber.length() - 4);
	}

	@Test
	public void shouldMaskDigitsForBasicCreditCards() {
		assertEquals("5###########0694", CreditCard.maskify("5512103073210694"));
	}

	@Test
	public void shouldNotMaskDigitsForShortCreditCards() {
		assertEquals("54321", CreditCard.maskify("54321"));
	}
}
