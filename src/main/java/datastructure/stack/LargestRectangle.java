package datastructure.stack;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class LargestRectangle {
	// Complete the largestRectangle function below.
	static long largestRectangle(int[] h) {

		long res = Long.MIN_VALUE;
		while (h.length != 0) {
			long temp = Arrays.stream(h).min().getAsInt() * h.length;
			if (temp > res)
				res = temp;

			h = Arrays.copyOfRange(h, 1, h.length);
		}
		return res;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {

		int n = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		int[] h = new int[n];

		String[] hItems = scanner.nextLine().split(" ");
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int i = 0; i < n; i++) {
			int hItem = Integer.parseInt(hItems[i]);
			h[i] = hItem;
		}

		long result = largestRectangle(h);

		System.out.println(result);
		scanner.close();
	}
}
