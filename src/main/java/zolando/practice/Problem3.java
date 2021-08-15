package zolando.practice;

import java.util.ArrayList;
import java.util.List;

public class Problem3 {
	public static void main(String[] args) {
		System.out.println(solution(new int[]{5,2, 10,6,13,7,8}));
	}
	static public int solution(int[] A) {
		// write your code in Java SE 8
		int min=Integer.MAX_VALUE;
		for(int i=1;i<A.length-3;i++){
			for(int j=i+2;j<A.length-1;j++){
				int cost = A[i]+A[j];
				min = cost<min?cost:min; 
			}
		}
		return min;
	}
}
