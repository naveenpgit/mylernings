package leetcode;

import java.util.Arrays;

import static java.lang.String.valueOf;
import static java.util.stream.Collectors.joining;

//https://leetcode.com/problems/rotate-array/
public class RotateArray {
	public void rotate(int[] nums, int k) {
		k = k % nums.length;
		reverse(nums, 0, nums.length - k - 1);
		reverse(nums, nums.length - k, nums.length - 1);
		reverse(nums, 0, nums.length - 1);
		System.out.println(Arrays.stream(nums).mapToObj(i -> valueOf(i)).collect(joining(",")));
	}

	void reverse(int[] arr, int start, int end) {

		int left = start, right = end;

		while (left < right) {
			int temp = arr[left];
			arr[left] = arr[right];
			arr[right] = temp;
			left++;
			right--;
		}

	}

	public static void main(String[] args) {
		RotateArray rotateArray = new RotateArray();
		//rotateArray.rotate(new int[] { 1, 2, 3, 4, 5, 6, 7 }, 3);
		//	rotateArray.rotate(new int[] { -1, -100, 3, 99 }, 2);
		rotateArray.rotate(new int[] { -1, -100, 3, 99 }, 0);
	}
}
