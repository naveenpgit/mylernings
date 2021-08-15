package codewars.practice;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertArrayEquals;

public class TribonacciSequence {

	private double precision = 1e-10;

	@Test
	public void sampleTests() {
		assertArrayEquals(new double[] { 1, 1, 1, 3, 5, 9, 17, 31, 57, 105 }, tribonacci(new double[] { 1, 1, 1 }, 10), precision);
		assertArrayEquals(new double[] { 0, 0, 1, 1, 2, 4, 7, 13, 24, 44 }, tribonacci(new double[] { 0, 0, 1 }, 10), precision);
		assertArrayEquals(new double[] { 0, 1, 1, 2, 4, 7, 13, 24, 44, 81 }, tribonacci(new double[] { 0, 1, 1 }, 10), precision);
	}

	public double[] tribonacci(double[] s, int n) {
		// hackonacci me
		int lim = n;
		n = n - s.length;
		List<Double> res = new ArrayList<>();
		Arrays.stream(s).boxed().forEach(res::add);
		while (n-- > 0) {
			final double next = Arrays.stream(s).sum();
			res.add(next);
			s[0] = s[1];
			s[1] = s[2];
			s[2] = next;
		}
		return res.stream().limit(lim).mapToDouble(x -> x).toArray();
	}
}
