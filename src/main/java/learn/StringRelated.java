package learn;

public class StringRelated {
	public static void main(String[] args) {
		String s1 = "naveen";

		String s2= "naveen";

		String s3 = new String("naveen");

		String s4 = s3.intern();

		System.out.println(s1 == s2);
		System.out.println(s1 == s3);
		System.out.println(s1.equalsIgnoreCase(s3));
		System.out.println(s1 == s4);
	}
}
