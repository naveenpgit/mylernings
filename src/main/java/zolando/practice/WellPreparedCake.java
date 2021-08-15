package zolando.practice;

import java.util.Arrays;

public class WellPreparedCake {
	public static void main(String[] args) {
		System.out.println(solution(5, 3, new int[] { 1, 1, 4, 1, 4 }, new int[] { 5, 2, 5, 5, 4 }, new int[] { 1, 2, 2, 3, 3 }));
		System.out.println(solution(6, 4, new int[] { 1, 2, 1, 1 }, new int[] { 3, 3, 6, 6 }, new int[] { 1, 2, 3, 4 }));
	}

	static public int solution(int N, int K, int[] A, int[] B, int[] C) {
		// write your code in Java SE 8
		int[] rec = new int[N];
		Arrays.fill(rec, 0);
		for (int i = 0; i < C.length; i++) {
			int flavour = C[i], start = A[i], end = B[i];
			for (int x = start - 1; x < end; x++) {
				if (flavour - rec[x] == 1)
					rec[x] = flavour;
				else {
					rec[x] = -1;
				}
			}
		}
		return ((Long) Arrays.stream(rec).filter(i -> i != -1 && 1 != 0).count()).intValue();
	}
}
