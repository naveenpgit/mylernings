package leetcode;

import java.util.HashMap;
import java.util.Map;

public class FindPivot {
	public static void main(String[] args) {
		System.out.println(findIndex(new int[] { 5, 1, 4, 3, 6, 8, 10, 7, 9, 2 }));
	}

	static int findIndex(int[] arr) {
		int leftMax = Integer.MIN_VALUE;

		Map<Integer, Integer> memory = new HashMap<>();

		findMin(0, arr, memory);

		int result = -1;

		for (int i = 0; i < arr.length; i++) {
			int curVal = arr[i]; //5

			if (curVal > leftMax) {
				if (hasRighMinLessThanCurrVal(i, memory, curVal)) {
					leftMax = curVal;
				} else {
					result = i;
					break;
				}
			}
		}

		return result;
	}

	private static boolean hasRighMinLessThanCurrVal(int i, Map<Integer, Integer> memory, int curVal) {
		Integer temp = memory.get(i);
		return temp != null && temp < curVal;
	}

	private static Integer findMin(int i, int[] arr, Map<Integer, Integer> memory) {
		if (i == arr.length - 1) {
			memory.put(i, null);
			return null;
		}

		Integer val = findMin(i + 1, arr, memory);
		int temp = val == null ? arr[i + 1] : Math.min(arr[i + 1], val);
		memory.put(i, temp);
		return temp;
	}
}
