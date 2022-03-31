package leetcode;

import org.springframework.util.StopWatch;

import java.util.ArrayList;
import java.util.List;

public class FizzBuzz {

	public static void fizzBuzz(int n) {

		List<String> res = new ArrayList<>();
		// Write your code here
		for (int i = 1; i <= n; i++) {
			if (i % 3 == 0 && i % 5 == 0) {
				res.add("FizzBuzz");
			} else if (i % 3 == 0 && i % 5 != 0) {
				res.add("Fizz");
			} else if (i % 5 == 0 && i % 3 != 0) {
				res.add("Buzz");
			} else if (i % 5 != 0 && i % 3 != 0) {
				res.add(String.valueOf(i));
			}
		}
	}

	public static void main(String[] args) throws InterruptedException {
		StopWatch watch = new StopWatch();
		watch.start();
		fizzBuzz(3);
		watch.stop();
		System.out.println(watch.getTotalTimeMillis());
	}
}
