package morgan;

import static java.util.Arrays.stream;
import static java.util.stream.Collectors.joining;

public class SortAnArrayOf0s1sn2s {
	public static void main(String[] args) {
		SortAnArrayOf0s1sn2s sortAnArrayOf0s1sn2s = new SortAnArrayOf0s1sn2s();
		sortAnArrayOf0s1sn2s.sort012(new int[] { 0, 2, 1, 2, 0 }, 5);
		sortAnArrayOf0s1sn2s.sort012(new int[] { 0, 1, 0 }, 3);
	}

	void sort012(int a[], int n) {
		int low = 0, mid = 0, high = n - 1, temp = 0;
		while (mid <= high) {
			switch (a[mid]) {
			case 0:
				temp = a[low];
				a[low] = a[mid];
				a[mid] = temp;
				low++;
				mid++;
				break;
			case 1:
				mid++;
				break;
			case 2:
				temp = a[high];
				a[high] = a[mid];
				a[mid] = temp;
				high--;
				break;
			}
		}
		System.out.println(stream(a).mapToObj(String::valueOf).collect(joining(" ")));
	}

}
