package leetcode;

import java.util.HashMap;
import java.util.Map;

import static util.PrintUtil.printArray;

//https://leetcode.com/problems/two-sum/
public class TwoSumSorted {
	public static void main(String[] args) {
		TwoSumSorted twoSum = new TwoSumSorted();

		printArray(twoSum.twoSum(new int[] { 2, 7, 11, 15 }, 9));
		printArray(twoSum.twoSum(new int[] { 2, 3, 4 }, 6));
		printArray(twoSum.twoSum(new int[] { -1, 0 }, -1));
	}

	public int[] twoSum(int[] nums, int target) {

		Map<Integer, Integer> map = new HashMap<>();

		for (int i = 0; i < nums.length; i++) {
			final int currentIndex = i;
			int current = nums[i];
			if (current > target)
				break;
			Integer targetIndex = map.get(target - current);
			if (targetIndex == null) {
				map.put(current, i);
			} else {
				return new int[] { targetIndex + 1, currentIndex + 1 };
			}
		}
		return new int[] {};
	}
}
