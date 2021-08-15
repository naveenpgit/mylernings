package codewars.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EnoughIsEnough {

	public static void main(String[] args) {
		System.out.println(deleteNth(new int[] { 1, 2, 3, 4, 5 }, 0));
	}

	public static int[] deleteNth(int[] elements, int maxOccurrences) {
		//Code here ;)

		List<Integer> res = new ArrayList<>();
		if (maxOccurrences > 0) {
			Map<Integer, Integer> count = new HashMap<>();
			Arrays.stream(elements).boxed().forEach(i -> {
				if (count.get(i) == null) {
					count.put(i, 1);
					res.add(i);
				}
				else if (count.get(i) < maxOccurrences) {
					count.put(i, count.get(i) + 1);
					res.add(i);
				}
			});
		}
		return res.stream().mapToInt(x -> x).toArray();
	}

}