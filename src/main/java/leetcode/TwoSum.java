package leetcode;

import java.util.HashMap;
import java.util.Map;

import static util.PrintUtil.printArray;

//https://leetcode.com/problems/two-sum/
public class TwoSum {
	public static void main(String[] args) {
		TwoSum twoSum = new TwoSum();

		printArray(twoSum.twoSum(new int[] { 2, 7, 11, 15 }, 9));
		printArray(twoSum.twoSum(new int[] { 3, 2, 4 }, 6));
		printArray(twoSum.twoSum(new int[] { 3, 3 }, 6));
	}

	public int[] twoSum(int[] nums, int target) {

		Map<Integer, Integer> map = new HashMap<>();

		for (int i = 0; i < nums.length; i++) {
			final int currentIndex = i;
			int current = nums[i];
			Integer targetIndex = map.get(target - current);
			if (targetIndex == null) {
				map.put(current, i);
			} else {
				return new int[] { targetIndex, currentIndex };
			}
		}
		return new int[] {};
	}
}
