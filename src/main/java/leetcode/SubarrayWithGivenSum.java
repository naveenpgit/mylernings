package leetcode;

import java.util.ArrayList;

//https://practice.geeksforgeeks.org/problems/subarray-with-given-sum-1587115621/1
public class SubarrayWithGivenSum {
	static ArrayList<Integer> subarraySum(int[] arr, int n, int s) {
		// Your code here
		int left = 0;
		int right = 0;
		ArrayList<Integer> res = new ArrayList<>();
		if (n == 1) {
			if (arr[0] == s) {
				res.add(left + 1);
				res.add(right + 1);
			} else {
				res.add(-1);
			}
			return res;
		}

		int sum = 0;
		for (; right < n; ) {
			if (sum == s) {
				res.add(left + 1);
				res.add(right);
				return res;
			} else if (sum > s) {
				sum -= arr[left];
				left++;
			} else {
				sum += arr[right];
				right++;
			}
		}
		res.add(-1);
		return res;
	}

	public static void main(String[] args) {
		System.out.println(subarraySum(new int[] { 1, 2, 3, 7, 5 }, 5, 12));
		System.out.println(subarraySum(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 }, 10, 15));
		System.out.println(subarraySum(new int[] { 1, 2, 3 }, 3, 5));
//		System.out.println(subarraySum(
//				new int[] { 135, 101, 170, 125, 79, 159, 163, 65, 106, 146, 82, 28, 162, 92, 196, 143, 28, 37, 192, 5, 103, 154, 93, 183, 22, 117,
//						119, 96, 48, 127, 172, 139, 70, 113, 68, 100, 36, 95, 104, 12, 123, 134 }, 42, 468));
	}
}
