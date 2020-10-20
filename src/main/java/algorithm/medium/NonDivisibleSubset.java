package algorithm.medium;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

//https://www.hackerrank.com/challenges/non-divisible-subset/problem
public class NonDivisibleSubset {
	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {

		int n = scanner.nextInt();

		int k = scanner.nextInt();

		List<Integer> s = new ArrayList<>();

		IntStream.range(0, n).forEach(i -> {
			s.add(scanner.nextInt());
		});

		int result = nonDivisibleSubset(k, s);

		System.out.println(result);
		scanner.close();
	}

	public static int nonDivisibleSubset(int k, List<Integer> s) {
		// Write your code here

		List<Integer> subSet = new ArrayList<>();
		subSet.add(s.get(0));

		IntStream.range(1, s.size()).forEach(j -> {
			if (subSet.stream().noneMatch(i -> (i + s.get(j)) % k == 0))
				subSet.add(s.get(j));
		});

		return subSet.size();

	}
}
