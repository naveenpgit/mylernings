package leetcode;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualsK {
	public int subarraySum(int[] nums, int k) {
		Map<Integer, Integer> temp = new HashMap<>();
		temp.put(0, 1);
		int cummSum = 0;
		int count = 0;
		for (int i = 0; i < nums.length; i++) {
			cummSum += nums[i];
			int diff = cummSum - k;

			count += temp.getOrDefault(diff, 0);
			temp.put(cummSum, 1 + temp.getOrDefault(cummSum, 0));
		}

		return count;
	}

	public static void main(String[] args) {
		SubarraySumEqualsK subarraySumEqualsK = new SubarraySumEqualsK();
		//System.out.println(subarraySumEqualsK.subarraySum(new int[] { 1, 1, 1 }, 2));
		//System.out.println(subarraySumEqualsK.subarraySum(new int[] { 1, 2, 3 }, 3));
		//System.out.println(subarraySumEqualsK.subarraySum(new int[] { 3, 4, 7, 2, -3, 1, 4, 2 }, 7));
		//System.out.println(subarraySumEqualsK.subarraySum(new int[] { 1, 2, 1, 2, 1 }, 3));
		System.out.println(subarraySumEqualsK.subarraySum(new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, 0));
	}
}
