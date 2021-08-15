package zolando.practice;

import java.util.Arrays;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

public class OddOccurrencesInArray {
	public static void main(String[] args) {
		int[] in = {9,3,9,3,9,7,9};
		System.out.println(solution(in));
	}
	static public int solution(int[] A){
		Map<Integer, Long> map = Arrays.stream(A).boxed().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

		return  map.entrySet().stream().filter(e -> e.getValue() % 2 != 0).findFirst().get().getKey();
	}
}
