package leetcode;

public class KedanesAlgo {
	public static int maxSubArray(int[] nums) {

		int max_sum = Integer.MIN_VALUE;
		int temp = 0;
		for (int i = 0; i < nums.length; i++) {

			temp += nums[i];
			if (temp > max_sum)
				max_sum = temp;
			if (temp < 0)
				temp = 0;
		}
		return max_sum;
	}

	public static void main(String[] args) {
		System.out.println(maxSubArray(new int[] { 5, 4, -1, 7, 8 }));
	}
}