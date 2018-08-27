//https://www.hackerrank.com/challenges/weighted-uniform-string/problem?h_r=internal-search

package algorithm.easy;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class WeightedUniformStrings {

	// Complete the weightedUniformStrings function below.
	static String[] weightedUniformStrings(String s, int[] queries) {
		char[] charArray = s.toCharArray();
		Set<Integer> numList = new HashSet<Integer>();
		int contigentString = 1;
		int lastAlphaNum = 0;
		for (char c : charArray) {
			int alphaNum = c - 'a' + 1;
			if (alphaNum == lastAlphaNum) {
				contigentString++;
			}
			else {
				contigentString = 1;
				lastAlphaNum = alphaNum;
			}
			numList.add(alphaNum * contigentString);
		}

		return Arrays.stream(queries)
				.mapToObj(x -> numList.contains(x) ? "Yes" : "No")
				.toArray(String[]::new);
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		String s = scanner.nextLine();

		int queriesCount = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		int[] queries = new int[queriesCount];

		for (int i = 0; i < queriesCount; i++) {
			int queriesItem = scanner.nextInt();
			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
			queries[i] = queriesItem;
		}

		String[] result = weightedUniformStrings(s, queries);

		for (int i = 0; i < result.length; i++) {
			System.out.println(result[i]);
		}

		scanner.close();
	}
}
