package practice;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.joining;

public class LeftRotation {
	private static final Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		int[] A = { 3, 8, 9, 7, 6 };
		int rotation = 0;

		int n = A.length;
		int[] res = new int[n];
		int count = 0;
		if (rotation != 0 && A.length > 0) {
			rotation = rotation >= n ? rotation % n : rotation;
			for (int i = n - rotation; count < n; i++) {
				res[count++] = i < n ? A[i] : A[i - n];
			}
		}
		else {
			res = A;
		}
		System.out.println(Arrays.stream(res).boxed().collect(Collectors.toList()));
	}
}
