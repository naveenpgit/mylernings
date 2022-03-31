package leetcode;

import static java.lang.Integer.MAX_VALUE;
import static java.lang.Integer.MIN_VALUE;

//https://leetcode.com/problems/reverse-integer/
public class ReverseInteger {
	public int reverse(int x) {
		long rev = 0;
		while (x != 0) {
			rev = rev * 10 + x % 10;
			x = x / 10;
		}

		return rev <= MAX_VALUE && rev >= MIN_VALUE ? (int) rev : 0;
	}

	public static void main(String[] args) {
		ReverseInteger reverseInteger = new ReverseInteger();
		System.out.println(reverseInteger.reverse(1534236469));
	}
}
