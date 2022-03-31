package leetcode;

public class FindTheDuplicateNumber {
	public int findDuplicate(int[] nums) {

		int slow = 0, fast = 0;

		while (true) {
			slow = nums[slow];
			fast = nums[nums[fast]];

			if (slow == fast)
				break;
		}

		int slow_2 = 0;
		while (true) {
			slow = nums[slow];
			slow_2 = nums[slow_2];
			if (slow == slow_2)
				break;
		}
		return slow;
	}

	public static void main(String[] args) {

		FindTheDuplicateNumber findTheDuplicateNumber = new FindTheDuplicateNumber();
		System.out.println(findTheDuplicateNumber.findDuplicate(new int[] { 1, 3, 4, 2, 2 }));
		//System.out.println(findTheDuplicateNumber.findDuplicate(new int[] { 3, 1, 3, 4, 2 }));
	}
}
