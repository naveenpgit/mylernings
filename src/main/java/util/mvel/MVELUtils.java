package util.mvel;

import org.mvel2.MVEL;

import java.util.Map;

public class MVELUtils {
	public static String extractStringValue(String expression,
			Map<String, Object> input) {
		String result = null;
		try {
			result = MVEL.evalToString(expression, input);
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
		return result;
	}
}
