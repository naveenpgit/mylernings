package java8;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortAlphaNumberic {
	public static void main(String[] args) {

		List<String> mastrList = Arrays.asList("ASSET_10", "ASSET_1", "ASSET_2", "ASSET_9");

		List<String> names = new ArrayList<>(mastrList);

		Collections.sort(names);
		System.out.println(names);

		System.out.println("-	-	-	-	-	- Lexical compare -	-	-	-	-	-	-");
		names = new ArrayList<>(mastrList);
		Collections.sort(names, new Comparator<String>() {
			@Override
			public int compare(String s1, String s2) {
				return StringUtils.compare(s1, s2);
			}
		});
		System.out.println(names);
	}
}
