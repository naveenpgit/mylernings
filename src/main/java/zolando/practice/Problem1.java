package zolando.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Problem1 {
	public static void main(String[] args) {
		System.out.println(solution("50552"));
		System.out.println(solution_("88"));
	}
	static public int solution(String S) {
		List<Integer> possibleCombinations = new ArrayList<>();
		for(int i =0;i<S.length()-1;i++){
			possibleCombinations.add(Integer.parseInt(String.valueOf(S.charAt(i))+String.valueOf(S.charAt(i+1))));
		}
		return possibleCombinations.stream().max(Integer::compare).get();
	}

	static public int solution_(String S) {
		int max = Integer.MIN_VALUE;
		for(int i =0;i<S.length()-1;i++){
			Integer temp = Integer.parseInt(String.valueOf(S.charAt(i))+String.valueOf(S.charAt(i+1)));
			max = temp>max?temp:max;
		}
		return max;
	}
}
