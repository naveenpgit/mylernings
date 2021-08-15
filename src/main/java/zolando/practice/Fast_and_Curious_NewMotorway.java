package zolando.practice;

import static java.lang.Math.min;

public class Fast_and_Curious_NewMotorway {
	public static void main(String[] args) {
		int best = solution(new int[] { 1, 5, 9, 12 });
		System.out.println("Best : " + best);
	}

	static int solution(int[] A) {
		long cost = 0;
		int N = A.length;
		for (int i = 1; i < N; i++) {
			cost += (A[N - 1] - A[i]);
		}
		//System.out.println("Total Cost if the motorway was built at first city : " + cost);
		long best = cost;
		for (int i = 0; i < N - 1; i++) { // if the motor was was built at X+1 city
			cost -= (A[N - 1] - A[i + 1]);  // cost would reduce by 
			cost += (i + 1) * (A[i + 1] - A[i]); // But all cities before X+1 need to travel A[X+1] - A[X] distance additionally
			best = min(best, cost);
		}

		//System.out.println("Best : " + best);
		return (int) (best % (Math.pow(10, 9) + 7));
	}
}
