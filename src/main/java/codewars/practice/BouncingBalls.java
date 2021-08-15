package codewars.practice;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BouncingBalls {
	public static int bouncingBall(double h, double bounce, double window) {
		// your code

		if (h <= 0 || bounce <= 0 || bounce >= 1 || window >= h) {
			return -1;
		}
		int count = -1;
		while (h > window) {
			count++;
			h *= bounce;
		}
		return count * 2 + 1;
	}

	@Test
	public void test1() {
		assertEquals(3, bouncingBall(3.0, 0.66, 1.5));
	}

	@Test
	public void test2() {
		assertEquals(15, bouncingBall(30.0, 0.66, 1.5));
	}
}
