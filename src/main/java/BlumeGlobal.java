import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.text.MessageFormat.format;

public class BlumeGlobal {
	public static void main(String[] args) {
		int[] in = { 2, 7, 1, 8 };

		//myMethod(in);
		candi(in);
	}

	private static void myMethod(int[] in) {
		Map<Integer, List<String>> possibleSums = new HashMap<>();

		for (int i = 0; i < in.length - 1; i++) {
			for (int j = i + 1; j < in.length; j++) {
				int sum = in[i] + in[j];
				String pair = format("({0},{1})", in[i], in[j]);
				if (possibleSums.containsKey(sum)) {
					possibleSums.get(sum).add(pair);
				}
				else {
					List<String> pairs = new ArrayList<>();
					pairs.add(pair);
					possibleSums.put(sum, pairs);
				}
			}
		}

		possibleSums.forEach((k, v) -> {
			System.out.println(format("{0} --> {1}", k, v.stream().collect(Collectors.joining(" "))));
		});
	}

	private static void candi(int[] arr) {
		Map<Integer, String> map = new HashMap<>();
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				if (i != j) {
					int sum = arr[i] + arr[j];
					if (map.containsKey(sum)) {
						//map.put(sum,"("+arr[i]+","+arr[j]+")")
						String value = map.get(sum) + ",(" + arr[i] + "," + arr[j] + ")";
						map.put(sum, value);
					}
					else {
						map.put(sum, "(" + arr[i] + "," + arr[j] + ")");
					}
				}
			}

		}

		System.out.println(map);
	}
}
