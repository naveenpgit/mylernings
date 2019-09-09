package learn;

public class StringPassby {
	public static void main(String[] args) {
		String s = "naveen";
		update(s);
		System.out.println(s);
		s = updateV2(s);
		System.out.println(s);

		String s1 = new String("naveen");
		update(s1);
		System.out.println(s1);
		s1 = updateV2(s1);
		System.out.println(s1);
	}

	static void update(String in) {
		in = "Update";
	}

	static String updateV2(String in) {
		in = "updated";
		return in;
	}
}

