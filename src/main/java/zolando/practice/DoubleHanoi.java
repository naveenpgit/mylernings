package zolando.practice;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class DoubleHanoi {
	public static void main(String[] args) {
		System.out.println(solution(new int[] { 4, 2, 3, 3 }, 3, 1));
		System.out.println(solution(new int[] { 1, 4, 5, 5 }, 6, 4));
		System.out.println(solution(new int[] { 5, 2, 5, 2 }, 8, 1));
		System.out.println(solution(new int[] { 1, 5, 5 }, 2, 4));
	}

	static int count = 0;

	static public int solution(int[] A, int L, int R) {
		int count = 0;
		Set<Integer> left = new HashSet<>();
		Set<Integer> right = new HashSet<>();
		left.add(L);
		right.add(R);
		for (int i : A) {
			if (i < L && left.add(i))
				count++;
			else if (i > R && right.add(i))
				count++;
		}
		return count;
	}

	static public int solution_(int[] A, int L, int R) {
		count = 0;
		A = right(A, R);
		A = left(A, L);
		return count;
	}

	static public int[] right(int[] A, int R) {
		// write your code in Java SE 8
		Arrays.sort(A); // 2334

		Set<Integer> right = new HashSet<>();
		right.add(R);
		for (int i = 0; i < A.length; i++) {
			if (A[i] != -1 && A[i] > R && right.add(A[i])) {
				R = A[i];
				count++;
				A[i] = -1;
			}
		}
		return A;
	}

	static public int[] left(int[] A, int L) {
		// write your code in Java SE 8
		A = Arrays.stream(A).boxed().filter(i -> i != -1)
				.sorted(Collections.reverseOrder())
				.mapToInt(Integer::intValue)
				.toArray();//5,5,4,1

		Set<Integer> left = new HashSet<>();
		left.add(L);
		for (int i = 0; i < A.length; i++) {
			if (A[i] != -1 && A[i] < L && left.add(A[i])) {
				L = A[i];
				count++;
				A[i] = -1;
			}
		}
		return A;
	}
}
