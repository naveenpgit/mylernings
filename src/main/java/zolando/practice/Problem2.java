package zolando.practice;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Problem2 {
	public static void main(String[] args) {
//		System.out.println(solution("ccaaffddecee"));
//		System.out.println(solution("aaaabbbb"));
//		System.out.println(solution("eeee"));
//		System.out.println(solution("example"));

		System.out.println(solution_("ccaaffddeceeffff"));
//		System.out.println(solution_("aaaabbbb"));
//		System.out.println(solution_("eeee"));
//		System.out.println(solution_("example"));
	}

	static public int solution_(String S) {
		// write your code in Java SE 8
		Map<String, Long> map = Arrays.stream(S.split("")).collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()));
		//System.out.println(map); 
		//{c=3, a=2, f=2, d=2, e=3}
		Set<Long> temp = new HashSet<>();
		AtomicLong min = new AtomicLong(Long.MAX_VALUE);
		AtomicLong no_of_operations = new AtomicLong(0);
		map.values().stream().forEach(x -> {
			if (temp.add(x) == false) {
				Long nextMin = min.get() != 0 ? min.get() - 1 : 0;
				min.set(nextMin);
				temp.add(nextMin);
				no_of_operations.addAndGet(x - nextMin);
			}
			else {
				min.set(x < min.get() ? x : min.get());
			}
		});

		return no_of_operations.intValue();
	}

	static public int solution(String S) {
		// write your code in Java SE 8
		Map<String, Long> map = Arrays.stream(S.split("")).collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()));
		//System.out.println(map); 
		//{c=3, a=2, f=2, d=2, e=3}
		Set<Long> temp = new HashSet<>();
		AtomicInteger no_of_operations = new AtomicInteger(0);
		map.values().stream().forEach(x -> {
			if (temp.add(x) == false) {
				while (x != 0) {
					no_of_operations.incrementAndGet();
					if (temp.add(--x)) {
						break;
					}
				}
			}
		});

		return no_of_operations.get();
	}
}
