package tenable;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test {
	public static void main(String[] args) {
		//System.out.println(minCost(2, Arrays.asList(0, 1, 0, 1, 1), Arrays.asList(4, 74, 47, 744, 7)));
		System.out.println(minCost(5, Arrays.asList(2, 4, 1, 3, 0), Arrays.asList(254885282, 259657351, 978290862, 160803756, 716976159)));

		System.out.println(210 % 105);
	}

	public static long minCost(int numProjects, List<Integer> projectId, List<Integer> bid) {
		Map<Integer, Long> projectVsMinBid = new HashMap<>();

		for (int i = 0; i < projectId.size(); i++) {
			final Integer currentProjectId = projectId.get(i);
			Long temp = projectVsMinBid.getOrDefault(currentProjectId, Long.MAX_VALUE);
			Integer curretBid = bid.get(i);
			projectVsMinBid.put(currentProjectId, Math.min(temp, curretBid));
		}

		if (projectVsMinBid.size() != numProjects) {
			return -1;
		}

		return projectVsMinBid.values().stream().mapToLong(Long::longValue).sum();
	}
}
