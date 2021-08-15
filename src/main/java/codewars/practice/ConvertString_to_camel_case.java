package codewars.practice;

public class ConvertString_to_camel_case {
	public static void main(String[] args) {
		System.out.println(toCamelCase(""));
	}

	static String toCamelCase(String s) {
		if (s == null || s.length() == 0) {
			return s;
		}
		final String[] split = s.split("(?:-|_).{0}");

		StringBuffer res = new StringBuffer();

		if (split[0].length() > 0) {
			res.append(split[0].charAt(0));
			if (split[0].length() > 1)
				res.append(split[0].substring(1).toLowerCase());
		}

		if (split.length > 1) {
			for (int i = 1; i < split.length; i++) {
				if (split[0].length() > 0) {
					res.append(Character.toUpperCase(split[i].charAt(0)));
					if (split[0].length() > 1)
						res.append(split[i].substring(1).toLowerCase());
				}
			}
		}
		return res.toString();
	}
}
