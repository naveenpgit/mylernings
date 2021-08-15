package zolando.practice;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FindLowestNotInArray {
	public static void main(String[] args) {
		System.out.println(solution(new int[] { 100000}));
	}

	static int solution(int[] A) {
		// write your code in Java SE 8
		//Arrays.sort(A);
		Set s = Arrays.stream(A).boxed().collect(Collectors.toSet());
		OptionalInt o = IntStream.rangeClosed(1, 100000).filter(i->s.add(i)).findFirst();
		return o.getAsInt();
	}
}
