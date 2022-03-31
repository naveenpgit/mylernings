package java8;

import java.util.Map;
import java.util.TreeMap;

import static java.util.Arrays.stream;
import static java.util.function.Function.identity;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;
import static org.apache.commons.lang3.StringUtils.isNotEmpty;

public class CountVowels {
	public static void main(String[] args) {
		String s = "Hello hi";
		final Map<String, Long> collect = stream(s.toLowerCase().split(""))// [h e l l o " " h i]
				.map(String::trim)// [h e l l o "" h i]
				.filter(x -> isNotEmpty(x)) // [h e l l o h i]
				.collect(groupingBy(identity(), counting()));

		System.out.println(new TreeMap<String, Long>(collect));

		Map<String, Long> collect_ = new TreeMap<String, Long>();
		for (String temp : s.toLowerCase().split("")) {
			if (temp != null && isNotEmpty(temp.trim())) {
				temp = temp.trim();
				if (collect_.containsKey(temp)) {
					long count = collect_.get(temp);
					collect_.put(temp, count + 1);
				} else {
					collect_.put(temp, 1L);
				}
			}
		}
		System.out.println(collect_);
	}
}
