package morgan;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Pref {
	public static List<Integer> findCompletePrefixes(List<String> names, List<String> query) {
		// Write your code here
		List<Integer> res = new ArrayList<>();

		query.stream().forEach(q -> {
			int temp = (int) names.stream().filter(x -> x.startsWith(q) && x.length() != q.length()).count();
			res.add(temp);
		});

		return res;
	}

	public static void main(String[] args) {

		List<String> names = Arrays.asList(
				new String[] { "steve", "stevens", "danny", "steves", "dan", "john", "johnny", "joe", "alex", "alexander" });

		List<String> q = Arrays.asList(new String[] { "steve", "alex", "joe", "john", "dan" });

		System.out.println(Pref.findCompletePrefixes(names, q));
	}
}
