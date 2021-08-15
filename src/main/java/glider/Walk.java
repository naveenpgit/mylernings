package glider;

public class Walk {
	public static void main(String[] args) {
		int n = 5;
		int count = 0;

		for (int i = 5; i > 0 && n != 0; i--) {
			count += n / i;
			n = n % i;
		}

		System.out.println(count);
	}

}
