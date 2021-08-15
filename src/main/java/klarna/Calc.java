package klarna;

import org.junit.Test;

import java.util.Arrays;

import static java.lang.Double.parseDouble;
import static java.lang.String.valueOf;
import static java.util.stream.Collectors.joining;
import static org.junit.Assert.assertEquals;

public class Calc {
	public double evaluate(String expr) {
		// TODO: Your code here
		if (expr == null || expr.length() == 0)
			return 0;

		final String[] s = expr.split(" ");
		String last = s[s.length - 1];
		if (doesNotEndWithOperator(last)) {
			return parseDouble(last);
		}
		else {
			for (int i = 0; i < s.length - 2; i++) {
				boolean operationPerformed = false;
				switch (s[i + 2]) {
				case "+":
					s[i] = valueOf(parseDouble(s[i]) + parseDouble(s[i + 1]));
					operationPerformed = true;
					break;
				case "-":
					s[i] = valueOf(parseDouble(s[i]) - parseDouble(s[i + 1]));
					operationPerformed = true;
					break;
				case "*":
					s[i] = valueOf(parseDouble(s[i]) * parseDouble(s[i + 1]));
					operationPerformed = true;
					break;
				case "/":
					s[i] = valueOf(parseDouble(s[i]) / parseDouble(s[i + 1]));
					operationPerformed = true;
					break;
				}
				if (operationPerformed) {
					s[i + 1] = null;
					s[i + 2] = null;
					return evaluate(Arrays.stream(s).filter(temp -> temp != null).collect(joining(" ")));
				}
			}
			return 0;
		}
	}

	private boolean doesNotEndWithOperator(String expr) {
		return !(expr.endsWith("+") || expr.endsWith("*") || expr.endsWith("/") || expr.endsWith("-"));
	}

	@Test
	public void shouldParseFloats() {
		assertEquals(3.5, evaluate("1 2 3.5"), 0);
		assertEquals(4, evaluate("1 3 +"), 0);
		assertEquals(3, evaluate("1 3 *"), 0);
		assertEquals(-2, evaluate("1 3 -"), 0);
		assertEquals(2, evaluate("4 2 /"), 0);
		assertEquals(0, evaluate(""), 0);
		assertEquals(3, evaluate("1 2 3"), 0);
		assertEquals(14, evaluate("5 1 2 + 4 * + 3 -"), 0);
	}

}
