package leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class WinCard {
	public static int solution(int[][] cards) {
		AtomicInteger res = new AtomicInteger(-1);

		for (int i = 0; i < cards.length; i++) {
			Map<Integer, Integer> count = new HashMap<>();
			for (int j = 0; j < cards[i].length; j++) {
				count.put(cards[i][j], count.getOrDefault(cards[i][j], 0) + 1);
			}

			count.entrySet().stream().filter(e -> e.getValue() == 1).forEach(e -> {
				res.set(Math.max(res.get(), e.getKey()));
			});
		}
		int o = res.get();
		System.out.println(o);
		return o;
	}

	public static void main(String[] args) {
		System.out.println("Hii");
		solution(new int[][] { { 5, 7, 3, 9, 4, 9, 8, 3, 1 }, { 1, 2, 2, 4, 4, 1 }, { 1, 2, 3 } });
	}
}
